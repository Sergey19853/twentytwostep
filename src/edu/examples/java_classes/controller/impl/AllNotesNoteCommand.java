package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class AllNotesNoteCommand implements Command {
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;

		try {
			response = "Вывод записей" + logic.allNotes();
		} catch (LogicException e) {
			response = "Ошибка вывода записей";
		}
		
		return response;
	}

}
