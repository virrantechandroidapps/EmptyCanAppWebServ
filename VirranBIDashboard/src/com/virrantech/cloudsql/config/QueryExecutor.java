package com.virrantech.cloudsql.config;


import com.google.appengine.api.ThreadManager;
import com.google.apphosting.api.ApiProxy;
import com.google.cloud.trace.core.TraceContext;
import com.google.cloud.trace.service.AppEngineTraceService;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Executes {@code statement.executeXXX()} methods in a seperate worker thread and ensures
 * that the queries are cancelled if they risk exceeding the request time limit.
 */
public class QueryExecutor {

    /**
     * Number of milliseconds to subtract from the remaining time when 
     * calculating query time limit. This "fudge factor" should provide
     * enough time to actually do something with the results, or, in the event of a timeout,
     * clean up the connection.
     */
    public static final long QUERY_BUFFER = 20_000;
    
    private static final Logger LOGGER = Logger.getLogger(QueryExecutor.class.getName());

    private boolean timedOut = false;
    
    private ExecutorService executorService = null;

    private AppEngineTraceService traceService = new AppEngineTraceService();

    public QueryExecutor() {
    }


    public <T> T executeWithTimeout(Callable<T> action) throws SQLException {
        if(executorService == null) {
            executorService = Executors.newSingleThreadExecutor(ThreadManager.currentRequestThreadFactory());
        }

        TraceContext traceContext = traceService.getTracer().startSpan("/cloudsql/query");

        long timeRemainingMillis = RequestTimer.getCurrent().getRemainingMillis();
        long timeLimit = timeRemainingMillis - QUERY_BUFFER;
        long startTime = System.currentTimeMillis();

        LOGGER.fine(String.format("Request has %d ms remaining, limiting query runtime to %d ms",
                timeRemainingMillis, timeLimit));

        if(timeLimit <= 0) {
            throw new SQLTimeoutException();
        }

        Future<T> task = executorService.submit(action);

        T result;
        try {
            result = task.get(timeLimit, TimeUnit.MILLISECONDS);

            long queryTime = (System.currentTimeMillis() - startTime);

            LOGGER.fine("Query completed in " + queryTime + " ms");

        } catch (TimeoutException e) {
            LOGGER.log(Level.SEVERE, "MySql operation timed out");
            task.cancel(true);

            timedOut = true;

            throw new SQLTimeoutException("Query timed out");

        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Request thread interrupted while waiting for MySQL operation to complete");
            task.cancel(true);

            timedOut = true;

            throw new SQLTimeoutException("Interrupted", e);

        } catch (ExecutionException e) {
            
            Throwable rootCause = e.getCause();
            if(rootCause instanceof InvocationTargetException) {
                rootCause = rootCause.getCause();
            }
            if(rootCause instanceof SQLException) {
                throw (SQLException) rootCause;
            } else if(rootCause instanceof RuntimeException) {
                throw (RuntimeException) rootCause;
            } else {
                throw new RuntimeException(e.getMessage(), e);
            }
        } finally {
            traceService.getTracer().endSpan(traceContext);
        }

        return result;
    }
    
    public boolean timedOut() {
        return timedOut;
    }

    public <T> T executeQueryWithTimeout(Statement statement, Callable<T> action) throws SQLException {
        try {
            return executeWithTimeout(action);
        } catch (SQLTimeoutException e) {
            try {
                statement.cancel();
                LOGGER.fine("Canceled timed-out query");
                
            } catch (Exception cancelException) {
                LOGGER.log(Level.SEVERE, "Failed to cancel timed-out statement", e);
            }
            throw e;
        }
    }


    public void shutdown() {
        if(executorService != null) {
            executorService.shutdownNow();
            executorService = null;
        }
    }
}
