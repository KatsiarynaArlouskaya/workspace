package com.epam.nb.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.nb.entity.Note;

public class testNote {
	final String CONTENT = "new content";	
	final static int TEST_DATE = 1000;
	Date date; 
	Note note;
	@BeforeClass
	public void setUp(){
		date = new Date(TEST_DATE); 
		note = new Note();
	}
	@Test
	public void checkEmptyNote() {
		Assert.assertEquals(note.getContent(), null);
		Assert.assertEquals(note.getDate(), null);
	}
	@Test
	public void setgetContent() {
		note.setContent(CONTENT);
		Assert.assertEquals(note.getContent(), CONTENT);
	}
	@Test
	public void setgetData() {
		note.setDate(date);
		Assert.assertEquals(note.getDate(), date);
	}	
	@AfterClass
	public void tearDown(){
		date=null;	
		note=null;
	}
}
