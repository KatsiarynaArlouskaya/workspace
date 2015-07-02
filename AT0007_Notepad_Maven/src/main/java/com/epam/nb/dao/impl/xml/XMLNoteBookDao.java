package com.epam.nb.dao.impl.xml;

import com.epam.nb.dao.DAOException;
import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class XMLNoteBookDao implements NoteBookDao {
	private final static String pathXML = "Notebook.xml";

	@Override
	public Note find(String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Note note) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public NoteBook notebook() throws DAOException {		
		return ParserFactory.getInstance().getParser().getNotebook(pathXML);
	}



}
