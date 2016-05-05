package pl.java.scalatech.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactory {

    private final String PERSISTENCE_UNIT = "PU";
    private final javax.persistence.EntityManagerFactory emf;

    public EntityManagerFactory(){
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT,config());
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    private Map config(){
        Map<String, String> properties = new HashMap<>();
        properties.put("javax.persistence.jdbc.url", "${url}");
        properties.put("javax.persistence.jdbc.password", "${password}");
        properties.put("javax.persistence.jdbc.driver", "${driver}");
        properties.put("javax.persistence.jdbc.user", "${user}");
        return properties;
    }

}