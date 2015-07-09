package com.epam.arlouskaya.gmail;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.epam.arlouskaya.gmail.steps.Steps;

public class GmailTest {
	
	private Steps steps;
	private static final String USER1="orlkat201501";
	private static final String USER2="orlkat201502";
	private static final String USER3="orlkat201503";
	private static final String PASSWORD = "epam2015";
	private static final String MSG = "Default message";

  @BeforeMethod(description = "Init browser")
  public void setUp() {
	  steps = new Steps();
	  steps.initBrowser();
	  
  }
  
  @Test
  public void f() {	  
	  Assert.assertTrue(steps.signIn(USER1, PASSWORD));
	  Assert.assertTrue(steps.sendMsg(USER2, MSG));
  }

  @AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
	//	steps.closeDriver();
	}

}
