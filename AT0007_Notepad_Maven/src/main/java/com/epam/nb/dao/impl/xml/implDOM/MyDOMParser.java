package com.epam.nb.dao.impl.xml.implDOM;

import java.io.IOException;
import java.util.Date;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.nb.dao.DAOException;
import com.epam.nb.dao.impl.xml.XMLParser;
import com.epam.nb.dao.impl.xml.XMLTags;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;


public class MyDOMParser implements XMLParser {

	DOMParser parser;
	@Override
	public NoteBook getNotebook(String pathXML) throws DAOException {
		parser = new DOMParser();
		try {
			parser.parse(pathXML);
		} catch (SAXException e) {
			throw new DAOException("Fail parse XML", e);
		} catch (IOException e) {
			throw new DAOException("Fail to access to xml file", e);
		}
		Document document = parser.getDocument();
		Element root = document.getDocumentElement();
		NoteBook notebook = new NoteBook();
		NodeList noteNodes = root.getElementsByTagName(XMLTags.NOTE.name().toLowerCase());
		Note note = null;
		for (int i = 0; i<noteNodes.getLength(); i++){
			note = new Note();
			Element noteElement = (Element) noteNodes.item(i);
			note.setDate(new Date(Long.parseLong(getSingleChild(noteElement, XMLTags.DATE).getTextContent().trim())));
			note.setContent(getSingleChild(noteElement, XMLTags.CONTENT).getTextContent().trim());
			notebook.addNewNote(note);
		}
		
		
		
		return notebook;
	}

	private static Element getSingleChild(Element element, XMLTags childName) {
		NodeList nlist = element.getElementsByTagName(childName.name().toLowerCase());
		Element child = (Element) nlist.item(0);
		return child;
	}
}
