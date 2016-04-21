package pl.java.scalatech.simple.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.JPAUnitTestCase;
import pl.java.scalatech.domain.Item;
@Slf4j
public class SimpleUseJpaTempateTest extends JPAUnitTestCase
{
    @Test
    public void shouldCreateEntityManagerFactory() {
        assertThat(entityManagerFactory).isNotNull();
    }

    @Test
    public void should_A_SaveItem() {
        log.info("+++  save item");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Item item = new Item();
            item.setName("knife");
            item.setPrice(BigDecimal.valueOf(100));
            entityManager.persist(item);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            log.info("{}", ex);
        } finally {
            entityManager.close();
        }
    }

}
