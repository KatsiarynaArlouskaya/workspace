/**
 * 
 */
package com.epam.nb.dao.impl.xml.implStAX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.epam.nb.dao.DAOException;
import com.epam.nb.dao.impl.xml.XMLParser;
import com.epam.nb.dao.impl.xml.XMLTags;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

/**
 * @author Katsiaryna_Arlouskay
 *
 */
public class StAXParser implements XMLParser {


	@Override
	public NoteBook getNotebook(String pathXML) throws DAOException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		NoteBook notebook = null;
		try {
			InputStream input = new FileInputStream(pathXML);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			notebook = process(reader);
		} catch (FileNotFoundException e) {
			throw new DAOException("XML not found ", e);
		} catch (XMLStreamException e) {
			throw new DAOException("Fail to read XML ", e);
		}
		return notebook;
	}

	private NoteBook process(XMLStreamReader reader) throws XMLStreamException {
		NoteBook notebook = new NoteBook();
		Note note = new Note();
		XMLTags elementName = null;
		while (reader.hasNext()){
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = XMLTags.valueOf(reader.getLocalName().toUpperCase().replace(":", "_"));
				switch (elementName) {
				case NOTE:
					note = new Note();
					break;
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()){
					break;
				}
				switch (elementName) {
				case CONTENT:
					note.setContent(text);
					break;
				case DATE:
					note.setDate(new Date(Long.valueOf(text)));
					break;
				}
				break;
				
			case XMLStreamConstants.END_ELEMENT:
				elementName = XMLTags.valueOf(reader.getLocalName().toUpperCase().replace(":", "_"));
				switch (elementName) {
				case NOTE:
					notebook.addNewNote(note);
					break;
				}
				break;

			}
		}
		return notebook;
	}

}
