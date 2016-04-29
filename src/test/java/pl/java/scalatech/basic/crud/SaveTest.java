package pl.java.scalatech.basic.crud;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.ORMStandaloneTestCase;
import pl.java.scalatech.domain.Item;

@Slf4j
public class SaveTest extends ORMStandaloneTestCase{

    @Test
    public void shouldSaveObject(){
        Session session = sf.openSession();
        Item item = Item.builder().name("book").price(BigDecimal.valueOf(334)).build();
        try {
            Transaction tx = session.beginTransaction();
             session.save(item);   
            tx.commit();
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
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
