package enridaga.jenainjetty;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.jena.system.JenaSystem;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.tdb.base.file.Location;
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
		JenaSystem.DEBUG_INIT = true;
		JenaSystem.init();
		// Create a folder jena-debug-tdb
		File f = new File("./jena-debug-tdb");
		f.mkdirs();
		// XXX This might throw a NPE!
		TDBFactory.createDataset(Location.create(f.getAbsolutePath()));
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
}
