package pl.java.scalatech.basic;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.JdbcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JdbcConfig.class)
@SqlDataAccount
@ActiveProfiles("test")
@Slf4j
public class SpringMessageJdbcTest {
        @Autowired JdbcTemplate jdbcTemplate;

        @Test
        public void contextLoads() {
            String selectQuery = "SELECT * from SimpleMessages";
            List<Map<String, Object>> resultSet = jdbcTemplate.queryForList(selectQuery);
            log.info("RESULT : {}",resultSet);
        }

}
