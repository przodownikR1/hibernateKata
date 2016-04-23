package pl.java.scalatech.spring.hib;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.ConcreteSpringHibernateConfig;
import pl.java.scalatech.config.PropertiesLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {  PropertiesLoader.class,ConcreteSpringHibernateConfig.class })
@Slf4j
public class HibernateTemplateTest {
   // @Autowired
    private HibernateTemplate hibernate5Template;

    @Autowired
    private DataSource datasource;

    @Test
    @Ignore
    public void shouldBootstrapWork(){
     //   Assertions.assertThat(datasource).isNotNull();
       //Assertions.assertThat(hibernate5Template).isNotNull();
    }


}
