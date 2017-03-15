package com.virrantech.cloudsql.cache;

import org.hibernate.cache.CacheException;
import org.hibernate.cache.spi.CacheDataDescription;
import org.hibernate.cache.spi.EntityRegion;
import org.hibernate.cache.spi.access.AccessType;
import org.hibernate.cache.spi.access.EntityRegionAccessStrategy;
import org.hibernate.cache.spi.access.SoftLock;
import org.hibernate.engine.spi.SessionImplementor;

import java.util.Properties;

public class MemcacheEntityRegion extends AbstractMemcacheRegion implements EntityRegion {
    private Properties properties;
    private CacheDataDescription metadata;

    public MemcacheEntityRegion(String regionName, Properties properties, CacheDataDescription metadata) {
        super(regionName);
        this.properties = properties;
        this.metadata = metadata;
    }

    @Override
    public EntityRegionAccessStrategy buildAccessStrategy(AccessType accessType) throws CacheException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isTransactionAware() {
        return false;
    }

    @Override
    public CacheDataDescription getCacheDataDescription() {
        return metadata;
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
