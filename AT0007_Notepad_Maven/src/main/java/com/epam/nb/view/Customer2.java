package com.epam.nb.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.nb.controller.CommandName;
import com.epam.nb.controller.NoteBookController;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.RequestParam;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.LogicException;

public class Customer2 extends Thread{

	private static final Logger logger = LogManager.getLogger(main.class
			.getName());

	@Override
	public void run() {
		logger.info("2Start thread");
		NoteBookController controller = new NoteBookController();
		Request request = new Request();
		Response response;
		request = new Request();
		request.setParam(RequestParam.CONTENT_FOR_NOTE, "thirty");


			try {
				response = controller.doCommand(CommandName.ADD_NEW_NOTE, request);
				if (response.getStatus() == true) {
					logger.info("2Add note is OK");
				}
			} catch (LogicException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		request = new Request();
		request.setParam(RequestParam.CONTENT_FOR_NOTE, "fourty note");
		try {
			response = controller.doCommand(CommandName.ADD_NEW_NOTE, request);
			if (response.getStatus() == true) {
				logger.info("2Add note is OK");
				response = controller
						.doCommand(CommandName.SHOW_ALL_NOTES, request);
				if (response.getStatus() == true) {
					logger.info("2Show all notes is OK");
				}
			}
		} catch (LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		request = new Request();
		request.setParam(RequestParam.CONTENT_FOR_NOTE, "econd");
		try {
			response = controller.doCommand(CommandName.FIND_NOTE_BY_CONTENT,
					request);

		if (response.getStatus() == true) {
			logger.info("2Found note is OK");
			Note note = response.getNote();
			request = new Request();
			request.setParam(RequestParam.NOTE, note);
			response = controller.doCommand(CommandName.SHOW_NOTE, request);
		} else {
			logger.info("2Note is not found ");
		}
		} catch (LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
