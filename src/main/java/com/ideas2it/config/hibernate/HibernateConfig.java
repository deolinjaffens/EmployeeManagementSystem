package com.ideas2it.config.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

/**
 * <p>
 * Provides configuration to session factory which manages database session and
 * transaction
 * </p>
 *
 * @author Deolin Jaffens
 */

public class HibernateConfig {
    private static SessionFactory factory = null;

    static {
        try {
            if (factory == null) {
                factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            }
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}