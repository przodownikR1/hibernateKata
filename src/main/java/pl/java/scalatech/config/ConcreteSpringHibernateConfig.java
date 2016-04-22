package pl.java.scalatech.config;

import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ConcreteSpringHibernateConfig extends SpringHibernateConfig{
    @Override
    public void dataSourceConfigure(HikariConfig config) throws SQLException {
        log.info("++++++++++++++++++ databaseConfigure");
        config.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource");
        config.setConnectionTestQuery("VALUES 1");
        config.addDataSourceProperty("URL", "jdbc:h2:~/test");
        config.addDataSourceProperty("user", "sa");
        config.addDataSourceProperty("password", "");


    }
}
