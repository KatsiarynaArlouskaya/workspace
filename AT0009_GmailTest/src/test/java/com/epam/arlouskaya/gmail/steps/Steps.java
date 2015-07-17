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

	//-----------------------------------
	// init and close driver
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

	//-----------------------------------
	//sign in and sign out

	public void signIn(String username, String password) {
		startPage.openPage();
		startPage.signIn(username, password);	
	}	
	
	public void signOut() {		
		startPage.signOut();
	}

	//-----------------------------------
	//send message with different content
	
	public void sendMsg(String user, String msg) {	
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.createNewMsg(user, msg);
		inboxPage.sendMsg();
	}
	
	public void sendMsgWithAttach(String user, String msg, String pathToAtt) {
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.createNewMsg(user, msg);
		inboxPage.addAttach(pathToAtt);
		inboxPage.sendMsg();
		
	}
	public boolean sendMsgWithEmotIcons(String user, String msg, int numberOfIcons) {
		inboxPage.createNewMsg(user, msg);
		inboxPage.addEmotIcons(numberOfIcons);
		Boolean checkIconsInLetter = inboxPage.checkNumberIcon(numberOfIcons);
		inboxPage.sendMsg();
		return checkIconsInLetter;
	}

	
	//-----------------------------------
	//check, is e-mail present in different folders
	
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
	
	public boolean checkInboxFrom(String user1) {
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.goToInboxFolder();
		return inboxPage.isEmailPresent(user1);
	}
	
	//-----------------------------------
	//actions with the letter
	
	public void goToLetter(String user) {
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.goToLetter(user);		
	}
	
	public void markLetterAsSpam(String user){
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.goToLetter(user);
		messagePage.markLetterAsSpam();
	}

	
	//-----------------------------------
	//check content of the letter
	
	public boolean checkLetterIsImportant(String user) {
		return messagePage.checkImportant();
	}

	public boolean checkLetterHasAtt(String user) {
		return messagePage.hasAtt();
	}
	
	public boolean checkLetterTextEmotIcon(int numberIcons) {
		return messagePage.checkNumberIcon(numberIcons);
	}
	

	//-----------------------------------
	//settings
	
	public void clickBtnSettings() {
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.clickBtnSettings();		
	}
	
	//settings-settings
	public void chooseSettingsInSettings() {
		inboxPage.chooseInSettingsItemSettings();	
	}

	public void chooseForwardTab() {
		settingsPage.chooseForwardTab();		
	}

	public void setForwardTo(String user) {
		settingsPage.setForwardTo(user);
	}

	public void acceptForwardAndSignOut(String user, String password) {
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

	//settings-themes
	public void chooseThemesInSettings() {
		inboxPage.chooseInSettingsItemThemes();		
	}
	
	public void chooseTheme(String urlPictTheme) {
		themePage.chooseTheme(urlPictTheme);
	}
	
	public boolean checkTheme(String urlPict) {
		return themePage.checkTheme(urlPict);
	}
	
	public void selectMyPhoto(String pathToNotPhoto) {
		themePage.clickToMyPhotos();
		themePage.gotoUploadPhoto();
		themePage.clickToSelectPhoto();
		themePage.uploadPhoto(pathToNotPhoto);
	}
	
	//-----------------------------------
	//another
	
	public boolean isMsgPresent(String Msg) {
		return inboxPage.isElementPresent(By.xpath("//*[contains(text(),Msg)]"));
	}





	
}
