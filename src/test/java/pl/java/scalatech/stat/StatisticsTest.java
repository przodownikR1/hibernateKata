package pl.java.scalatech.stat;

import java.math.BigDecimal;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.SessionStatistics;
import org.hibernate.stat.Statistics;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Item;
import pl.java.scalatech.hibernate.service.HibernateServiceUtils;

@Slf4j
public class StatisticsTest {
    private final SessionFactory sf = HibernateServiceUtils.getSessionFactory();

    @Test
    public void shouldGetStatistics() {
        log.info("+++  show statistics");
        Session session = sf.openSession();
        SessionStatistics sessionStats = session.getStatistics();
        Statistics stats = sf.getStatistics();
        try {

            Transaction tx = session.beginTransaction();
            for(int i =0 ;i<10;i++){
            Item item = new Item();
            item.setName("fork_"+i);
            item.setPrice(BigDecimal.valueOf(100+i));
            session.save(item);
            }
            Query query = session.createQuery("FROM Item");
            query.list().forEach(i -> log.info("{}", i));
            tx.commit();
        } catch (Exception e) {
            log.error("{}", e);
        } finally {

            log.info("getEntityCount- {}", sessionStats.getEntityCount());
            log.info("openCount- {}", stats.getSessionOpenCount());
            log.info("getEntityInsertCount- {}", stats.getEntityInsertCount());
            stats.logSummary();
            session.close();
        }

    }

}
