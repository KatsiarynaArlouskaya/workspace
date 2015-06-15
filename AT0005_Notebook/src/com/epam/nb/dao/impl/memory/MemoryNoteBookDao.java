package com.epam.nb.dao.impl.memory;

import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class MemoryNoteBookDao implements NoteBookDao {


	public Note find(String content) {
		// TODO Auto-generated method stub
		return null;
	}


	public Note find(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public void add(Note note) {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		noteBook.addNewNote(note);
	}

}
