package pl.java.scalatech.simple;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.FixMethodOrder;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Item;
import pl.java.scalatech.hibernate.service.HibernateServiceUtils;

@Slf4j
@FixMethodOrder(NAME_ASCENDING)
public class RetrieveObjectsTest {

    private final SessionFactory sf = HibernateServiceUtils.getSessionFactory();

    @Test
    public void shouldSessionFactoryCreate() {
        Assertions.assertThat(sf).isNotNull();
    }

    @Test
    public void should_A_UseSessionInRightWay() {
        log.info("+++  save finally item");
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();
            Item item = new Item();
            item.setName("fork");
            item.setPrice(BigDecimal.valueOf(100));
            session.save(item);

            tx.commit();
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }
    }

    @Test
    public void should_B_RetrieveObject() {
        Session session = sf.openSession();
        try {
            Item item = session.load(Item.class, 1l);
            log.info("retrieve - load - item : {}", item);
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }
    }

    @Test
    public void should_C_RetrieveObject() {
        Session session = sf.openSession();
        try {
            Item item = session.get(Item.class, 1l);
            log.info("retrieve - get -  item : {}", item);
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }
    }

    @Test
    public void should_D_RetrieveListObject() {
        Session session = sf.openSession();
        try {
            Query query = session.createQuery("from " + Item.class.getSimpleName());
            query.list().forEach(i -> log.info("retrieve by list :  {}", i));
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }
    }

    @Test
    public void should_D_RetrieveUniqueObject() {
        Session session = sf.openSession();
        try {
            Query query = session.createQuery("from " + Item.class.getSimpleName() + " WHERE id = :id");
            query.setParameter("id", 1l);
            assertThat(query.uniqueResult()).isNotNull();
            log.info("retrieve unique  :  {}", query.uniqueResult());
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }
    }

    @Test
    public void should_E_RetrieveUniqueObjectIfNotExists() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("DELETE FROM "+Item.class.getSimpleName());
            query.executeUpdate();
            tx.commit();
            query = session.createQuery("from " + Item.class.getSimpleName() + " WHERE id = :id");
            query.setParameter("id", 2l);
            assertThat(query.uniqueResult()).isNull();
        } catch (Exception e) {
            tx.rollback();
            log.error("{}", e);
        } finally {
            session.close();
        }
    }

}
