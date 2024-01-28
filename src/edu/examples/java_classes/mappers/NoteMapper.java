package edu.examples.java_classes.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.entity.Note;

public class NoteMapper {
	
	public static Note toNote(String data) {
		Note note = new Note();
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-mm-dd");
		Date date = null;
		String[] arrayNote = data.split(";");
		note.setId( Integer.parseInt(arrayNote[0]));
		note.setTitle( (arrayNote[1]));
		note.setContent( (arrayNote[2]));
		try {
			date = format.parse(arrayNote[3]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		note.setD(date);
		return note;
	}


	public static List<String> notesToString(List<Note> data, String delimiter) {
		List<String> strNotes = new ArrayList<>();

		for (Note note: data){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String strNote = note.getId() + delimiter + note.getTitle() + delimiter
					+ note.getContent() + delimiter + format.format(note.getD()) + "\n";
			strNotes.add(strNote);
		}
		return strNotes;
	}
}
