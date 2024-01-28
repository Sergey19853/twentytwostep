package edu.examples.java_classes.dao;

import java.util.List;

import edu.examples.java_classes.entity.Note;

public interface NoteBookDao {

	void save(Note n) throws DaoException;

	void update(Note n) throws DaoException;

	List<Note> allNotes() throws DaoException;

	void clearNotes() throws DaoException;

	void deleteEntry(int id) throws DaoException;

}
