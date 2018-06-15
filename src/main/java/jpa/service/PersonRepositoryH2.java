package jpa.service;

import jpa.entities.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonRepositoryH2 {

    @PersistenceContext(unitName = "h2")
    private EntityManager entityManager;

    public void saveNewEntity(String name) {

        Person testEntity = new Person();
        testEntity.setName(name);

        entityManager.persist(testEntity);
    }

    public List<Person> getAllEntities() {
        return entityManager.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList();
    }

}
