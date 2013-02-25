package followme.dream.resource;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import followme.dream.bean.*;
import followme.dream.dao.*;

@Path("/follower")
public class FollowerResource {
	
	private FollowerDAO ferDao;
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userid}")
	public List<User> findFollower(@PathParam("userid") int userid,
			@Context HttpServletResponse servletResponse) throws Exception{
    	
    	List<User> users = new ArrayList<User>();
    	ferDao=new FollowerDAOIm();
    	users=ferDao.findFollower(userid);
    	System.out.println("All");
		return users; 
	}
	

}
