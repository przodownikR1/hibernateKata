package pl.java.scalatech;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

public abstract class ORMStandaloneTestCase {

	private SessionFactory sf;

	@Before
	public void setup() {
		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder()
			.applySetting( "hibernate.show_sql", "true" )
			.applySetting( "hibernate.format_sql", "true" )
			.applySetting( "hibernate.hbm2ddl.auto", "update" );

		Metadata metadata = new MetadataSources( srb.build() )
            .addAnnotatedClass(getEntityClass())
			.buildMetadata();

		sf = metadata.buildSessionFactory();
	}

	abstract protected Class<?> getEntityClass();



	@Test
	public void hhh123Test() throws Exception {

	}
}