package pl.java.scalatech.simple.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.junit.FixMethodOrder;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Item;
import pl.java.scalatech.jpa.EntityManagerUtils;

@Slf4j
@FixMethodOrder(NAME_ASCENDING)
public class EntityFactoryTest {

    private EntityManager em = EntityManagerUtils.getEntityManager();

    @Test
    public void shouldCreateEntityManager() {
        assertThat(em).isNotNull();
    }

    @Test
    public void should_A_SaveItem() {
        log.info("+++  save item");
        try {
            em.getTransaction().begin();
            Item item = new Item();
            item.setName("knife");
            item.setPrice(BigDecimal.valueOf(100));
            em.persist(item);
            em.getTransaction().commit();
        } catch (Exception ex) {
            log.info("{}", ex);
        } finally {

            em.close();
        }
    }

    @Test
    public void should_B_ReadItem() {
        log.info("+++  read items");
        try {
            em.createQuery("FROM Item").getResultList().forEach(i -> log.info("retrieve : {}", i));
        } catch (Exception ex) {
            log.info("{}", ex);
        } finally {
            em.close();

        }
    }

}
