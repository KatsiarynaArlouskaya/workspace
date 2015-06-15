package com.epam.nb.dao.impl.memory;

import java.util.Iterator;

import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class MemoryNoteBookDao implements NoteBookDao {


	public Note find(String contentSearch) {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		for (int i =0; i<noteBook.getSize(); i++){
			if (noteBook.getNote(i).getContent().contains(contentSearch)){
				return noteBook.getNote(i);
			}
		}
		return null;
	}


	public Note find(int id) {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		return noteBook.getNote(id);
	}


	public void add(Note note) {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		noteBook.addNewNote(note);
	}


	@Override
	public void create() {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
		
	}


	@Override
	public int size() {
		NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();		
		return noteBook.getSize();
	}

}
