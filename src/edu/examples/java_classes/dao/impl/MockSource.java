package edu.examples.java_classes.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.entity.Note;

public class MockSource {
	private static List<Note> notes = new ArrayList<>();
	
	static {
		notes.add(new Note(1, "Телефон службы поддержки", "375461234321", new Date()));
		notes.add(new Note(2, "Список покупок", "сыр, соль, перец", new Date()));
		notes.add(new Note(3, "английский", "записаться на курсы", new Date()));
	}
	
	public static void add(Note n) {
		notes.add(n);
	}
	
	public static List<Note> get(){
		return notes;
	}
	
	public static int countOfNotes() {
		return notes.size();
	}
}
