/*
 * Copyright(c) 2013 Chain-Sys Corporation Inc.
 * Duplication or distribution of this code in part or in whole by any media
 * without the express written permission of Chain-Sys Corporation or its agents is
 * strictly prohibited.
 *
 * REVISION         DATE            NAME     DESCRIPTION
 * 511.101       Nov 4, 2013       MDR      Initial Code   
 */
package com.virrantech.utills;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.support.XmlWebApplicationContext;



/**
 * The Class SpringBeanUtils.
 */
public final class SpringBeanUtils {

    /** The d one obj. */
    private Object dOneObj = null;

    /** The id field. */
    private String idField = null;

    /** The class loader. */
    private ClassLoader classLoader = null;

    /**
     * Instantiates a new spring bean utils.
     */
    public SpringBeanUtils() {
        classLoader = SpringBeanUtils.class.getClassLoader();
    }

    /**
     * Instantiates a new spring bean utils.
     * 
     * @param classLoader the class loader
     */
    public SpringBeanUtils(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

   

    /**
     * Gets the single instance of SpringBeanUtils.
     * 
     * @param definitionFile the definition file
     * @param beanId the bean id
     * @return single instance of SpringBeanUtils
     */
    public static Object getInstance(String definitionFile, String beanId,HttpServletRequest request) {
        Object obj = null;
        
        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation(definitionFile);
        context.setServletContext(request.getSession().getServletContext());
        context.refresh();
        obj=context.getBean(beanId);
        return obj;
    }

    /**
     * Populate to entity object.
     * 
     * @param dtoObject the dto object
     * @param entityObject the entity object
     * @return the object
     * @throws BaseFrameworkException the base framework exception
     */
   

    /**
     * Populate to dto object.
     * 
     * @param entityObject the entity object
     * @param dtoObject the dto object
     * @return the object
     * @throws BaseFrameworkException the base framework exception
     */
   

    /**
     * Check for hibernate proxy object.
     * 
     * @param object the object
     * @return the object
     */


   
}
