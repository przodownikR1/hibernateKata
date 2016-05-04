package pl.java.scalatech.exercise.query.jpql;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import com.google.common.collect.Lists;

import static com.google.common.collect.Lists.newArrayList;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.common.Address;
import pl.java.scalatech.domain.exercise.query.jpql.Company;
import pl.java.scalatech.domain.exercise.query.jpql.Department;
import pl.java.scalatech.domain.exercise.query.jpql.Employee;
@Slf4j
@FixMethodOrder(NAME_ASCENDING)
public class JpqlJoinTest  extends ORMStandaloneClassTestCase{

    @BeforeClass
    public static  void populateDB(){
        // @formatter:off
        Department qaDepartment  = Department.builder().name("QA").build();
        Department uatDepartment  = Department.builder().name("UAT").build();
        Department javaDepartment = Department.builder().name("JAVA").build();
        Department csDepartment = Department.builder().name("C#").build();
        Department hrDepartment = Department.builder().name("hr").build();

        Company risco = Company.builder()
                .address(Address.builder().city("Warsaw").street("kolowa").zipcode("12431").build())
                .depts(newArrayList(qaDepartment,csDepartment,uatDepartment))
                .name("risco").build();
        Company assecco = Company.builder()
                .address(Address.builder().city("Sopot").street("mechowa").zipcode("25664").build())
                .depts(newArrayList(qaDepartment,uatDepartment,hrDepartment))
                .name("assecco").build();
        Company qumak = Company.builder()
                .address(Address.builder().city("Warsaw").street("lotna").zipcode("00841").build())
                .depts(newArrayList(qaDepartment,javaDepartment))
                .name("qumak").build();
        Company commarch = Company.builder()
                .address(Address.builder().city("Cracow").street("motorowa").zipcode("24235").build())
                .depts(newArrayList(qaDepartment,uatDepartment,javaDepartment,hrDepartment))
                .name("commarch").build();
        Company ibm = Company.builder()
                .address(Address.builder().city("LA").street("oakStreet").zipcode("23231").build())
                .depts(newArrayList(qaDepartment,uatDepartment,hrDepartment,javaDepartment))
                .name("ibm").build();

        Employee przodownik= Employee.builder().age(37).company(risco).firstName("Slawek").lastName("borowiec").pesel("123").salary(BigDecimal.valueOf(10000)).build();
        Employee ts= Employee.builder().age(38).company(risco).firstName("Tomek").lastName("Sielwa").pesel("124").salary(BigDecimal.valueOf(13000)).build();
        Employee kowalski= Employee.builder().age(27).company(assecco).firstName("Jan").lastName("Kowalski").pesel("125").salary(BigDecimal.valueOf(3400)).build();
        Employee nowak= Employee.builder().age(53).company(qumak).firstName("Karol").lastName("Nowak").pesel("126").salary(BigDecimal.valueOf(5000)).build();
        Employee sala= Employee.builder().age(35).company(qumak).firstName("Tomek").lastName("sala").pesel("127").salary(BigDecimal.valueOf(11000)).build();
        Employee waski= Employee.builder().age(35).company(qumak).firstName("Jan").lastName("jez").pesel("128").salary(BigDecimal.valueOf(40000)).build();
        Employee pd= Employee.builder().age(31).company(commarch).firstName("Pawel").lastName("Danowski").pesel("129").salary(BigDecimal.valueOf(53000)).build();
        Employee km= Employee.builder().age(37).company(commarch).firstName("Karol").lastName("Mucha").pesel("130").salary(BigDecimal.valueOf(6000)).build();
        Employee mg= Employee.builder().age(31).company(commarch).firstName("Marcin").lastName("Gancarczyk").pesel("131").salary(BigDecimal.valueOf(67000)).build();
        Employee emilka= Employee.builder().age(23).company(ibm).firstName("Emilia").lastName("Karolak").pesel("132").salary(BigDecimal.valueOf(14000)).build();
        // @formatter:on
        List<Employee> all = Lists.newArrayList(przodownik,ts,kowalski,sala,waski,km,mg,nowak,pd,emilka);
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();
           all.forEach(em-> session.save(em));
            tx.commit();
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }

    }



    @Test
    public void shouldRetriveAllWhereWorkInCompany(){
        Session session = sf.openSession();
        try {
         session.createQuery("SELECT e.lastName ,c.name  FROM "+Employee.class.getSimpleName() +" e join e.company c WHERE c.name = :name").setParameter("name","commarch").list().forEach(c->log.info("+++  {}",c));

        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }
    }

    @Test
    public void shouldRetriveAllWhereWorkInDEPT(){
        Session session = sf.openSession();
        try {
         session.createQuery("SELECT e.lastName ,c.name , d.name FROM "+Employee.class.getSimpleName() +" e left join e.company c left join c.depts d  WHERE  d.name =  :name").setParameter("name","JAVA").list().forEach(c->log.info("+++  {}",c));

        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }
    }

    @Test
    public void shouldRetrieveEmployeeAll(){
        Session session = sf.openSession();
        try {
            session.createQuery("SELECT e FROM "+Employee.class.getSimpleName()+ " e").list().forEach(e->log.info("employee  +++  {}",e));
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }

    }

    @Test
    public void shouldRetrieveCompanyAll(){
        Session session = sf.openSession();
        try {
            session.createQuery("SELECT c FROM "+Company.class.getSimpleName()+ " c").list().forEach(c->log.info("company  +++  {}",c));
        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }

    }

    @Test
    public void shouldRetriveCompanyWhereWorkInOneDEPT(){
        Session session = sf.openSession();
        try {
         session.createQuery("SELECT c.name,c.id , d.name FROM "+Company.class.getSimpleName() +" c left join  c.depts d WHERE d.name = :name").setParameter("name", "JAVA").list().forEach(c->log.info("dept +++  {}",c));

        } catch (Exception e) {
            log.error("{}", e);
        } finally {
            session.close();
        }
    }
}
