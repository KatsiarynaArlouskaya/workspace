package com.epam.nb.logic.impl;

import java.util.Date;

import com.epam.nb.dao.DAOException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.factory.DAOFactory;
import com.epam.nb.dao.impl.memory.NoteBookProvider;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.RequestParam;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;
import com.epam.nb.logic.LogicException;

public class AddNewNoteCommand implements Command {
	public Response execute(Request request) throws LogicException {
		Note note;
		String content = (String) request
				.getParam(RequestParam.CONTENT_FOR_NOTE);
		Date date = (Date) request.getParam(RequestParam.DATE_FOR_NOTE);
		if (date != null) {
			note = new Note(content, date);
		} else {
			note = new Note(content);
		}
		NoteBookDao dao = DAOFactory.getInstance().getDAO();
		try {
			dao.add(note);
		} catch (DAOException e) {
			throw new LogicException("DAO error", e);
		}
		Response response = new Response();
		response.setStatus(true);
		return response;
	}

}
