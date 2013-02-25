package followme.dream.resource;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
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

@Path("/message")
public class MessageResource {

	private MessageDAO msgDao;
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	// Return the list of Users to the user in the browser
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userid}")
	public List<Message> findAll(@PathParam("userid") int userid,
			@Context HttpServletResponse servletResponse) throws Exception{
    	
    	List<Message> msgs = new ArrayList<Message>();
    	msgDao=new MessageDAOIm();
    	msgs=msgDao.getAllMessage(userid);
    	System.out.print("All");
		return msgs; 
		}
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/personal/{userid}")
	public List<Message> findPersonal(@PathParam("userid") int userid,
			@Context HttpServletResponse servletResponse) throws Exception{
    	
    	List<Message> msgs = new ArrayList<Message>();
    	msgDao=new MessageDAOIm();
    	msgs=msgDao.getMessageByUser(userid);
    	System.out.print("Personal");
		return msgs; 
		}
    
    @POST
    @Path("/create")
    public void newMessage(@FormParam("content") String content, 
			@FormParam("date") Date date, @FormParam("userID") int userid,
	@Context HttpServletResponse servletResponse) throws IOException {

		msgDao=new MessageDAOIm();
		msgDao.addMessage(content, date, userid);	
	}
    
    @DELETE
    @Path("/{msgid}")
    public void delMessage(@PathParam("msgid") int msgid,
	@Context HttpServletResponse servletResponse) throws IOException {

		msgDao=new MessageDAOIm();
		msgDao.removeMessageById(msgid);
			
	}
    
}
