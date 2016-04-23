package pl.java.scalatech.basic;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.JdbcConfig;
import pl.java.scalatech.repository.SimpleMessageJdbcRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JdbcConfig.class)
@SqlDataAccount
@ActiveProfiles("test")
@Slf4j
public class SimpleMessageJdbcTest {

    private EmbeddedDatabase db;

   /* @Before
    public void setUp() {
        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
        db = new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("db/sql/create-db.sql")
            .addScript("db/sql/insert-data.sql")
            .build();
    }*/




    @Test
    @Ignore
    //TODO nie znajduje tabeli Schemat !!!!!
    public void shouldSqlInitActionWork() {
        SimpleMessageJdbcRepository smRepo = new SimpleMessageJdbcRepository();
        smRepo.readSimpleMessage();
        log.info("+++ ");
    }

    @After
    public void after(){
        //DatabaseManagerSwing.main(new String[] { "--url", "jdbc:h2:mem:testdb", "--user", "sa", "--password", "" });
    }

}
