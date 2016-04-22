package pl.java.scalatech.common;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;

public abstract class ORMStandaloneTestCase {

    protected SessionFactory sf;

    @Before
    public void setup() {
        StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder()
            .applySetting( "hibernate.show_sql", "true" )
            .applySetting( "hibernate.format_sql", "true" )
            .applySetting( "hibernate.hbm2ddl.auto", "update" )
            .applySetting( "hibernate.dialect", "org.hibernate.dialect.H2Dialect" )
            .applySetting( "hibernate.connection.driver_class", "org.h2.Driver" )
            .applySetting( "hibernate.connection.url", "jdbc:h2:mem:testdbHibernate" )
            .applySetting( "hibernate.connection.username", "sa" )
            .applySetting( "hibernate.connection.password", "" )
            .applySetting( "hibernate.use_sql_comment", "true" )
            ;

        Metadata metadata = new MetadataSources( srb.build() )
            .addAnnotatedClass(getEntityClass())
            .buildMetadata();

        sf = metadata.buildSessionFactory();
    }

    abstract protected Class<?> getEntityClass();

}