package com.epam.nb.logic.impl;

import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.factory.DAOFactory;
import com.epam.nb.dao.impl.memory.NoteBookProvider;
import com.epam.nb.entity.NoteBook;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;


public class NewNotebookCommand implements Command {
	NoteBook notebook;

	public Response execute(Request request) {		
		NoteBookDao dao = DAOFactory.getInstance().getDAO();
		dao.create();
		Response response = new Response();
		response.setStatus(true);
		return response;
	}



           

}
