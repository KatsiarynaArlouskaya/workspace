package com.epam.nb.entity;

import java.util.Date;


public class Note {
	private String note;
    private Date date;
    
    public void setNote(String newNote){
    	note=newNote;
    }
    public void setDate(Date newDate){
    	date=newDate;
    }
    
    public String getNote() {
		return note;
	}
    
    public Date getDate() {
		return date;
	}
}
