package com.epam.nb.dao.impl.xml;

import com.epam.nb.dao.DAOException;
import com.epam.nb.entity.NoteBook;

public interface XMLParser {
	NoteBook getNotebook(String path) throws DAOException;
}
