package ejb.stateless;

import ejb.util.ThreadExecutor;
import jpa.entities.WebSite;
import jpa.service.UrlRepository;
import jpa.service.WebSiteRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import reflection.Parser;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class WebCrawler {

    @EJB
    private WebSiteRepository webSiteRepository;

    @EJB
    private UrlRepository urlRepository;

    public WebSite craw(String url) {
        try {
            WebSite webSite = new WebSite(url);
            Connection connection = Jsoup.connect(webSite.getUrl());
            connection.followRedirects(true);
            Document document = connection.get();
            webSite.setName(document.title());
            Elements hrefElements = document.getElementsByAttribute("href");
            Set<String> href = hrefElements.eachAttr("href").stream().filter(x -> x.startsWith("http")).collect(Collectors.toSet());

            href.forEach(x -> {
                webSite.addLink(x);
            });

            webSiteRepository.getDataManager().persist(webSite);
            return webSite;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void crawLinks(WebSite webSite) {
        webSite.getLinks().stream().forEach(x -> ThreadExecutor.getInstance().submit(() -> this.craw(x)));
    }

    public WebSite  crawUrlAndLinks(String url) {
        WebSite webSite = craw(url);
        crawLinks(webSite);
        return webSiteRepository.getDataManager().getEntityById(webSite.getId(), WebSite.class);
    }

    public List<String> findAll() {
        return webSiteRepository.getDataManager().getAllEntities(WebSite.class).stream().map(Parser::parseJSON).collect(Collectors.toList());
    }
}