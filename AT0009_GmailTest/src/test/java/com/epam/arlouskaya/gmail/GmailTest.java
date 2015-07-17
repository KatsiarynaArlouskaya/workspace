package com.epam.arlouskaya.gmail;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.epam.arlouskaya.gmail.steps.Steps;
import com.epam.arlouskaya.gmail.util.Utils;
import com.gargoylesoftware.htmlunit.WebConsole.Logger;

public class GmailTest {
	
	private Steps steps;
	private static final String USER2="orlkat201501@gmail.com";
	private static final String USER1="orlkat201502@gmail.com";
	private static final String USER3="orovsk201501@gmail.com";
	private static final String PASSWORD = "epam2015";
	private static final int LENGHT_MSG = 10;
	private static final int NUMBER_ICONS = 3;
	private static final String PATH_TO_ATT = "c:\\111.txt";
	private static final String PATH_TO_VERY_BIG_ATT = "c:\\VeryBig.zip";
	private static final String PATH_TO_NOT_PHOTO = "c:\\111.txt";
	private static final String WARN_MSG_BIG_FILE = "The file you are trying to send exceeds the 25MB";
	private static final String WINDOW_PICK_THEME = "Pick your theme";
	private static final String WARN_MSG_UPLOAD_NOT_SUPPRTED = "is not supported for upload";
	private static final String URL_PICT_THEME = "https://lh5.ggpht.com/r0SGNlUNQocspUn5Vq3meD_B4XCMHNzmsYX7GYs40h_cddB-3omCWopHqNGVsUqgzL5mdXFFxQ";

  @BeforeMethod(description = "Init browser")
  public void setUp() {
	  steps = new Steps();
	  steps.initBrowser();
	  
  }
/*
  @Test
  public void gm1dot1Spam() {	  
  steps.signIn(USER1, PASSWORD);
	  steps.sendMsg(USER2, Utils.getRandomString(LENGHT_MSG));
	  steps.signOut();
	  steps.signIn(USER2, PASSWORD);
	  steps.markLetterAsSpam(USER1);
	  steps.signOut();
	  steps.signIn(USER1, PASSWORD);
	  steps.sendMsg(USER2, Utils.getRandomString(LENGHT_MSG));
	  steps.signOut();
	  steps.signIn(USER2, PASSWORD);
	  Assert.assertTrue(steps.checkSpamFrom(USER1));
  }
 
   @Test
  public void gm1dot2Forward() {	
	  steps.signIn(USER2, PASSWORD);
	  steps.clickBtnSettings();
	  steps.chooseSettingsInSettings();
	  steps.chooseForwardTab();
	  steps.setForwardTo(USER3);
	  steps.signOut();
	  steps.signIn(USER3, PASSWORD);
	  steps.acceptForwardAndSignOut(USER2, PASSWORD);
	  steps.signIn(USER2, PASSWORD);
	  steps.clickBtnSettings();
	  steps.chooseSettingsInSettings();
  	  steps.chooseForwardTab();
	  steps.choosePropertyForwardCopy();
	  steps.chooseFiltersTab();
	  steps.createFilter(USER1);
	  steps.signOut();
	  steps.signIn(USER1, PASSWORD);
	  steps.sendMsgWithAttach(USER2, Utils.getRandomString(LENGHT_MSG), PATH_TO_ATT);
	  steps.sendMsg(USER2, Utils.getRandomString(LENGHT_MSG));
	  steps.signOut();
	  steps.signIn(USER2, PASSWORD);
	  Assert.assertTrue(steps.checkTrashFrom(USER1));
	  steps.goToLetter(USER1);
	  Assert.assertTrue(steps.checkLetterIsImportant(USER1));
	  Assert.assertTrue(steps.checkLetterHasAtt(USER1));
	  Assert.assertTrue(steps.checkInboxFrom(USER1));
	  steps.goToLetter(USER1);
	  Assert.assertFalse(steps.checkLetterHasAtt(USER1));
	  Assert.assertTrue(steps.checkLetterIsImportant(USER1));
	  steps.signOut();
	  steps.signIn(USER3, PASSWORD);
	  Assert.assertTrue(steps.checkInboxFrom(USER1));
	  Assert.assertFalse(steps.checkLetterHasAtt(USER1));
  }
  
  @Test
  public void gm1dot3MainMailBox() {
	  steps.signIn(USER1, PASSWORD);
	  steps.sendMsgWithAttach(USER2, Utils.getRandomString(LENGHT_MSG), PATH_TO_VERY_BIG_ATT);
	  Assert.assertTrue(steps.isMsgPresent(WARN_MSG_BIG_FILE));
  }
  
  
  @Test
  public void gm1dot4ThemesUploadFile() {
	  steps.signIn(USER1, PASSWORD);
	  steps.clickBtnSettings();
	  steps.chooseThemesInSettings();
	  Assert.assertTrue(steps.isMsgPresent(WINDOW_PICK_THEME));
	  steps.selectMyPhoto(PATH_TO_NOT_PHOTO);
	  Assert.assertTrue(steps.isMsgPresent(WARN_MSG_UPLOAD_NOT_SUPPRTED));
	  
  }
  
  @Test
  public void gm1dot5EmotIcons() {
	  steps.signIn(USER1, PASSWORD);
	  Assert.assertTrue(steps.sendMsgWithEmotIcons(USER2, Utils.getRandomString(LENGHT_MSG), NUMBER_ICONS));
	  steps.signOut();
	  steps.signIn(USER2, PASSWORD);
	  steps.goToLetter(USER1);
	  Assert.assertTrue(steps.checkLetterTextEmotIcon(NUMBER_ICONS));
  }
*/
 /* 
  @Test
  public void gm1dot6ThemesSelect() {
	  steps.signIn(USER1, PASSWORD);
	  steps.clickBtnSettings();
	  steps.chooseThemesInSettings();
	  steps.chooseTheme(URL_PICT_THEME);
	  Assert.assertTrue(steps.checkTheme(URL_PICT_THEME));
  }
  */
  
  @AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
	//	steps.closeDriver();
	}

}
