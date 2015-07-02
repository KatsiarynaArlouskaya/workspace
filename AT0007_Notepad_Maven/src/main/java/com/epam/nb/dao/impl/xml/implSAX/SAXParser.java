package com.epam.nb.dao.impl.xml.implSAX;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.nb.dao.DAOException;
import com.epam.nb.dao.impl.xml.XMLParser;
import com.epam.nb.entity.NoteBook;

public class SAXParser implements XMLParser {


	@Override
	public NoteBook getNotebook(String pathXML) throws DAOException {
		NoteBook notebook = new NoteBook();
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			NotebookSaxHandler handler = new NotebookSaxHandler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource(pathXML));
			notebook = handler.getNotebook();
		} catch (SAXException e) {
			throw new DAOException("Fail parse XML", e);
		} catch (IOException e) {
			throw new DAOException("Fail to access to xml file", e);
		}

		
		return notebook;
	}

}
