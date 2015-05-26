package ${package}.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ${package}.BaseController;

@Path("/")
public class Hello extends BaseController {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response getHelloWorld() {
		setPageTitle("Hello World page");
		return Response.ok(render("hello")).build();
	}
}
