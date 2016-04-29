package pl.java.scalatech.basic.crud;

import java.math.BigDecimal;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.ORMStandaloneTestCase;
import pl.java.scalatech.domain.Item;
@Slf4j
public class UpdateDetachLockObjectTest extends ORMStandaloneTestCase{

    @Test
    public void shouldUpdateDetachObject(){
        Session session1 = sf.openSession();
        Session session2 = sf.openSession();
        Session session3 = sf.openSession();
        Item item = Item.builder().name("book").price(BigDecimal.valueOf(334)).build();
        try {
            Transaction tx1 = session1.beginTransaction();
             session1.save(item);   
            tx1.commit();
            
            item.setPrice(new BigDecimal(23));
            
            Transaction tx2 = session2.beginTransaction();
                    session2.lock(item,LockMode.NONE);
                    item.setPrice(new BigDecimal(23)); //>??
                    tx2.commit();

             Item loaded = session3.get(Item.class, 1l);
             log.info("{}",loaded);
                    
                    
            
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session1.close();
            session2.close();
            session3.close();
            
        }
    }
    
    @Override
    protected Class<?> getEntityClass() {
        return Item.class;
    }

    @Override
    protected String packageBase() {
        return null;
    }

}
