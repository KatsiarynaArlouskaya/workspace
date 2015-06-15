package com.epam.nb.logic.impl;

import java.util.Date;

import com.epam.nb.dao.memory.NoteBookProvider;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;
import com.epam.nb.entity.Request;
import com.epam.nb.entity.RequestParam;
import com.epam.nb.entity.Response;
import com.epam.nb.logic.Command;

public class AddNewNoteCommand implements Command{
    public Response execute(Request request){
        String content = (String) request.getParam(RequestParam.CONTENT_FOR_NOTE);
        Date date = (Date) request.getParam(RequestParam.DATE_FOR_NOTE);
        Note note = new Note(content, date);
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        noteBook.addNewNote(note);
        Response response = new Response();
        response.setStatus(true);
        return response;
}              

}
