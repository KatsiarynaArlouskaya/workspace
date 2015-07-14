package com.epam.arlouskaya.gmail.steps;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.arlouskaya.gmail.pages.InboxPage;
import com.epam.arlouskaya.gmail.pages.MessagePage;
import com.epam.arlouskaya.gmail.pages.SettingsPage;
import com.epam.arlouskaya.gmail.pages.StartPage;
import com.google.common.util.concurrent.SettableFuture;




public class Steps {
	private WebDriver driver=null;
	private static final Logger logger = LogManager.getLogger(Steps.class
			.getName());
	private SettingsPage settingsPage;
	private StartPage startPage;
	private InboxPage inboxPage;
	private MessagePage messagePage;
	
	
	public void initBrowser() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Browser started");
		settingsPage = new SettingsPage(driver);
		startPage = new StartPage(driver);
		inboxPage = new InboxPage(driver);
		messagePage = new MessagePage(driver);
	}
	
	public void closeDriver()
	{
		driver.quit();
	}
	
	public void signIn(String username, String password) {
		startPage.openPage();
		startPage.signIn(username, password);	
	}	
	
	public boolean  signOut() {
		inboxPage.signOut();
		return true;
	}

	public boolean sendMsg(String user, String msg) {	
		inboxPage.createNewMsg(user, msg);
		logger.info("Send msg is Ok");
		return true;
	}
	
	public void markLetterAsSpam(String user){
		inboxPage.goToLetter(user);
		messagePage.markLetterAsSpam();
	}

	public boolean checkSpamFrom(String user1) {
		inboxPage.goToSpamFolder();
		return inboxPage.isEmailPresent(user1);
	}

	public void clickBtnSettings() {
		inboxPage.clickBtnSettings();
		
	}

	public void chooseSettingsInSettings() {
		inboxPage.chooseInSettingsItemSettings();
		
	}

	public void chooseForwardTab() {
		settingsPage.chooseForwardTab();
		
	}

	public void setForwardTo(String user) {
		settingsPage.setForwardTo(user);
	}

	public void acceptForward(String user, String password) {
		inboxPage.goToLetter("forwarding-noreply@google.com");
		String confirmationCode = messagePage.getThemeOfMsg().substring(2, 11);
		logger.info("confirmation code:"+confirmationCode);
		signOut();
		signIn(user, password);
		inboxPage.clickBtnSettings();
		inboxPage.chooseInSettingsItemSettings();
		settingsPage.chooseForwardTab();
		settingsPage.enterConfirmCode(confirmationCode);
	}

	public void chooseForwardCopy() {
		settingsPage.chooseForwardCopy();
		
	}

	
}
