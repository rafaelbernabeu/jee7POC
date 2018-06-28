package jpa.service;

import cdi.factory.DataManager;
import jpa.entities.Url;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Stateless
public class UrlRepository {

    @Named("mysql")
    @Inject
    private DataManager entityManager;

    public List<Url> getAllEntities() {
        return entityManager.getAllEntities(Url.class);
    }

    public DataManager getEntityManager() {
        return entityManager;
    }
}