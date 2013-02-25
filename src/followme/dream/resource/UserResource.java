package followme.dream.resource;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.sun.jersey.api.view.ImplicitProduces;
import com.sun.jersey.spi.resource.Singleton;

import followme.dream.bean.*;
import followme.dream.dao.UserDAO;
import followme.dream.dao.UserDAOIm;

@Path("/userresource")
@ImplicitProduces("text/html;qs=5")

public class UserResource {
	
	private UserDAO userDao;
	@Context
	UriInfo uriInfo;
	@Context  
	Request request;
	
	// Return the list of Users to the user in the browser
	
	  @POST
	  @Produces("application/json")
	  public List<User> getUsers() {
	    List<User> users = new ArrayList<User>();
	    userDao=new UserDAOIm();
	    users=userDao.getAllUsers();
	    return users; 
	  }
	  
	  /*
	  // Return the list of todos for applications
	  @GET
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public List<User> getUsers() {
	    List<User> users = new ArrayList<User>();
	    users.addAll(UserDAO.instance.getModel().values());
	    return users; 
	  }*/
	  
	@POST
	@Path("/register")
    public void newUser(@FormParam("username") String username, 
			@FormParam("email") String email, @FormParam("password") String password,
	@Context HttpServletResponse servletResponse) throws IOException {
		
		userDao=new UserDAOIm();
		User user=null;
		user=userDao.findUserByName(username);
		if(user==null){
			user=new User(username, email, password);
			if(userDao.addUser(username, email, password))
				servletResponse.sendRedirect("../../home.jsp");	
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Username exists","user exists", 0);
			//servletResponse.sendRedirect("../../");	
		}
	}	

	@GET
	@Path("/user/{username}")
	@Produces("application/json")
	public User find(@PathParam("username") String username) throws Exception{
		userDao=new UserDAOIm();
		User user=null;     
		user=userDao.findUserByName(username);	
		System.out.println(username);
		if(user==null)
			System.out.println("user doesn't exists!");
		return user;			  
	}	
	
	
	@POST
	@Path("/login")
    public void login(@FormParam("username") String username, 
			 @FormParam("password") String password,
	@Context HttpServletResponse servletResponse) throws IOException {
		userDao=new UserDAOIm();
		//userdao.addUser(username, email, password);
		if(userDao.findUserByNameAndPass(username, password))
		{
			
			 servletResponse.sendRedirect("../../home.jsp");	  
		}	
		else
			throw new WebApplicationException(Response.Status.NOT_FOUND);

	}	  
	
	
}  
