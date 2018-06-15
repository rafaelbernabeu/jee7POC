package jaxRs;

import jpa.entities.Person;
import jpa.service.PersonRepositoryH2;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/user")
@Produces("text/plain")
public class PersonController {

    @EJB
    private PersonRepositoryH2 personRepository;

    @GET
    public List<Person> listUsers() {
        personRepository.saveNewEntity("Rafael");
        return personRepository.getAllEntities();
    }

    @POST
    public List<Person> saveNewPerson(String name) {
        personRepository.saveNewEntity(name);
        return personRepository.getAllEntities();
    }
}