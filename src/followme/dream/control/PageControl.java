package followme.dream.control;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.view.Viewable;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class PageControl{  

    @GET
    @Path("login")
    public Viewable login(@Context HttpServletRequest request) {
        System.out.println("/INDEX called");
        return new Viewable("/login.jsp", null);
    }
    
    @GET
    @Path("home")
    public Viewable home(@Context HttpServletRequest request) {
        System.out.println("/INDEX called");
        return new Viewable("/home.jsp", null);
    }
    
    
    
    
}