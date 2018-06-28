package jpa.service;

import cdi.factory.DataManager;
import jpa.entities.Person;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Stateless
public class PersonRepository {

    @Inject
    @Named("h2")
    private DataManager entityManagerH;

    @Named("mysql")
    @Inject
    private DataManager entityManagerM;

    public void save(String name) {

        Person testEntity = new Person();
        testEntity.setName(name);

        entityManagerH.persist(testEntity);
    }

    public List<Person> getAllEntities() {
        return entityManagerH.getAllEntities(Person.class);
    }

}