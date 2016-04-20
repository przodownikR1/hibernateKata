package pl.java.scalatech.basic;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.jdbc.JdbcTestUtils;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.SimpleSpringJDBC;

@SqlDataAccount
@ActiveProfiles("test")
@Slf4j
public class SpringMessageJdbcTest extends SimpleSpringJDBC{


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

        @Override
        protected int countRowsInTable(String tableName) {
            return JdbcTestUtils.countRowsInTable(jdbcTemplate, tableName);
        }

        @Test
        public void should_B_RetrieveRecords() {
            log.info("RETRIEVE OBJECTS");
            retrieveObjects();
            Assertions.assertThat(countRowsInTable("SimpleMessages")).isEqualTo(3);
        }

}
