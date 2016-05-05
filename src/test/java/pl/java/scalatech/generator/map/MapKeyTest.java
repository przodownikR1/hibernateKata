package pl.java.scalatech.generator.map;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.FixMethodOrder;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.keys.Department;
import pl.java.scalatech.domain.keys.User;
import pl.java.scalatech.domain.keys.UserId;

@Slf4j
@FixMethodOrder(NAME_ASCENDING)
public class MapKeyTest extends ORMStandaloneTestCase{@Override
    protected Class<?> getEntityClass() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String packageBase() {
        return "pl.java.scalatech.domain.keys";
    }

    @Test
    public void shouldSave(){
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();
            Department department = new Department(2l,"Java");
            session.save(department);
            assertThat(session.get(Department.class, 2l).getName()).isEqualTo("Java");
            UserId id = new UserId("johndoe", 2l);
            User user = new User(id);
            user.setDepartment(department);
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }

    }
}
