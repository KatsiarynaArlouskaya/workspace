package com.epam.nb.view;

import java.util.List;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class NoteBookConsoleView {
	public void print(Note note) {
		System.out.println(note.getDate());
		System.out.println(note.getContent());
	}

	public void print(List<Note> notes) {
		for (Note note : notes) {
			System.out.println(note.getDate());
			System.out.println(note.getContent());
		}
	}

	public void print(Note... notes) {
		for (Note note : notes) {
			System.out.println(note.getDate());
			System.out.println(note.getContent());
		}
	}

	public void print(NoteBook noteBook) {
		System.out.println("Notebook consist of " + noteBook.getSize() + " notes");
		for (int i = 0; i < noteBook.getSize(); i++) {
			System.out.print(noteBook.getNote(i).getDate()+ "  ");
			System.out.println(noteBook.getNote(i).getContent());
		}
	}

}
