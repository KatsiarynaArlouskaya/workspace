package com.epam.nb.controller;

import com.epam.nb.entity.Request;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;
import com.epam.nb.logic.LogicException;

public class NoteBookController {
	NoteBookCommandHelper commandHelper = new NoteBookCommandHelper();
	
	public Response doCommand(CommandName commandName, Request request) throws LogicException{
		Command command = commandHelper.getCommand(commandName);
		Response response = command.execute(request);
		return response;		
	}
}
