package jaxRs;

import jpa.entities.Note;
import jpa.service.NoteRepositoryH2;

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
    private NoteRepositoryH2 noteRepositoryH2;

    @GET
    public String listNotes() {
        return noteRepositoryH2.getAllEntities().toString();
    }

    @POST
    @Consumes("application/json")
    public String saveNewNote(Note note) {
        noteRepositoryH2.saveNewNote(note);
        return noteRepositoryH2.getAllEntities().toString();
    }
}