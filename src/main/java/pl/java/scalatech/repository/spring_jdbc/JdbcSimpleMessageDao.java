package pl.java.scalatech.repository.spring_jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.basic.SimpleMessage;

@Repository
@Slf4j
public class JdbcSimpleMessageDao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertMessage;

    @Autowired
    public void JdbcSimpleMessageDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertMessage = new SimpleJdbcInsert(dataSource).withTableName("SimpleMessages");//usingGeneratedKeyColumns("id");
    }

    public void add(SimpleMessage message) {
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("MESSAGE_TEXT", message.getText()).addValue("id", 4);

        insertMessage.execute(parameters);

        //Number newId = insertMessage.executeAndReturnKey(parameters);
        //log.info("key {} ",newId);
        //message.setId(newId.longValue());
    }



}