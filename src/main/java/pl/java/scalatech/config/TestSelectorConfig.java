package pl.java.scalatech.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan(basePackages= {"pl.java.scalatech.repository.data"})
@EnableJpaRepositories(basePackages="pl.java.scalatech.repository.data")
@EntityScan(basePackages="pl.java.scalatech.domain"/*,basePackageClasses={Jsr310JpaConverters.class}*/)
//@EnableAutoConfiguration
@Import({DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@Profile("test")
@Slf4j
public class TestSelectorConfig {

}