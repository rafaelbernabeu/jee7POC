package jaxRs;

import jpa.entities.Note;
import jpa.service.NoteRepository;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/note")
@Produces("text/plain")
public class NoteController {

    @EJB
    private NoteRepository noteRepository;

    @GET
    public String listNotes() {
        noteRepository.save("Rafael","Bernabeu");
        return noteRepository.getAllEntities().toString();
    }

    @POST
    @Consumes("application/json")
    public String saveNewNote(Note note) {
        noteRepository.save(note);
        return noteRepository.getAllEntities().toString();
    }
}