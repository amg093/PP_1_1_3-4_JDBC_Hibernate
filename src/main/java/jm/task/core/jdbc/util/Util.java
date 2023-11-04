package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Util {
    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new Configuration()
                    .configure("application.properties")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
            System.out.println("SessionFactory - OK");
        } catch (HibernateException e) {
            System.out.println("SessionFactory - ERROR");
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
