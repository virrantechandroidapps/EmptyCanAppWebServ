
package com.virrantech.utills;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;

/**
 * The Class DateUtilities.
 */
public final class DateUtilities {

    /** The Constant DD_MON_YYYY. */
    public static final String DD_MON_YYYY = "dd-MMM-yyyy";

    /** The Constant DD_MM_YYYY. */
    public static final String DD_MM_YYYY = "dd-MM-yyyy";

    /** The Constant DD_MON_YY. */
    public static final String DD_MON_YY = "dd-MMM-yy";

    /** The Constant DD_MM_YY. */
    public static final String DD_MM_YY = "dd-MM-yy";

    /** The Constant DD_MMMMM_YY. */
    public static final String DD_MMMMM_YY = "d MMMMM yy";

    /** The Constant MMMMM_DD_YY. */
    public static final String MMMMM_DD_YY = "MMMMM d yy";

    /** The Constant DD_MON_YYYY_24HH_MM_SS. */
    public static final String DD_MON_YYYY_24HH_MM_SS = "dd-MMM-yyyy HH:mm:ss";

    /** The Constant DD_MON_YYYY_HH_MM_SS. */
    public static final String DD_MON_YYYY_HH_MM_SS = "dd-MMM-yyyy hh:mm:ss";
    
    public static final String   YYYY_MM_DD_24HH_MM_SS="yyyy-MM-dd HH:mm:ss";

    /**
     * Util data to string.
     * 
     * @param date the date
     * @param dateFormat the date format
     * @return the string
     */
    public static String utilDateToString(Date date, String dateFormat) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return convertSqlDateToString(sqlDate, dateFormat);
    }

    /**
     * Sql data to string.
     * 
     * @param date the date
     * @param dateFormat the date format
     * @return the string
     */
    public static String convertSqlDateToString(java.sql.Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    /**
     * Convert string date to sql.
     * 
     * @param sdate the sdate
     * @param format the format
     * @return the java.sql. date
     */
    public static java.sql.Date convertStringDateToSql(String sdate, String format) {
        java.sql.Date sql_sdate = null;
        if ((sdate != null) && !sdate.equals("")) {
            sql_sdate = convertUtilDateToSql(convertStringDateToUtil(sdate, format));
        }
        return sql_sdate;
    }

    /**
     * Convert util date to sql.
     * 
     * @param utilDate the util date
     * @return the java.sql. date
     */
    public static java.sql.Date convertUtilDateToSql(java.util.Date utilDate) {
        if (utilDate == null)
            return null;
        return new java.sql.Date(utilDate.getTime());
    }

    /**
     * Convert string date to util.
     * 
     * @param sdate the sdate
     * @param format the format
     * @return the java.util. date
     */
    public static java.util.Date convertStringDateToUtil(String sdate, String format) {
        java.util.Date util_sdate = null;
        if ((sdate != null) && !sdate.equals("")) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                //sdf.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
                util_sdate = sdf.parse(sdate);
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        }
        return util_sdate;
    }

    /**
     * Convert util date to string.
     * 
     * @param udate the udate
     * @param format the format
     * @return the string
     */
    public static String convertUtilDateToString(Date udate, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(udate);
    }

    /**
     * Convert date to timestamp.
     * 
     * @param udate the udate
     * @return the timestamp
     */
    public static Timestamp convertDateToTimestamp(Date udate) {
        return new Timestamp(udate.getTime());
    }

    /**
     * Gets the current date as sql.
     * 
     * @return the current date as sql
     */
    public static java.sql.Date getCurrentDateAsSql() {
        return new java.sql.Date(System.currentTimeMillis());
    }

    /**
     * Increment date.
     * 
     * @param currExpDate the curr exp date
     * @param noOfDays the no of days
     * @return the date
     */
    public static Date incrementDate(Date currExpDate, int noOfDays) {
        java.util.Calendar cal = Calendar.getInstance();
        cal.setTime(currExpDate);
        cal.add(Calendar.DATE, noOfDays);
        return new java.sql.Date(cal.getTime().getTime());
    }

    /**
     * No of days between.
     * 
     * @param currentDate the current date
     * @param actualExpDate the actual exp date
     * @return the long
     */
    public static long noOfDaysBetween(Date currentDate, Date actualExpDate) {
        long d1 = currentDate.getTime();
        long d2 = actualExpDate.getTime();
        long difMil = d2 - d1;
        long milPerDay = 1000 * 60 * 60 * 24;
        long days = (difMil / milPerDay) + 1;
        return days;
    }

    /**
     * Gets the current date as string.
     * 
     * @param dateFormat the date format
     * @return the current date as string
     */
    public static String getCurrentDateAsString(String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(new Date());
    }

    /**
     * Convert string date to timestamp.
     * 
     * @param dateString the date string
     * @return the timestamp
     */
    public static Timestamp convertStringDateToTimestamp(String dateString) {
        return new Timestamp(DateUtilities.convertStringDateToSql(dateString, "dd-MMM-yyyy HH:mm").getTime());
    }

    /**
     * Convert timestamp to string.
     * 
     * @param timestamp the timestamp
     * @param format the format
     * @return the string
     */
    public static String convertTimestampToString(Timestamp timestamp, String format) {
        String strDate = "";
        if ((timestamp != null) && !timestamp.equals("")) {
            try {
                format = format + " -hh:mm:ss ";
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                strDate = sdf.format(timestamp);
            } catch (Exception pe) {
                pe.printStackTrace();
            }
        }
        return strDate.toUpperCase();
    }
    
    public static String convertTimeToISTFormate(String inputString){
      String output="";
      try{
        DateFormat utcFormat = new SimpleDateFormat(DateUtilities.YYYY_MM_DD_24HH_MM_SS);
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        DateFormat indianFormat = new SimpleDateFormat(DateUtilities.YYYY_MM_DD_24HH_MM_SS);
        utcFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
        
        Date timestamp = utcFormat.parse(inputString);
         output = indianFormat.format(timestamp);
      }catch(Exception e){
        e.printStackTrace();
      }
      return output;
    }
   
}
