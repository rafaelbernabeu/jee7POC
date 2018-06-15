package jpa.service;

import jpa.entities.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonRepositoryMySql {

    @PersistenceContext(unitName = "mysql")
    private EntityManager entityManager;

    public void saveNewEntity() {

        Person testEntity = new Person();
        testEntity.setName("mytest");

        entityManager.persist(testEntity);
    }

    public List<Person> getAllEntities() {
        return entityManager.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList();
    }

}
