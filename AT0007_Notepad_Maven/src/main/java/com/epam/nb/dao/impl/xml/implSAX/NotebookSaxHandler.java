package com.epam.nb.dao.impl.xml.implSAX;

import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.nb.dao.impl.xml.XMLTags;
import com.epam.nb.entity.Note;
import com.epam.nb.entity.NoteBook;

public class NotebookSaxHandler extends DefaultHandler{
	private NoteBook notebook = new NoteBook();
	private Note note = new Note();
	private StringBuilder text;
	
	public NoteBook getNotebook(){
		return notebook;
	}
	
	public void startDocument() {}
	
	public void endDocument(){}
	
	
	public void startElement(String uri, String localName, String qName, Attributes attributes){
		text = new StringBuilder();
		if (qName.equals("note")){
			note = new Note();
		}
	}
	
	public void characters(char[] buffer, int start, int length){
		text.append(buffer, start, length);
	}
	
	public void endElement(String uri, String localName, String qName) {
		XMLTags tagName = XMLTags.valueOf(localName.toUpperCase());
		switch (tagName) {
		case DATE:
			note.setDate(new Date(Long.valueOf(text.toString())));
			break;
		case CONTENT:
			note.setContent(text.toString());
			break;
		case NOTE:
			notebook.addNewNote(note);
			note=null;
			break;
		}
	}
}
