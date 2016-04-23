package pl.java.scalatech.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.JdbcConfig;
import pl.java.scalatech.domain.basic.SimpleMessage;
import pl.java.scalatech.repository.spring_jdbc.JdbcSimpleMessageDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JdbcConfig.class, SimpleBetterSpringSolutionDaoTest.DaoConfig.class })
@FixMethodOrder(NAME_ASCENDING)
@SqlDataAccount
@ActiveProfiles("test")
@Slf4j
public class SimpleBetterSpringSolutionDaoTest {

    @Configuration
    @ComponentScan(basePackageClasses = JdbcSimpleMessageDao.class)
    static class DaoConfig {}

    @Autowired
    private JdbcSimpleMessageDao simpleDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private void retrieveObjects() {
        String selectQuery = "SELECT * from SimpleMessages";
        List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(selectQuery);
        resultSet.stream().forEach(record -> log.info("{}", record));
    }

    private int countRowsInTable(String tableName) {
        return JdbcTestUtils.countRowsInTable(jdbcTemplate, tableName);
    }
   @Test
    public void shouldAutowiredDao(){
        assertThat(simpleDao).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
    }
   @Test
   public void shouldAddSomeRecord(){
      simpleDao.add(SimpleMessage.builder().text("convenient way added record").build());
      retrieveObjects();
      assertThat(countRowsInTable("SimpleMessages")).isEqualTo(4);
   }


}
