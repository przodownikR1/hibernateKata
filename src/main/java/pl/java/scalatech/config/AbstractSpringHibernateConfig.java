package pl.java.scalatech.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Configuration
@PropertySource("classpath:spring-data.properties")
@Slf4j
abstract class SpringHibernateConfig {

    public SpringHibernateConfig() {
      log.info("SpringHibernateConfig() ");
    }

    @Autowired
    private Environment env;

    @Value("${dataSource.driverClassName}")
    protected String driver;

    @Value("${dataSource.url}")
    protected String url;

    @Value("${dataSource.username}")
    protected String username;

    @Value("${dataSource.password}")
    protected String password;

    @Value("${hibernate.dialect}")
    protected String dialect;

    @Value("${hibernate.hbm2ddl.auto}")
    protected Boolean hbm2ddlAuto;

    @Value("${hibernate.show.sql}")
    protected Boolean showSql;

    @Value("${jpa.package}")
    protected String jpaPackage;

    @Value("${jpa.hikariMaxPoolSize}")
    protected int maxPoolSize;

    @Value("${jpa.hikariConnectionTimeoutMs}")
    protected long connectionTimeoutMs;

    @Value("${jpa.hikariIdleTimeoutMs}")
    protected long idleTimeoutMs;

    @Value("${jpa.hikariMaxLifetimeMs}")
    protected long maxLifetimeMs;

    @Value("${jpa.hikariRegisterMbeans}")
    protected boolean registerMbeans;

    public abstract void dataSourceConfigure(HikariConfig hikariConfig) throws SQLException;


    @Bean
    public DataSource datasource() throws SQLException{
        log.info("create datasource");
        HikariConfig config = new HikariConfig();
        dataSourceConfigure(config);
        config.setMaximumPoolSize(maxPoolSize);
       // config.setConnectionTimeout(connectionTimeoutMs);
        config.setIdleTimeout(idleTimeoutMs);
        config.setMaxLifetime(maxLifetimeMs);
        config.setRegisterMbeans(registerMbeans);
        config.setPoolName("pool");
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
}


    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource)
    {
        LocalSessionFactoryBean asfb = new LocalSessionFactoryBean();
        asfb.setDataSource(dataSource);
        asfb.setHibernateProperties(hibernateProperties());
        asfb.setPackagesToScan(new String[]{jpaPackage});

        return asfb;
    }

    @Bean
    public Properties hibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.connection.driver_class", driver);
        properties.put("hibernate.connection.url", url);
        properties.put("hibernate.connection.username", username);

        properties.put("hibernate.connection.password", password);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.use_sql_comment", true);
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", false);

        return properties;
    }


    @Bean
    public HibernateTemplate hibernate5Template(SessionFactory sessionFactory) {
        return new HibernateTemplate(sessionFactory);
    }

    @Bean
    public HibernateTransactionManager hibernate5TransactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

}
