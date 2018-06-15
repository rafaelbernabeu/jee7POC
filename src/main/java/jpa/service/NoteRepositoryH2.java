package jpa.service;

import jpa.entities.Note;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class NoteRepositoryH2 {

    @PersistenceContext(unitName = "h2")
    private EntityManager entityManager;

    public void saveNewNote(Note note) { entityManager.persist(note); }

    public void saveNewNote(String title, String text) {

        Note note = new Note();
        note.setTitle(title);
        note.setText(text);

        entityManager.persist(note);
    }

    public List<Note> getAllEntities() {
        return entityManager.createQuery("SELECT n FROM Note n", Note.class)
                .getResultList();
    }

}
