package com.epam.nb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.nb.dao.DAOException;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;
import com.epam.nb.logic.LogicException;

public class NoteBookController {
	private NoteBookCommandHelper commandHelper = new NoteBookCommandHelper();
	private static final Logger logger = LogManager.getLogger(DAOException.class.getName());
	
	public Response doCommand(CommandName commandName, Request request) {
		Command command = commandHelper.getCommand(commandName);
		Response response = new Response();
		try {
			response = command.execute(request);
		} catch (LogicException e) {
			logger.error(e.getMessage());
			response.setErrorMessage(e.getMessage());
			response.setStatus(false);
		}
		return response;		
	}
}
