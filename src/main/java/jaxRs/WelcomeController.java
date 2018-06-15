package jaxRs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@Produces("text/plain")
public class WelcomeController {

    @GET
    public String welcome() {
        return "Welcome to the rest server!";
    }
}