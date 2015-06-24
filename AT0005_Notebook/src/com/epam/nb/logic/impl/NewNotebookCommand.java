package com.epam.nb.logic.impl;

import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.factory.DAOFactory;
import com.epam.nb.dao.DAOException;
import com.epam.nb.entity.NoteBook;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;
import com.epam.nb.logic.LogicException;


public class NewNotebookCommand implements Command {
	NoteBook notebook;

	public Response execute(Request request) throws LogicException {		
		NoteBookDao dao = DAOFactory.getInstance().getDAO();
		try {
			dao.create();
		} catch (DAOException e) {
			throw new LogicException("DAO error", e);
		}
		Response response = new Response();
		response.setStatus(true);
		return response;
	}



           

}
