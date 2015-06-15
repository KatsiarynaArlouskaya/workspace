package com.epam.nb.entity;

import java.util.List;

public class Response {
	Note note;
	//NoteBook notebook;
	boolean status;
	String errorMessage;
	
	/*public void setNotebook(NoteBook newNotebook){
		notebook=newNotebook;
	}
	public NoteBook getNotebook(){
		return notebook;
	}*/
	
	public void setNote(Note newNote){
		note = newNote;
	}
	public Note getNote(){
		return note;
	}
	public void setStatus(boolean newStatus){
		status = newStatus;
	}
	public boolean getStatus(){
		return status;
	}
	public void setErrorMessage (String newErrorMessage){
		errorMessage=newErrorMessage;
	}
	public String getErrorMessage(){
		return errorMessage;
	}
}
