package com.epam.nb.entity;

import java.util.List;

public class Response {
	Note note;
	int idNote;
	boolean status;
	String errorMessage;
	
	public void setIdNote(int newId) {
		idNote=newId;
	}
	public int getIdNote() {
		return idNote;
	}
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
