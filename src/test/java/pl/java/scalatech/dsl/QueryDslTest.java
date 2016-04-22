package pl.java.scalatech.dsl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.JPAUnitTestCase;
import pl.java.scalatech.domain.Item;

@Slf4j
public class QueryDslTest extends JPAUnitTestCase {
    @Test
    public void shouldWork() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(Item.builder().name("knife").price(BigDecimal.valueOf(122)));
        entityManager.persist(Item.builder().name("cow").price(BigDecimal.valueOf(75)));
        entityManager.persist(Item.builder().name("kat").price(BigDecimal.valueOf(75)));
        entityManager.persist(Item.builder().name("katana").price(BigDecimal.valueOf(75)));
        entityManager.persist(Item.builder().name("spoon").price(BigDecimal.valueOf(44)));
        entityManager.persist(Item.builder().name("glass").price(BigDecimal.valueOf(52)));
        entityManager.persist(Item.builder().name("cup").price(BigDecimal.valueOf(75)));

        entityManager.flush();
        transaction.commit();
/*
        JPAQuery query = new JPAQuery(entityManager);

        List<String> uniqueItemNames = query.from(item).where(item.name.like("%k")).groupBy(item.name).list(item.name);

        for (String name : uniqueItemNames) {
            log.info("{}", name);
        }*/

        entityManager.close();

    }

}
