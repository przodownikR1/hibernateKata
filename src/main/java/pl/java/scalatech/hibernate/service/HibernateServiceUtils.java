package pl.java.scalatech.hibernate.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import pl.java.scalatech.domain.Item;

public final class HibernateServiceUtils {

    private static SessionFactory sf;

    public static SessionFactory getSessionFactory() {
        if (sf == null) {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");

            cfg.addPackage("pl.java.scalatech.domain").addAnnotatedClass(Item.class);
            cfg.setProperty("hibernate.generate_statistics","true");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
            sf = cfg.buildSessionFactory(serviceRegistry);
        }

        return sf;

    }

}
