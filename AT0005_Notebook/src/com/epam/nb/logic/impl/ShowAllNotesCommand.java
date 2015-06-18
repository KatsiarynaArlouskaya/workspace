package com.epam.nb.logic.impl;

import java.util.Date;

import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.factory.DAOFactory;
import com.epam.nb.dao.impl.memory.NoteBookProvider;
import com.epam.nb.entity.NoteBook;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;
import com.epam.nb.view.NoteBookConsoleView;

public class ShowAllNotesCommand implements Command {

	@Override
	public Response execute(Request request) {
		NoteBookDao dao = DAOFactory.getInstance().getDAO();
		NoteBookConsoleView console = new NoteBookConsoleView();
	/*	for (int i = 0; i < dao.size(); i++) {
			console.print(dao.find(i));
		}	*/
		console.print(dao.notebook());
		Response response = new Response();
		response.setStatus(true);
		return response;
	}

}
