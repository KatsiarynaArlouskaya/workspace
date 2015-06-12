package com.epam.nb.entity;

import java.util.Date;


public class Note {
	private String content;
    private Date date;
    final static String STRING_EMPTY ="";
    final static int DEFAULT_DATE = 0;
    
    Note (String newContent, Date newDate){
    	content=newContent;
    	date = newDate;
    }
    
    public Note() {
    	content=STRING_EMPTY;
    	date = new Date(DEFAULT_DATE);    	
	}

	public void setContent(String newContent){
    	content=newContent;
    }
    public void setDate(Date newDate){
    	date=newDate;
    }
    
    public String getContent() {
		return content;
	}
    
    public Date getDate() {
		return date;
	}
}
