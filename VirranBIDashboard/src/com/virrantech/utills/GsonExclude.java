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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Interface GsonExclude.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface GsonExclude {

}
