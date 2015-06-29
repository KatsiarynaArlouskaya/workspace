package com.epam.nb.logic.impl;

import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.factory.DAOFactory;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.RequestParam;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;
import com.epam.nb.view.NoteBookConsoleView;

public class ShowNoteCommand implements Command {

	@Override
	public Response execute(Request request) {
		NoteBookConsoleView console = new NoteBookConsoleView();
		console.print((Note) request.getParam(RequestParam.NOTE));
		Response response = new Response();
		response.setStatus(true);
		return response;
	}

}
