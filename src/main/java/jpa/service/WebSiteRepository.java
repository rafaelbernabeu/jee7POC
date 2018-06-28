package jpa.service;

import cdi.factory.DataManager;
import jpa.entities.Url;
import jpa.entities.WebSite;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Stateless
public class WebSiteRepository {

    @Named("mysql")
    @Inject
    private DataManager entityManager;

    public void save(WebSite webSite) { entityManager.persist(webSite); }

    public void save() {
        WebSite webSite = new WebSite();
        webSite.setName("");
        webSite.setUrl(new Url(""));
        save(webSite);
    }

    public DataManager getDataManager() {
        return this.entityManager;
    }
}