package com.epam.nb.logic.impl;

import java.util.Date;

import com.epam.nb.dao.memory.NoteBookProvider;
import com.epam.nb.entity.NoteBook;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;
import com.epam.nb.view.NoteBookConsoleView;

public class ShowAllNotesCommand implements Command {

	@Override
	public Response execute(Request request) {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		NoteBookConsoleView console = new NoteBookConsoleView();
		console.print(noteBook);
		Response response = new Response();
		response.setStatus(true);
		return response;
	}

}
