package com.epam.arlouskaya.gmail;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.epam.arlouskaya.gmail.steps.Steps;

public class GmailTest {
	
	private Steps steps;
	private static final String USER1="orlkat201501@gmail.com";
	private static final String USER2="orlkat201502@gmail.com";
	private static final String USER3="orlkat201503@gmail.com";
	private static final String PASSWORD = "epam2015";
	private static final String MSG = "Default message";
	private static final String PATH_TO_ATT = "c:\\111.txt";

  @BeforeMethod(description = "Init browser")
  public void setUp() {
	  steps = new Steps();
	  steps.initBrowser();
	  
  }

  /*	  @Test
  public void gm1dot1Spam() {	  
  steps.signIn(USER1, PASSWORD);
	  steps.sendMsg(USER2, MSG);
	  steps.signOut();
	  steps.signIn(USER2, PASSWORD);
	  steps.markLetterAsSpam(USER1);
	  steps.signOut();
	  steps.signIn(USER1, PASSWORD);
	  steps.sendMsg(USER2, MSG);
	  steps.signOut();
	  steps.signIn(USER2, PASSWORD);
	  Assert.assertTrue(steps.checkSpamFrom(USER1));
  }*/
 
  @Test
  public void gm1dot2Forward() {	
	 /* steps.signIn(USER2, PASSWORD);
	  steps.clickBtnSettings();
	  steps.chooseSettingsInSettings();
	  steps.chooseForwardTab();
	  steps.setForwardTo(USER3);
	  steps.signOut();
	  steps.signIn(USER3, PASSWORD);
	  steps.acceptForward(USER2, PASSWORD);
	  steps.signIn(USER2, PASSWORD);
	  steps.clickBtnSettings();
	  steps.chooseSettingsInSettings();
	  steps.chooseForwardTab();
	  steps.choosePropertyForwardCopy();
	  steps.chooseFiltersTab();
	  steps.createFilter(USER1);
	  steps.signOut();*/
	  steps.signIn(USER1, PASSWORD);
	  steps.sendMsgWithAttach(USER2, MSG, PATH_TO_ATT);
	  
	  
	  
  }

  @AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
	//	steps.closeDriver();
	}

}
