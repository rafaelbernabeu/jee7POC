package jaxRs;

import ejb.stateless.WebCrawler;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@Produces("text/plain")
public class WelcomeController {

    @EJB
    private WebCrawler webCrawler;

    @GET
    public String welcome() {
        return "Welcome to the rest server!";
    }

}