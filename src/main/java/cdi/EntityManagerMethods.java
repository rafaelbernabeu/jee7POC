package cdi;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class EntityManagerMethods {

    private EntityManager entityManager;

    public <T> Collection<T> persist(Collection<T> e) {
        e.stream().forEach(entityManager::persist);
        return e;
    }

    public <T> T persist(T e) {
        entityManager.persist(e);
        return e;
    }

    public <T> Collection<T> merge(Collection<T> e) {
        return e.stream().map(entityManager::merge).collect(Collectors.toList());
    }

    public <T> T merge(T e) {
        return entityManager.merge(e);
    }

    public <T> List<T> getAllEntities(Class<T> clazz) {
        return entityManager.createQuery("SELECT x FROM " + clazz.getName() + " x", clazz).getResultList();
    }

    public <T> T getEntityById(Integer id, Class<T> clazz) {
        TypedQuery<T> query = entityManager.createQuery("SELECT x FROM " + clazz.getName() + " x WHERE x.id = :id", clazz);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}