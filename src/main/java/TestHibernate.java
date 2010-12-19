
import groovy.lang.GroovyObject;
import model.Queixa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.mentawai.core.ApplicationManager;
import org.mentawai.groovy.GroovyInterpreter;

public class TestHibernate {
	
	public static void dinamico() throws Exception{
		ApplicationManager.setRealPath("/media/Ricardo/Programacao/EclipseHelios-Linux/workspace/MentaGroovyDemo/src/main");
		GroovyInterpreter instance = GroovyInterpreter.getInstance();
		Class<?> groovyClass = instance.loadClass("HibernateConfig");
		GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
		Object[] argss = {};
		groovyObject.invokeMethod("test", argss);		
	}

	public static void main(String[] args) throws Exception {
		dinamico();
	}
}
