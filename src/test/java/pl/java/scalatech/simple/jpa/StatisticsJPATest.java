package pl.java.scalatech.simple.jpa;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.hibernate.stat.SessionStatistics;
import org.hibernate.stat.Statistics;
import org.junit.FixMethodOrder;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Item;
import pl.java.scalatech.jpa.EntityManagerUtils;
@Slf4j
@FixMethodOrder(NAME_ASCENDING)
public class StatisticsJPATest {
    private EntityManager em = EntityManagerUtils.getEntityManager();
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
            log.info("{}",ex);
        } finally {

            em.close();
        }
    }
    @Test
    public void should_B_ReadItem() {
        log.info("+++  read items");
        Session session = em.unwrap(Session.class);
        SessionStatistics sessionStats = session.getStatistics();
        SessionFactory sf = ((HibernateEntityManagerFactory) em.getEntityManagerFactory()).getSessionFactory();
        Statistics stats = sf.getStatistics();
        try {
            em.createQuery("FROM Item").getResultList().forEach(i -> log.info("retrieve : {}", i));
        } catch (Exception ex) {
           log.info("{}",ex);
        } finally {
            log.info("getEntityCount- {}", sessionStats.getEntityCount());
            log.info("openCount- {}", stats.getSessionOpenCount());
            log.info("getEntityInsertCount- {}", stats.getEntityInsertCount());
            em.close();
            stats.logSummary();
        }
    }
}
