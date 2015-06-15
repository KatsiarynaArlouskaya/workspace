package com.epam.nb.entity;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.epam.nb.dao.memory.NoteBookProvider;

public class testNotebook {
	final String TEST_CONTENT = "new content";	
	final static int TEST_DATE = 1000;
	final static int SIZE_NOTEBOOK_START = 0;
	final static int SIZE_NOTEBOOK_AFTER_ADD = 1;
	final static int POSITION_TEST_NOTE = 0;
	Date testDate;
	NoteBook notebook;
	Note note;
	@BeforeClass
	public void beforeClass() {
		testDate = new Date(TEST_DATE); 
		note = new Note(TEST_CONTENT, testDate);
		NoteBookProvider notebookProvider= new NoteBookProvider();
		notebook = notebookProvider.getNoteBook();
	}

	@Test
	public void testAddGetNote1() {
		Assert.assertEquals(notebook.getSize(), SIZE_NOTEBOOK_START);
		notebook.addNewNote(TEST_CONTENT, testDate);
		Assert.assertEquals(notebook.getSize(), SIZE_NOTEBOOK_AFTER_ADD);
		Assert.assertEquals(notebook.getNote(POSITION_TEST_NOTE).getContent(),TEST_CONTENT);
		Assert.assertEquals(notebook.getNote(POSITION_TEST_NOTE).getDate(),testDate);
		notebook.delNote(POSITION_TEST_NOTE);
		Assert.assertEquals(notebook.getSize(), SIZE_NOTEBOOK_START);
	}
	
	@Test
	public void testAddGetNote2() {
		Assert.assertEquals(notebook.getSize(), SIZE_NOTEBOOK_START);
		notebook.addNewNote(note);
		Assert.assertEquals(notebook.getSize(), SIZE_NOTEBOOK_AFTER_ADD);
		Assert.assertTrue(notebook.getNote(POSITION_TEST_NOTE).equals(note));
		notebook.delNote(POSITION_TEST_NOTE);
		Assert.assertEquals(notebook.getSize(), SIZE_NOTEBOOK_START);
	}

	@AfterClass
	public void afterClass() {
		testDate = null;
		note = null;
		notebook =null;
	}

}
