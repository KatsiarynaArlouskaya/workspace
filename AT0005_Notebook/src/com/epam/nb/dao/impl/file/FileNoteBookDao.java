package com.epam.nb.dao.impl.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.impl.memory.MemoryNoteBookDao;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class FileNoteBookDao implements NoteBookDao{
	final static String PATH = "temp.out";

	private void  saveFile(NoteBook notebook) throws IOException {
		FileOutputStream fos = new FileOutputStream(PATH);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(notebook);
		oos.flush();
		oos.close();
		fos.close();
	}
	
	private NoteBook loadFile() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(PATH);
		ObjectInputStream ois = new ObjectInputStream(fis);
		NoteBook noteBook = (NoteBook) ois.readObject();
		ois.close();
		fis.close();
		return noteBook;
	}

	public Note find(String contentSearch) {
		try {
			NoteBook noteBook = loadFile();
			for (int i =0; i<noteBook.getSize(); i++){
				if (noteBook.getNote(i).getContent().contains(contentSearch)){
					return noteBook.getNote(i);
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public Note find(int id) {
		try {
			NoteBook noteBook = loadFile();
			return noteBook.getNote(id);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public void add(Note note) {		
			try {
				NoteBook noteBook = loadFile();
				noteBook.addNewNote(note);
				saveFile(noteBook);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


	@Override
	public void create() {
		File file = new File(PATH);
		if (file.exists()){
			file.delete();
		}
		try {
			NoteBook noteBook = new NoteBook();
			saveFile(noteBook);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public NoteBook notebook() {
		try {
			NoteBook noteBook = loadFile();
			return noteBook;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
