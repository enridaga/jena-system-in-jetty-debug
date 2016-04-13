package enridaga.jenainjetty;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.jena.tdb.TDBFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application extends ResourceConfig implements ServletContextListener {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public Application() {
		packages("enridaga.jenainjetty");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info("Initializing context.");
		// XXX This might throw a NPE!
		TDBFactory.createDataset();
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
}
