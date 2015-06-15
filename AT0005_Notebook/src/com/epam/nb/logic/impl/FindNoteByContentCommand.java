package com.epam.nb.logic.impl;

import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.factory.DAOFactory;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.RequestParam;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;

public class FindNoteByContentCommand implements Command {

	@Override
	public Response execute(Request request) {
		String contentSearch = (String) request
				.getParam(RequestParam.CONTENT_FOR_NOTE);
		NoteBookDao dao = DAOFactory.getInstance().getDAO();
		Note note = dao.find(contentSearch);
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
