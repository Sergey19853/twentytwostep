package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class FindByTextNoteCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		String text;

		params = request.split("\n");
		text = params[1].split("=")[1];

		try {
			response = "Результат поиска по тексту: " + logic.find(text);
		} catch (LogicException e) {
			response = "Ошибка поиска. ";
		}
		
		return response;
	}
	
}
