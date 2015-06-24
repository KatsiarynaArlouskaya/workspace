package com.epam.nb.view;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.epam.nb.controller.CommandName;
import com.epam.nb.controller.NoteBookController;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.RequestParam;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.LogicException;

public class main {
	private static final Logger logger = LogManager.getLogger(main.class
			.getName());

	public static void main(String[] args) {
		logger.info("Start programm");
		NoteBookController controller = new NoteBookController();
		try {
			Request request = new Request();
			Response response;
			response = controller.doCommand(CommandName.NEW_NOTEBOOK, request);
			if (response.getStatus() == true) {
				logger.info("Create notebook is OK");
			}
			request = new Request();
			request.setParam(RequestParam.CONTENT_FOR_NOTE, "first note");

			response = controller.doCommand(CommandName.ADD_NEW_NOTE, request);
			if (response.getStatus() == true) {
				logger.info("Add note is OK");
			}
			request = new Request();
			request.setParam(RequestParam.CONTENT_FOR_NOTE, "second note");
			response = controller.doCommand(CommandName.ADD_NEW_NOTE, request);
			if (response.getStatus() == true) {
				logger.info("Add note is OK");
			}
			response = controller
					.doCommand(CommandName.SHOW_ALL_NOTES, request);
			if (response.getStatus() == true) {
				logger.info("Show all notes is OK");
			}
			request = new Request();
			request.setParam(RequestParam.CONTENT_FOR_NOTE, "econd");
			response = controller.doCommand(CommandName.FIND_NOTE_BY_CONTENT,
					request);
			if (response.getStatus() == true) {
				logger.info("Found note is OK");
				Note note = response.getNote();
				request = new Request();
				request.setParam(RequestParam.NOTE, note);
				response = controller.doCommand(CommandName.SHOW_NOTE, request);
			} else {
				logger.info("Note is not found ");
			}
		} catch (LogicException e) {
			e.printStackTrace();
		}
	}

}
