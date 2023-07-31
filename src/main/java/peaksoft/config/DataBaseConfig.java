package peaksoft.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.entities.Author;
import peaksoft.entities.Book;
import peaksoft.entities.Publisher;
import peaksoft.entities.Reader;


import java.util.Properties;

public class DataBaseConfig {
    public static EntityManagerFactory getEntityManager() {
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/Hibernate1");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "1234");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL, "true");


        org.hibernate.cfg.Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Publisher.class);
        configuration.addAnnotatedClass(Reader.class);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);

    }
}

