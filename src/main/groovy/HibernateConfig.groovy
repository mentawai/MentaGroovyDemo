
import model.Queixa

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.Transaction
import org.hibernate.cfg.AnnotationConfiguration


/**
 * Responsável pela configuração do banco de dados.
 * Seria um hibernate.cfg.xml.
 */
class HibernateConfig{

	def props = [
		"hibernate.dialect": "org.hibernate.dialect.HSQLDialect",
		"hibernate.connection.driver_class": "org.hsqldb.jdbcDriver",
		"hibernate.connection.url": "jdbc:hsqldb:mem:demodb",
		"hibernate.connection.username": "sa",
		"hibernate.connection.password": "",
		"hibernate.connection.pool_size": "1",
		"hibernate.connection.autocommit": "true",
		"hibernate.cache.provider_class": "org.hibernate.cache.NoCacheProvider",
		"hibernate.hbm2ddl.auto": "create-drop",
		"hibernate.show_sql": "true",
		"hibernate.transaction.factory_class": "org.hibernate.transaction.JDBCTransactionFactory",
		"hibernate.current_session_context_class": "thread"
	];
	
	SessionFactory getSessionFactory(){
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		//configuration.configure();
//		configuration.addAnnotatedClass(Queixa);
//		configuration.buildSessionFactory();
		  
		def config = new AnnotationConfiguration()
		props.each { k, v -> config.setProperty(k, v) }
		// config.addAnnotatedClass(Queixa)
		config.addAnnotatedClass(PessoaGroovy)
		config.buildSessionFactory(); 
	}
	
	void test(){
		
		print Queixa;
		
		Session session = getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();

		def lista =  session.createCriteria(Queixa).list();
		println lista;
		
		lista =  session.createCriteria(PessoaGroovy).list();
		println lista;
	}
}