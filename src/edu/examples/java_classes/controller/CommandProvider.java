package edu.examples.java_classes.controller;

import java.util.HashMap;
import java.util.Map;

import edu.examples.java_classes.controller.impl.AddNoteCommand;
import edu.examples.java_classes.controller.impl.AllNotesNoteCommand;
import edu.examples.java_classes.controller.impl.ClearNoteCommand;
import edu.examples.java_classes.controller.impl.DeleteEntryNoteCommand;
import edu.examples.java_classes.controller.impl.FindByDateNoteCommand;
import edu.examples.java_classes.controller.impl.FindByTextNoteCommand;
import edu.examples.java_classes.controller.impl.NoSuchCommand;
import edu.examples.java_classes.controller.impl.UpdateNoteCommand;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider(){
		repository.put(CommandName.ADD, new AddNoteCommand());
		repository.put(CommandName.UPDATE, new UpdateNoteCommand());
		repository.put(CommandName.CLEAR, new ClearNoteCommand());
		repository.put(CommandName.DELETEENTRY, new DeleteEntryNoteCommand());
		repository.put(CommandName.FINDBYTEXT, new FindByTextNoteCommand());
		repository.put(CommandName.FINDBYDATE, new FindByDateNoteCommand());
		repository.put(CommandName.ALLNOTES, new AllNotesNoteCommand());
		//...
		repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
	}
	
	Command getCommand(String name){
		CommandName commandName =null;
		Command command = null;
		
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		}catch(IllegalArgumentException | NullPointerException e){
			//write log
			command = repository.get(CommandName.WRONG_REQUEST);
		}				
		return command;
	}

}
