import org.hibernate.cfg.AnnotationConfiguration;
import org.mentawai.core.Context;
import org.mentawai.filter.AutoWiringFilter;
import org.mentawai.filter.HibernateFilter;
import org.mentawai.filter.InjectionFilter;
import org.mentawai.filter.IoCFilter;
import org.mentawai.filter.ValidatorFilter;
import org.mentawai.groovy.GroovyActionConfig;
import org.mentawai.groovy.GroovyApplicationManager;
import org.mentawai.groovy.GroovyComponent;
import org.mentawai.groovy.GroovyInterpreter;
import org.mentawai.plugin.dyntag.DyntagsPlugin;


public class ApplicationManager extends GroovyApplicationManager {
	
	public void init(Context application) {
		setAutoView(true);
		setViewDir("/jsp");  
		addPlugin(new DyntagsPlugin());
		
		// Definido só para quando estiver rodando no jetty.
		GroovyInterpreter.setScriptPath("/media/Ricardo/Programacao/EclipseHelios-Linux/workspace/MentaGroovy/src/main/groovy");
		GroovyInterpreter.setReloadInterval(1000);
		
		// Componentes que serão injetadas dinamicamente nas Actions/Controllers.
		// Eles serão injetados usando os recuros de IoC (Inversão de Controle) do Mentawai
		// ==========================================================================================
		 
		ioc("queixaService", new GroovyComponent("service.QueixaService"));  
		//ioc("queixaDao", new GroovyComponent("dao.list.QueixaDaoList"));
		ioc("queixaDao", new GroovyComponent("dao.hibernate.QueixaDaoHbn"));
	
		
		// Carregar configuração do Hibernate (e filtro para controle de transação.)
		try {
			AnnotationConfiguration hbnConf = new AnnotationConfiguration();
			hbnConf.configure();
			HibernateFilter filter = new HibernateFilter(true, hbnConf.buildSessionFactory());
			addGlobalFilter(filter);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		addGlobalFilter(new IoCFilter());
		addGlobalFilter(new AutoWiringFilter());
		addGlobalFilter(new InjectionFilter());
		addGlobalFilter(new ValidatorFilter());  
	}
	 
	@Override  
	public void loadActions() {
		
		groovy("controller.QueixaController");
		 
		groovy("controller.QueixaController", "salvar")
			.on(SUCCESS, redir("QueixaController.cadastro.mtw", true))
			.on(ERROR, chain(groovyClass("controller.QueixaController"), "cadastro"));
 
		groovy("controller.QueixaController", "editar")
			.on(SUCCESS, chain(groovyClass("controller.QueixaController"), "cadastro"))
			.on(ERROR, chain(groovyClass("controller.QueixaController"), "cadastro"));
 
		groovy("controller.QueixaController", "excluir")
			.on(SUCCESS, chain(groovyClass("controller.QueixaController"), "cadastro"))
			.on(ERROR, chain(groovyClass("controller.QueixaController"), "cadastro"));
		
	}
}
