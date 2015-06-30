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

public class main {
	private static final Logger logger = LogManager.getLogger(main.class
			.getName());

	public static void main(String[] args) {
		logger.info("Start programm");
		NoteBookController controller = new NoteBookController();
		Request request = new Request();
		Response response;
		response = controller.doCommand(CommandName.NEW_NOTEBOOK, request);
		if (response.getStatus() == true) {
			logger.info("Create notebook is OK");
		}
		Customer1 customer1 = new Customer1();
		Customer2 customer2 = new Customer2();
		customer1.run();
		customer2.run();

	}

}
