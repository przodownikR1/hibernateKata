package pl.java.scalatech.exercise.queryTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
@Ignore
public class Test5 {
@Before
public void clear() {
//SessionManager.deleteAll("Book5");
Session session =null;//= SessionManager.openSession();
Transaction tx = session.beginTransaction();
Book5 book5 = new Book5();
book5.setTitle("My Book");
session.persist(book5);
tx.commit();
session.close();
}


public List<Book5> runQuery(boolean cacheStatus) {
Session session = null;
Transaction tx = session.beginTransaction();
Query query = session.createQuery("from Book5 b where b.title like :title");
query.setString("title", "My%");
query.setCacheable(cacheStatus);
List<Book5> books = query.list();
tx.commit();
session.close();
return books;
}

@Test
public void testNoQueryCache() {
SessionFactory factory= null;
Statistics stats = factory.getStatistics();
assertEquals(runQuery(false).size(), 1);
assertEquals(runQuery(false).size(), 1);
assertEquals(stats.getQueryCacheHitCount(),0);
assertEquals(stats.getSecondLevelCacheHitCount(), 0);
}

@Test
public void testQueryCache() {
SessionFactory factory= null;
Statistics stats = factory.getStatistics();
assertEquals(runQuery(true).size(), 1);
assertEquals(runQuery(true).size(), 1);
assertEquals(stats.getQueryCacheHitCount(),1);
assertEquals(stats.getSecondLevelCacheHitCount(), 1);
}
}