package pl.java.scalatech.exercise.query.jpql;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.BeforeClass;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.exercise.query.jpql.Company;
import pl.java.scalatech.domain.exercise.query.jpql.Department;
import pl.java.scalatech.domain.exercise.query.jpql.Employee;;

@Slf4j
public abstract class ORMStandaloneClassTestCase {

    protected static SessionFactory sf;

    @BeforeClass
    public static void setup() {
        // @formatter:off
        StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder()
                .applySetting("hibernate.show_sql", "true")
                .applySetting("hibernate.format_sql", "true")
                .applySetting("hibernate.hbm2ddl.auto", "update")
                .applySetting("use_sql_comments", "true")
                .applySetting("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                .applySetting("hibernate.connection.driver_class", "org.h2.Driver")
                .applySetting("hibernate.connection.url", "jdbc:h2:mem:testdbHibernate")
                .applySetting("hibernate.connection.username", "sa")
                .applySetting("hibernate.connection.password", "")
                .applySetting("hibernate.use_sql_comment", "true");
        Metadata metadata = null;
        log.info("+++ setup");
        metadata = new MetadataSources(srb.build()).addAnnotatedClass(Employee.class).addAnnotatedClass(Company.class).addAnnotatedClass(Department.class).buildMetadata();

        sf = metadata.buildSessionFactory();
        // @formatter:on
    }


}