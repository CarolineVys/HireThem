package model.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.net.URL;

public class HibernateUtil {
    private static Configuration config;

    private static SessionFactory sessionFactory;

    private static Session session;

    static {
        String path = "/hibernate.cfg.xml";
        URL url = HibernateUtil.class.getResource(path);
        config = new Configuration().configure(url);
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public static Session getSession() {
        return session;
    }
}
