package rest;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/contactlist")
public interface ContactService {

	
	@GET
	@Path("/client/names")
	@Produces(MediaType.APPLICATION_JSON)
	List<Person> listNames();
	
	
	@GET
	@Path("/client/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Person getClient(@PathParam("id") int id);
	
	
	@POST
	@Path("/client/{id}/{nm}/{ph}/{em}/{wht}")
	@Produces(MediaType.APPLICATION_JSON)
	void saveNewClient(@FormParam("id") int id,
					   @FormParam("nm") String name, 
					   @FormParam("ph") String phone,
					   @FormParam("em") String email,
					   @FormParam("wht") String whatsapp);
	
	
	@DELETE
	@Path("/client/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	void deleteClient(@PathParam("id") int id);
	
}
