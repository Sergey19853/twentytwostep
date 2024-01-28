package edu.examples.java_classes.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.mappers.NoteMapper;
import edu.examples.java_classes.util.ReaderWriterFilesUtil;

public class FileNoteBookDao implements NoteBookDao{

	private List<Note> noteList;

	@Override
	public void save(Note note) throws DaoException {
		if(note.getId() == 0) {
			note.setId(noteList.size()+1);
		}
		if(note.getD() == null) {
			note.setD(new Date());
		}
		noteList.add(note);

		try {
			ReaderWriterFilesUtil.export(NoteMapper.notesToString(noteList, ";"));
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void update(Note note) throws DaoException {

		noteList.set(note.getId(),note);

		try {
			ReaderWriterFilesUtil.export(NoteMapper.notesToString(noteList, ";"));
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Note> allNotes() throws DaoException{
		List<Note> notes = new ArrayList<>();
		List<String> strNotes = null;
		try {
			strNotes = ReaderWriterFilesUtil.importNotes();
		} catch (IOException e) {
			throw new DaoException(e);
		}
		notes = strNotes.stream().map(NoteMapper::toNote).collect(Collectors.toList());
		noteList =  notes;
		return noteList;
	}

	public void clearNotes() throws DaoException{
		noteList.clear();
		try {
			ReaderWriterFilesUtil.export(NoteMapper.notesToString(noteList, ";"));
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	public void deleteEntry(int id) throws DaoException{
		int count = 0;

		for(Note note : noteList) {
			if(note.getId() == id) {
				noteList.remove(count);
				break;
			}
			count++;
		}

		try {
			ReaderWriterFilesUtil.export(NoteMapper.notesToString(noteList, ";"));
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

}
