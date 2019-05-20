package com.jjsolution.app.Helper;

import com.jjsolution.app.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = getConfiguration();

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch(Exception ex) {
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static Configuration getConfiguration() {
        try {
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(Acordo.class)
                    .addAnnotatedClass(Cliente.class)
                    .addAnnotatedClass(Conta.class)
                    .addAnnotatedClass(Divida.class)
                    .addAnnotatedClass(Pagamentos.class);


            configuration.configure();

            return configuration;
        } catch(Exception ex) {
            return null;
        }
    }
}
