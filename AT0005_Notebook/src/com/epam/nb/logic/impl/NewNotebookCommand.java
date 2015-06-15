package com.epam.nb.logic.impl;

import com.epam.nb.dao.impl.memory.NoteBookProvider;
import com.epam.nb.entity.NoteBook;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;


public class NewNotebookCommand implements Command {
	NoteBook notebook;

	public Response execute(Request request) {		
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		Response response = new Response();
		response.setStatus(true);
		return response;
	}



           

}
