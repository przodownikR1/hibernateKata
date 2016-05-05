package pl.java.scalatech.jpa;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class SeparateDatabaseApp {
    private static String DATABASE_JDBC_URL = "jdbc:h2:~/SeparateDatabase";
    private static String DATABASE_JDBC_URL2 = "jdbc:h2:~/SeparateDatabase2";
    private static String DATABASE_USERNAME = "sa";
    private static String DATABASE_PASSWORD = "";
    private static String PU = "myunit";
    private static String PU2 = "myunit2";


    public static void main(String[] args) {
        // use Persistence Unit#1
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PU, getProperties(DATABASE_JDBC_URL));
        EntityManager em = factory.createEntityManager();


        // use Persistence Unit#2
        EntityManagerFactory factory2 = Persistence.createEntityManagerFactory(PU2, getProperties(DATABASE_JDBC_URL2));
        EntityManager em2 = factory2.createEntityManager();

    }

    private static Properties getProperties(String jdbcUrl) {
        Properties properties = new Properties();
        properties.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        properties.put("javax.persistence.jdbc.url", jdbcUrl);
        properties.put("javax.persistence.jdbc.user", DATABASE_USERNAME);
        properties.put("javax.persistence.jdbc.password", DATABASE_PASSWORD);
        properties.put("javax.persistence.database-product-name", "H2");
        properties.put("javax.persistence.schema-generation.database.action", "create");
        properties.put("javax.persistence.schema-generation.create-database-schemas", "true");
        return properties;
    }
}