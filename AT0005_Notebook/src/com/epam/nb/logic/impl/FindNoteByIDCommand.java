package com.epam.nb.logic.impl;

import com.epam.nb.dao.DAOException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.factory.DAOFactory;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.RequestParam;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;
import com.epam.nb.logic.LogicException;

public class FindNoteByIDCommand implements Command {
	@Override
	public Response execute(Request request) throws LogicException {
		int id_note= (int) request.getParam(RequestParam.ID_NOTE);
		NoteBookDao dao = DAOFactory.getInstance().getDAO();
		Note note;
		try {
			note = dao.find(id_note);
		} catch (DAOException e) {
			throw new LogicException("DAO error", e);
		}
		Response response = new Response();
		response.setNote(note);
		if (note != null) {
			response.setStatus(true);
		} else {
			response.setStatus(false);
			response.setErrorMessage("Note is not found");
		}
		return response;
	}
}
