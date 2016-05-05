package pl.java.scalatech.jpa;

import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static String DATABASE_JDBC_URL = "jdbc:h2:~/SeparateDatabase";
    private static String DATABASE_JDBC_URL2 = "jdbc:h2:~/SeparateDatabase2";
    private static String DATABASE_USERNAME = "sa";
    private static String DATABASE_PASSWORD = "";
    private final String PERSISTENCE_UNIT = "myunit";
    private final javax.persistence.EntityManagerFactory emf;

    public EntityManagerFactoryUtil(){
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT,config());
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    private Map<?,?> config(){
        Properties properties = new Properties();
        properties.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        properties.put("javax.persistence.jdbc.url", DATABASE_JDBC_URL);
        properties.put("javax.persistence.jdbc.user", DATABASE_USERNAME);
        properties.put("javax.persistence.jdbc.password", DATABASE_PASSWORD);
        properties.put("javax.persistence.database-product-name", "H2");
        properties.put("javax.persistence.schema-generation.database.action", "create");
        properties.put("javax.persistence.schema-generation.create-database-schemas", "true");
        return properties;
    }

}