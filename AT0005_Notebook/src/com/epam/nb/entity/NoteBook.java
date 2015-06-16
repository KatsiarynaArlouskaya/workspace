package com.epam.nb.entity;

import java.util.ArrayList;
import java.util.Date;

public class NoteBook {
	private ArrayList<Note> notes = new ArrayList<Note>();

	public String toString() {
		return getClass().getName() + "@" + "size: " + notes.size();
	}

	public int hashCode() {
		return (int) (((null == notes) ? 0 : notes.hashCode()));
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		NoteBook notebook = (NoteBook) obj;
		if (notes.size() != notebook.getSize()) {
			return false;
		} else {
			for (int i = 0; i < notes.size(); i++) {
				if (!notes.get(i).equals(notebook.getNote(i))) {
					return false;
				}
			}
		}
		return true;
	}

	public void addNewNote(String content, Date date) {
		Note newNote = new Note(content, date);
		notes.add(newNote);
	}
	
	public void addNewNote(String content) {
		Note newNote = new Note(content);
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
