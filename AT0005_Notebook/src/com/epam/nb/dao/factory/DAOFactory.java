package com.epam.nb.dao.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.epam.nb.dao.NoteBookDao;
import com.epam.nb.dao.impl.db.DBNoteBookDao;
import com.epam.nb.dao.impl.memory.MemoryNoteBookDao;
import com.epam.nb.dao.impl.xml.XMLNoteBookDao;

public class DAOFactory {
	private static final DAOFactory daoFactory = new DAOFactory();

	Map<SourceType, NoteBookDao> dao = new HashMap<>();
	SourceType daoType;
	

	public static DAOFactory getInstance() {
		return daoFactory;
	}

	public DAOFactory() {
		ResourceBundle rb = ResourceBundle.getBundle("source");
		String source = rb.getString("dao.type");
		daoType = SourceType.valueOf(source);
		dao.put(SourceType.MEMORY, new MemoryNoteBookDao());
		dao.put(SourceType.DB, new DBNoteBookDao());
		dao.put(SourceType.XML, new XMLNoteBookDao());	
	}

	public NoteBookDao getDAO() {
		return dao.get(daoType);
	}
}
