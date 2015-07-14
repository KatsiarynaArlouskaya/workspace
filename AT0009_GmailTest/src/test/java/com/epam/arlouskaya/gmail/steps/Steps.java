package com.epam.arlouskaya.gmail.steps;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.arlouskaya.gmail.pages.InboxPage;
import com.epam.arlouskaya.gmail.pages.MessagePage;
import com.epam.arlouskaya.gmail.pages.StartPage;




public class Steps {
	private WebDriver driver=null;
	private static final Logger logger = LogManager.getLogger(Steps.class
			.getName());
	
	
	public void initBrowser() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Browser started");
	}
	
	public void closeDriver()
	{
		driver.quit();
	}
	
	public boolean signIn(String username, String password) {
		StartPage startPage = new StartPage(driver);
		startPage.openPage();
		return startPage.signIn(username, password);	
	}	
	
	public boolean  signOut() {
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.signOut();
		return true;
	}

	public boolean sendMsg(String user, String msg) {	
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.createNewMsg(user, msg);
		logger.info("Send msg is Ok");
		return true;
	}
	
	public void markLetterAsSpam(String user){
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.goToLetter(user);
		MessagePage messagePage = new MessagePage(driver);
		messagePage.markLetterAsSpam();
	}

	public boolean checkSpamFrom(String user1) {
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.goToSpamFolder();
		return inboxPage.isEmailPresent(user1);
	}

	
}
