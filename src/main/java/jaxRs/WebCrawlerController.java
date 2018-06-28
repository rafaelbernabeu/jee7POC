package jaxRs;

import ejb.stateless.WebCrawler;
import jpa.service.WebSiteRepository;
import reflection.Parser;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/craw")
@Produces("text/plain")
public class WebCrawlerController {

    @EJB
    private WebCrawler webCrawler;

    @EJB
    private WebSiteRepository webSiteRepository;

    @Inject
    private Parser parser;

    @GET
    public List<String> listWebSites() {
        return webCrawler.findAll();
    }

    @GET
    @Path("{url}")
    public String craw(@PathParam("url") String url) {
        return webCrawler.crawUrlAndLinks(url).toString();
    }
}