package pl.java.scalatech.simple;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Item;
import pl.java.scalatech.hibernate.service.HibernateUtils;

@Slf4j
public class HibernateFactoryTest {

    private final SessionFactory sf = HibernateUtils.getSessionFactory();

    @Test
    public void shouldSessionFactoryCreate() {
        Assertions.assertThat(sf).isNotNull();
    }

    @Test
    public void shouldSessionCreate() {
        Session session = sf.openSession();
        Assertions.assertThat(session).isNotNull();
    }

    @Test
    public void shouldSaveItem() {
        log.info("+++  save item");
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Item item = new Item();
        item.setName("knife");
        item.setPrice(BigDecimal.valueOf(100));
        session.save(item);
        session.flush();
        tx.commit();
        session.close();
    }

    @Test
    public void shouldUseSessionInRightWay() {
        log.info("+++  save finally item");
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();
            Item item = new Item();
            item.setName("fork");
            item.setPrice(BigDecimal.valueOf(100));
            session.save(item);
            session.flush();
            tx.commit();
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }
    }

    @Test
    public void shouldSaveThenLoadItem() {
        log.info("+++  load item");
        Session session = sf.openSession();
        Query query = session.createQuery("FROM Item");
        query.list().forEach(i -> log.info("{}", i));
        session.close();
    }

}
