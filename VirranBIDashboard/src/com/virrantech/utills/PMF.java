package com.virrantech.utills;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class PMF {

    private static final PersistenceManagerFactory persistenceManagerFactory = JDOHelper
        .getPersistenceManagerFactory("transactions-optional");

    private PMF() {
    }

    public static PersistenceManagerFactory get() {
        return persistenceManagerFactory;
    }

}