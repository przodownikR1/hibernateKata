package pl.java.scalatech.manyToMany;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Sets;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.common.ORMStandaloneTestCase;
import pl.java.scalatech.domain.manyToMany.CrewBi;
import pl.java.scalatech.domain.manyToMany.Tank;
import pl.java.scalatech.domain.manyToMany.TankBi;

@Slf4j
@FixMethodOrder(NAME_ASCENDING)
public class ManyToManyTestBi extends ORMStandaloneTestCase {

    @Test
    @Ignore //problem stackoverflow
    public void should_A_Save_TANK() {
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();
            Set<CrewBi> crews = Sets.newHashSet(CrewBi.builder().count(2).build(), CrewBi.builder().count(5).build());
            TankBi tank = TankBi.builder().name("t-34").crews(crews).build();
            session.save(tank);
            tx.commit();
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }
    }

    @Test
    @Ignore//problem stackOverflow
    public void should_B_RETRIEVE_TANK() {
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();

            List<Tank> tank = session.createQuery("FROM TankBi").list();
            log.info("{}",tank);
            tx.commit();
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }
    }

    @Override
    protected Class<?> getEntityClass() {
        return null;
    }

    @Override
    protected String packageBase() {
        return "pl.java.scalatech.domain.manyToMany";
    }

}
