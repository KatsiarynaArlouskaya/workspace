package com.epam.arlouskaya.gmail.steps;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.arlouskaya.gmail.pages.InboxPage;
import com.epam.arlouskaya.gmail.pages.MessagePage;
import com.epam.arlouskaya.gmail.pages.SettingsPage;
import com.epam.arlouskaya.gmail.pages.StartPage;
import com.epam.arlouskaya.gmail.pages.ThemePage;
import com.google.common.util.concurrent.SettableFuture;




public class Steps {
	private WebDriver driver=null;
	private static final Logger logger = LogManager.getLogger(Steps.class
			.getName());
	private SettingsPage settingsPage;
	private StartPage startPage;
	private MessagePage messagePage;
	private InboxPage inboxPage;
	private ThemePage themePage;
	
	
	public void initBrowser() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Browser started");
		settingsPage = new SettingsPage(driver);
		startPage = new StartPage(driver);
		messagePage = new MessagePage(driver);
		inboxPage = new InboxPage(driver);
		themePage = new ThemePage(driver);
	}
	
	public void closeDriver()
	{
		driver.quit();
	}
	

	public void signIn(String username, String password) {
		startPage.openPage();
		startPage.signIn(username, password);	
	}	
	
	public boolean signOut() {		
		inboxPage.signOut();
		return true;
	}

	public void sendMsg(String user, String msg) {	
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.createNewMsg(user, msg);
		logger.info("Send msg is Ok");
	}
	
	public void sendMsgWithAttach(String user, String msg, String pathToAtt) {
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.createNewMsgWithAttach(user, msg, pathToAtt);
		
	}
	
	public void markLetterAsSpam(String user){
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.goToLetter(user);
		messagePage.markLetterAsSpam();
	}

	public boolean checkSpamFrom(String user1) {
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.goToSpamFolder();
		return inboxPage.isEmailPresent(user1);
	}
	
	public boolean checkTrashFrom(String user1) {
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.goToTrashFolder();
		return inboxPage.isEmailPresent(user1);		
	}
	
	public boolean checkLetterInboxFrom(String user1) {
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.goToInboxFolder();
		return inboxPage.isEmailPresent(user1);
	}

	public void clickBtnSettings() {
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.clickBtnSettings();
		
	}

	public void chooseSettingsInSettings() {
		inboxPage.chooseInSettingsItemSettings();	
	}
	
	public void chooseThemesInSettings() {
		inboxPage.chooseInSettingsItemThemes();		
	}

	public void chooseForwardTab() {
		settingsPage.chooseForwardTab();
		
	}

	public void setForwardTo(String user) {
		settingsPage.setForwardTo(user);
	}

	public void acceptForwardAndSignOut(String user, String password) {
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.goToLetter("forwarding-noreply@google.com");
		String confirmationCode = messagePage.getThemeOfMsg().substring(2, 11);
		logger.info("confirmation code:"+confirmationCode);
		signOut();
		signIn(user, password);
		inboxPage.clickBtnSettings();
		inboxPage.chooseInSettingsItemSettings();
		settingsPage.chooseForwardTab();
		settingsPage.enterConfirmCode(confirmationCode);
		signOut();
	}

	public void choosePropertyForwardCopy() {
		settingsPage.chooseForwardCopy();
		
	}

	public void chooseFiltersTab() {
		settingsPage.chooseFilterTab();		
	}

	public void createFilter(String user) {
		settingsPage.createFilter (user);
	}

	public boolean checkLetterIsImportant(String user) {
		return messagePage.checkImportant();
	}

	public boolean checkLetterHasAtt(String user) {
		return messagePage.hasAtt();
	}

	public void goToMsg(String user) {
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.goToLetter(user);		
	}

	public boolean isMsgPresent(String Msg) {
		return inboxPage.isElementPresent(By.xpath("//span[contains(text(),Msg)]"));
	}

	public void selectMyPhoto(String pathToNotPhoto) {
		themePage.clickToMyPhotos();
		themePage.gotoUploadPhoto();
		themePage.clickToSelectPhoto();
	}











	
}
