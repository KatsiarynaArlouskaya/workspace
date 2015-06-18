package com.epam.nb.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class NoteBookConsoleView {
    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	public void print(Note note) {
		System.out.print(formatter.format(note.getDate()));
		System.out.println("  "+note.getContent());
	}

	public void print(List<Note> notes) {
		for (Note note : notes) {
			System.out.print(formatter.format(note.getDate()));
			System.out.println("  "+note.getContent());
		}
	}

	public void print(Note... notes) {
		for (Note note : notes) {
			System.out.print(formatter.format(note.getDate()));
			System.out.println("  "+note.getContent());
		}
	}

	public void print(NoteBook noteBook) {
		for (int i = 0; i < noteBook.getSize(); i++) {
			System.out.print(formatter.format(noteBook.getNote(i).getDate()));
			System.out.println("  "+noteBook.getNote(i).getContent());
		}
	}

}
