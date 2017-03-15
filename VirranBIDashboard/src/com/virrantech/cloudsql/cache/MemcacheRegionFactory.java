package com.virrantech.cloudsql.cache;

import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cache.CacheException;
import org.hibernate.cache.spi.*;
import org.hibernate.cache.spi.access.AccessType;
import org.hibernate.cfg.Settings;

import java.util.Properties;

public class MemcacheRegionFactory implements RegionFactory {
   

    @Override
    public void stop() {
        // Noop
    }

    @Override
    public boolean isMinimalPutsEnabledByDefault() {
        return false;   
    }

    @Override
    public AccessType getDefaultAccessType() {
        return AccessType.READ_WRITE;
    }

    @Override
    public long nextTimestamp() {
        return System.currentTimeMillis();
    }

    @Override
    public EntityRegion buildEntityRegion(String regionName, Properties properties, CacheDataDescription metadata) throws CacheException {
//        return new MemcacheEntityRegion(regionName, properties, metadata);
        throw new CacheException("Unsupported");
    }

    @Override
    public NaturalIdRegion buildNaturalIdRegion(String regionName, Properties properties, CacheDataDescription metadata) throws CacheException {
//        return new MemcacheNaturalIdRegion(regionName, properties, metadata);
        throw new CacheException("Unsupported");
    }

    @Override
    public CollectionRegion buildCollectionRegion(String regionName, Properties properties, CacheDataDescription metadata) throws CacheException {
        //return new MemcacheCollectionRegion(regionName, properties, metadata);
        throw new CacheException("Unsupported");
    }

    @Override
    public QueryResultsRegion buildQueryResultsRegion(String regionName, Properties properties) throws CacheException {
        return new MemcacheQueryResultsRegion(regionName, properties);
    }

    @Override
    public TimestampsRegion buildTimestampsRegion(String regionName, Properties properties) throws CacheException {
        return new MemcacheTimestampRegion(regionName, properties);
    }

    @Override
    public void start(SessionFactoryOptions arg0, Properties arg1) throws CacheException {
      // TODO Auto-generated method stub
      
    }
}
