package com.epam.nb.controller;

import com.epam.nb.entity.Request;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;

public class NoteBookController {
	NoteBookCommandHelper commandHelper = new NoteBookCommandHelper();
	
	public Response doCommand(CommandName commandName, Request request){
		Command command = commandHelper.getCommand(commandName);
		Response response = command.execute(request);
		return response;		
	}
}
