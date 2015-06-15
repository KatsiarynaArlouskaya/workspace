package com.epam.nb.view;

import java.util.List;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class NoteBookConsoleView {
	void print(Note note) {
		System.out.println(note.getDate());
		System.out.println(note.getContent());
	}

	void print(List<Note> notes) {
		for (Note note : notes) {
			System.out.println(note.getDate());
			System.out.println(note.getContent());
		}
	}

	void print(Note... notes) {
		for (Note note : notes) {
			System.out.println(note.getDate());
			System.out.println(note.getContent());
		}
	}

	void print(NoteBook noteBook) {
		for (int i = 0; i < noteBook.getSize(); i++) {
			System.out.println(noteBook.getNote(i).getDate());
			System.out.println(noteBook.getNote(i).getContent());
		}
	}

}
