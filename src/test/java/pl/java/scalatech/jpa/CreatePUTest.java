package pl.java.scalatech.jpa;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceUnitTransactionType;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.jpa.model.Product;
@Slf4j
public class CreatePUTest {

    private static EntityManagerFactory emf;

    @BeforeClass
    public static void init(){
        Map<String, String> prop = Maps.newHashMap();
        prop.put("javax.persistence.transactionType",PersistenceUnitTransactionType.RESOURCE_LOCAL.name());

        prop.put("javax.persistence.jdbc.driver", "org.h2.Driver");
        prop.put("javax.persistence.jdbc.url", "jdbc:h2:mem:testdbJPA");
        prop.put("javax.persistence.jdbc.username", "jdbc:h2:mem:testdbJPA");
        prop.put("javax.persistence.validation.mode", "none");
        prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        prop.put("hibernate.hbm2ddl.auto", "update");
        prop.put("hibernate.generate_statistics", "true");
        prop.put("hibernate.default_batch_fetch_size", "25");
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.format_sql", "true");
        prop.put("hibernate.connection.charSet", "UTF-8");
        prop.put("use_sql_comments", "true");
        prop.put("hibernate.archive.autodetection", "class");


        prop.put("hibernate.cache.use_second_level_cache", "false");
        prop.put("hibernate.cache.use_query_cache", "false");



        emf = Persistence.createEntityManagerFactory("myunit",prop);

    }
    @Test
    public void shouldRetriveTest(){
          EntityManager em = emf.createEntityManager();
          em.getTransaction().begin();
          Product product = new Product("knife");
          em.persist(product);
          em.getTransaction().commit();

          log.info("persist product : {}",em.find(Product.class, 1l));
          em.close();

    }
}
