package com.epam.nb.controller;

import java.util.HashMap;
import java.util.Map;

import com.epam.nb.logic.Command;
import com.epam.nb.logic.impl.AddNewNoteCommand;
import com.epam.nb.logic.impl.NewNotebookCommand;
import com.epam.nb.logic.impl.ShowAllNotesCommand;

public class NoteBookCommandHelper {
	Map<CommandName, Command>commands = new HashMap<>();
	
	public NoteBookCommandHelper() {
		commands.put(CommandName.ADD_NEW_NOTE, new AddNewNoteCommand());
		commands.put(CommandName.NEW_NOTEBOOK, new NewNotebookCommand());
		commands.put(CommandName.SHOW_ALL_NOTES, new ShowAllNotesCommand());
	}
	
	public Command getCommand(CommandName command){
		return commands.get(command);
	}
	
}
