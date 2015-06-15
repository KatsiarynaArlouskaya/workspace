package com.epam.nb.entity;

import java.util.ArrayList;
import java.util.Date;

public class NoteBook {
	ArrayList<Note> notes = new ArrayList<Note>();

	public void addNewNote(String content, Date date) {
		Note newNote = new Note(content, date);
		notes.add(newNote);
	}
	public void addNewNote(Note newNote) {
		notes.add(newNote);
	}

	public void delNote(int position) {
		notes.remove(position);
	}

	public Note getNote(int position) {
		return notes.get(position);
	}

	public int getSize() {
		return notes.size();
	}
}
