package pl.java.scalatech.exercise.query;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.FixMethodOrder;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.exercise.query.Message;

@Slf4j
@FixMethodOrder(NAME_ASCENDING)
public class MessageQueryTest extends ORMStandaloneClassTestCase {
    @Test
    public void should_A_SAVE() {
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();
            Message m1 = Message.builder().message("hello world").build();
            session.save(m1);
            Message m2 = Message.builder().message("hello przodownik").build();
            session.save(m2);

            tx.commit();
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }
    }

    @Test
    public void should_B_NativeQueryWork() {
        Session session = sf.openSession();
        try {

            assertThat(session.getNamedQuery("Message.list").list()).hasSize(2);
            assertThat(session.getNamedQuery("Message.byId").setLong("id", 1l).list()).hasSize(1);
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }

    }
}
