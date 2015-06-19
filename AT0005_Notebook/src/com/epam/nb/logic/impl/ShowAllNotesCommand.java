package com.epam.nb.logic.impl;

import java.util.Date;

import com.epam.nb.dao.DAOException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.factory.DAOFactory;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;
import com.epam.nb.logic.LogicException;
import com.epam.nb.view.NoteBookConsoleView;

public class ShowAllNotesCommand implements Command {

	@Override
	public Response execute(Request request) throws LogicException {
		NoteBookDao dao = DAOFactory.getInstance().getDAO();
		NoteBookConsoleView console = new NoteBookConsoleView();
		try {
			console.print(dao.notebook());
		} catch (DAOException e) {
			throw new LogicException(e.getMessage(), e);
		}
		Response response = new Response();
		response.setStatus(true);
		return response;
	}

}
