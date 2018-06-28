package jpa.service;

import cdi.factory.DataManager;
import jpa.entities.Note;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Stateless
public class NoteRepository {

    @Named("mysql")
    @Inject
    private DataManager entityManager;

    public void save(Note note) { entityManager.persist(note); }

    public void save(String title, String text) {
        Note note = new Note();
        note.setTitle(title);
        note.setText(text);
        save(note);
    }

    public List<Note> getAllEntities() {
        return entityManager.getAllEntities(Note.class);
    }

}