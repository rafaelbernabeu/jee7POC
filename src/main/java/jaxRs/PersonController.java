package jaxRs;

import jpa.entities.Person;
import jpa.service.PersonRepository;

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
    private PersonRepository personRepository;

    @GET
    @Path("h2")
    public List<Person> listUsers1() {
        personRepository.save("Rafael");
        return personRepository.getAllEntities();
    }

    @GET
    @Path("mysql")
    public List<Person> listUsersFromMysql() {
        personRepository.save("Rafael");
        return personRepository.getAllEntities();
    }

    @POST
    public List<Person> saveNewPerson(String name) {
        personRepository.save(name);
        return personRepository.getAllEntities();
    }
}