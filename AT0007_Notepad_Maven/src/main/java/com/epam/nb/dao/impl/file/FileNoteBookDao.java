package com.epam.nb.dao.impl.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.epam.nb.dao.DAOException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class FileNoteBookDao implements NoteBookDao {
	private final static String PATH = "temp.out";

	private void saveFile(NoteBook notebook) throws DAOException {
		try (FileOutputStream fos = new FileOutputStream(PATH);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(notebook);
			oos.flush();
		} catch (IOException e) {
			throw new DAOException("Fail save notebook to file", e);
		}

	}

	private NoteBook loadFile() throws DAOException {
		File file = new File(PATH);
		NoteBook noteBook = new NoteBook();
		try (FileInputStream fis = new FileInputStream(PATH);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			if (file.exists()) {
				noteBook = (NoteBook) ois.readObject();
			}
		} catch (ClassNotFoundException | IOException e) {
			throw new DAOException("Fail load notebook from file", e);
		}
		return noteBook;
	}

	public Note find(String contentSearch) throws DAOException {
		NoteBook noteBook = loadFile();
		if (noteBook != null) {
			for (int i = 0; i < noteBook.getSize(); i++) {
				if (noteBook.getNote(i).getContent().contains(contentSearch)) {
					return noteBook.getNote(i);
				}
			}
		}
		return null;
	}

	public Note find(int id) throws DAOException {
		NoteBook noteBook = loadFile();
		return noteBook.getNote(id);
	}

	public void add(Note note) throws DAOException {
		NoteBook noteBook = loadFile();
		noteBook.addNewNote(note);
		saveFile(noteBook);
	}

	@Override
	public void create() throws DAOException {
		File file = new File(PATH);
		if (file.exists()) {
			file.delete();
		}
		NoteBook noteBook = new NoteBook();
		saveFile(noteBook);
	}

	@Override
	public NoteBook notebook() throws DAOException {
		NoteBook noteBook = loadFile();
		return noteBook;
	}

}
