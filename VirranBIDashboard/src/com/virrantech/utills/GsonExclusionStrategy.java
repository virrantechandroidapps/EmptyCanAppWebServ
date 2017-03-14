/*
 * Copyright(c) 2011 Chain-Sys Corporation Inc.
 * Duplication or distribution of this code in part or in whole by any media
 * without the express written permission of Chain-Sys Corporation or its agents is
 * strictly prohibited.
 *
 * REVISION           DATE            NAME     DESCRIPTION
 * 511.101         25-MAR-2013        MDR      Initial Code    
 */
package com.virrantech.utills;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * The Class GsonExclusionStrategy.
 */
public class GsonExclusionStrategy implements ExclusionStrategy {

	/** The type to exclude. */
	private final Class<?> typeToExclude;

	/**
	 * Instantiates a new gson exclusion strategy.
	 *
	 * @param clazz the clazz
	 */
	public GsonExclusionStrategy(Class<?> clazz) {
		this.typeToExclude = clazz;
	}

	/* (non-Javadoc)
	 * @see com.google.gson.ExclusionStrategy#shouldSkipClass(java.lang.Class)
	 */
	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return (this.typeToExclude != null && this.typeToExclude == clazz)
				|| clazz.getAnnotation(GsonExclude.class) != null;
	}

	/* (non-Javadoc)
	 * @see com.google.gson.ExclusionStrategy#shouldSkipField(com.google.gson.FieldAttributes)
	 */
	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		return f.getAnnotation(GsonExclude.class) != null;
	}

}