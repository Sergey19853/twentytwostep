package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class DeleteEntryNoteCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		int id;

		params = request.split("\n");
		id = Integer.parseInt(params[1].split("=")[1]);

		try {
			logic.deleteEntry(id);
			response = "Запись удалена успешно.";
		} catch (LogicException e) {
			response = "Ошибка удаления записи.";
		}
		
		return response;
	}
	
}
