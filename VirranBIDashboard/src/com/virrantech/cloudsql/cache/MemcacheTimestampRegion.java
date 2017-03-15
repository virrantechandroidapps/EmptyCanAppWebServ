package com.virrantech.cloudsql.cache;

import org.hibernate.cache.CacheException;
import org.hibernate.cache.spi.TimestampsRegion;
import org.hibernate.engine.spi.SessionImplementor;

import java.util.Properties;


public class MemcacheTimestampRegion extends AbstractSimpleRegion implements TimestampsRegion {

    public MemcacheTimestampRegion(String regionName, Properties properties) {
        super(regionName);
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
