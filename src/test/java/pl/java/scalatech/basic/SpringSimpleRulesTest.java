package pl.java.scalatech.basic;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.jdbc.JdbcTestUtils;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.JdbcConfig;
//Optionally specify a non-Spring Runner via @RunWith(...)
@SqlDataAccount
@ActiveProfiles("test")
@Slf4j
@ContextConfiguration(classes=JdbcConfig.class)
@FixMethodOrder(NAME_ASCENDING)
public class SpringSimpleRulesTest{

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired private  JdbcTemplate jdbcTemplate;

    @Test
    public void shouldRulesWork(){

    }
    @Test
    public void should_A_SAVE_RECORD(){
        log.info("SAVE RECORD");
        String sql = "insert into SimpleMessages (id, MESSAGE_TEXT) values (4, 'JDBCTEMPLATE INSERT !')";
        jdbcTemplate.execute(sql);
        retrieveObjects();
        Assertions.assertThat(countRowsInTable("SimpleMessages")).isEqualTo(4);
    }
    private void retrieveObjects() {
        String selectQuery = "SELECT * from SimpleMessages";
        List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(selectQuery);
        resultSet.stream().forEach(record -> log.info("{}",record));
    }

    private int countRowsInTable(String tableName) {
        return JdbcTestUtils.countRowsInTable(jdbcTemplate, tableName);
    }
}
