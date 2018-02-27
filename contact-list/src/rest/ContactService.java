package rest;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import entities.Person;


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
	@Produces(MediaType.APPLICATION_JSON)
	void saveNewClient(Person person);
	
	
	@DELETE
	@Path("/client/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	void deleteClient(@PathParam("id") int id);
			

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void updateClient(Person person);
	
}
