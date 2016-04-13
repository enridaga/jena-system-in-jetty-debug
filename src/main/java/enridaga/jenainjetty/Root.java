package enridaga.jenainjetty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
public class Root {
private static Logger log = LoggerFactory.getLogger(Root.class);
	
	@GET
	public Response get(){
		log.trace("Calling GET");
		return Response.ok("Server here.\n").build();
	}
}
