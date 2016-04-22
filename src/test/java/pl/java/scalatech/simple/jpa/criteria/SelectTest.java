package pl.java.scalatech.simple.jpa.criteria;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.assertj.core.api.Assertions;
import org.junit.FixMethodOrder;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.JPAUnitTestCase;
import pl.java.scalatech.domain.Item;
import pl.java.scalatech.jpa.EntityManagerUtils;

@Slf4j
@FixMethodOrder(NAME_ASCENDING)
public class SelectTest extends JPAUnitTestCase {

    @Test
    public void should_INSERT_DATA() {
        EntityManager em = EntityManagerUtils.getEntityManager();
        log.info("+++  save item");

        try {
            for (int i = 0; i < 10; i++) {
                em.getTransaction().begin();
                Item item = new Item();
                item.setName("knife_" + i);
                item.setPrice(BigDecimal.valueOf(100 + i));
                em.persist(item);
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
            log.info("{}", ex);
        } finally {

            em.close();
        }
    }

    @Test
    public void should_SELECT_DATA() {
        EntityManager em = EntityManagerUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Item> criteria = builder.createQuery(Item.class);
            Root<Item> item = criteria.from(Item.class);
            criteria.select(item);
            criteria.orderBy(builder.desc(item.get("name")));
            List<Item> items = em.createQuery(criteria).getResultList();
            log.info("result : {}",items);
            Assertions.assertThat(items.size()).isEqualTo(10);
        } catch (Exception ex) {
            log.info("{}", ex);
        } finally {
            em.close();
        }
    }
}
