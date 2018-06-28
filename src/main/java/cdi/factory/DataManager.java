package cdi.factory;

import cdi.EntityManagerMethods;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**se eu centralizar os metodos na clase a ser injetada (like this)
 * Pos: unica classe com tudo
 * Neg: nao consigo usar generics, metodos sem tipagem segura, quebra de encapsulamento
 *
 * se eu criar uma classe pra cada repositorio e
 * Pos: fácil manutenção
 * Neg:
 *
 * não posso utilizar injeção em interfaces.
 * */

public class DataManager extends EntityManagerMethods {

    @PersistenceContext(unitName = "h2")
    private EntityManager h2;

    @PersistenceContext(unitName = "mysql")
    private EntityManager mysql;

    private DataManager(){}

    @Named("h2")
    @Produces
    private DataManager getH2(){
        super.setEntityManager(h2);
        return this;
    }

    @Named("mysql")
    @Produces
    private DataManager getMySql(){
        super.setEntityManager(mysql);
        return this;
    }
}