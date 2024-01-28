package edu.examples.java_classes.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class FindByDateNoteCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-mm-dd");
		Date date;

		params = request.split("\n");
		try {
			date = format.parse(params[1].split("=")[1]);
			response = "Результат поиска по дате: " + logic.find(date);
		} catch (ParseException e) {
			e.printStackTrace();
			response = "Ошибка поиска.";
		} catch(LogicException e) {
			response = "Что-то пошло не так.";
		}

		return response;
	}
	
}
