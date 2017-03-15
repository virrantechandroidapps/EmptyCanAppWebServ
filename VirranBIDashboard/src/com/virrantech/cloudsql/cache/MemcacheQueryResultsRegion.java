package com.virrantech.cloudsql.cache;

import org.hibernate.cache.CacheException;
import org.hibernate.cache.spi.QueryResultsRegion;
import org.hibernate.engine.spi.SessionImplementor;

import java.util.Map;
import java.util.Properties;

public class MemcacheQueryResultsRegion implements QueryResultsRegion {

    private String regionName;

    protected MemcacheQueryResultsRegion(String regionName, Properties properties) {
        this.regionName = regionName;
    }

    @Override
    public Object get(Object key) throws CacheException {
        return null;
    }

    @Override
    public void put(Object key, Object value) throws CacheException {

    }

    @Override
    public void evict(Object key) throws CacheException {

    }

    @Override
    public void evictAll() throws CacheException {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void destroy() throws CacheException {

    }

    @Override
    public boolean contains(Object key) {
        return false;
    }

    @Override
    public long getSizeInMemory() {
        return 0;
    }

    @Override
    public long getElementCountInMemory() {
        return 0;
    }

    @Override
    public long getElementCountOnDisk() {
        return 0;
    }

    @Override
    public Map toMap() {
        return null;
    }

    @Override
    public long nextTimestamp() {
        return 0;
    }

    @Override
    public int getTimeout() {
        return 0;
    }

    @Override
    public Object get(SessionImplementor arg0, Object arg1) throws CacheException {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public void put(SessionImplementor arg0, Object arg1, Object arg2) throws CacheException {
      // TODO Auto-generated method stub
      
    }
}
