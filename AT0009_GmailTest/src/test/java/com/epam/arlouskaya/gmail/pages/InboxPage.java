package com.epam.arlouskaya.gmail.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage extends AbstractPage{
	private static final Logger logger = LogManager.getLogger(InboxPage.class.getName());
	
	
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
	WebElement btnCompose;
	
	@FindBy(xpath = "//textarea[@name='to']")
	WebElement inputTo;
	@FindBy(xpath = "//input[@placeholder='Subject']")
	WebElement inputSubject;
	
	@FindBy(xpath = "//div[@role='textbox']")
	WebElement inputMsg;
	
	@FindBy(xpath = "//div[@aria-label='Attach files']")
	WebElement btnAttach;
	
	@FindBy(xpath = "//div[contains(@aria-label,'(Ctrl-Enter)‬')]")
	WebElement btnSend;
	
	@FindBy(xpath = "//a[contains(@title,'Google Account')]")
	WebElement btnAccount;
	
	@FindBy(linkText = "Sign out")
	WebElement btnSignOut;
	
	@FindBy(xpath = "//span[text()='More']")
	WebElement btnMoreInLeftMenu;
	
	@FindBy(linkText = "Spam")
	WebElement btnSpam;
	
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji ash T-I-ax7 L3']")
	WebElement btnSettings;
	
	@FindBy(xpath = "//div[text()='Settings']")
	WebElement btnSettingsInSettings;
	

	public InboxPage(WebDriver driver) {
		super(driver);
	}
	
	public void createNewMsg(String receiver, String msg){
		btnCompose.click();
		inputTo.sendKeys(receiver);
		inputSubject.sendKeys(msg);
		inputMsg.sendKeys(msg);
		btnSend.click();
	}
	
	public void createNewMsgWithAttach(String receiver, String msg, String pathToAtt) {
		btnCompose.click();
		inputTo.sendKeys(receiver);
		inputSubject.sendKeys(msg);
		inputMsg.sendKeys(msg);
		btnAttach.click();
		 //put path to your image in a clipboard
	    StringSelection ss = new StringSelection(pathToAtt);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	  //imitate mouse events like ENTER, CTRL+C, CTRL+V
		try {
			Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.delay(3000);
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnSend.click();
	}
	
	
	public void signOut(){	
		/*btnAccount.click();
		btnSignOut.click();*/
		try {
			driver.manage().deleteAllCookies();
			logger.info("Cookies have been removed");
		} catch (org.openqa.selenium.UnhandledAlertException e) {
			logger.info("Allert was accept. Allert:" + driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		}
		if (ExpectedConditions.alertIsPresent().apply(driver) != null){
			logger.info("Allert was accept. Allert:" + driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			}
	}

	public void goToLetter(String user) {
		driver.findElement(By.xpath("//span[@email='"+user+"']")).click();
	}
	
	public void goToSpamFolder() {
		btnMoreInLeftMenu.click();
		btnSpam.click();		
	}
	
	public boolean isEmailPresent(String user) {
		return isElementPresent(By.xpath("//span[@email='"+user+"']"));
	}

	public void clickBtnSettings() {
		btnSettings.click();		
	}
	
	public void chooseInSettingsItemSettings() {
		btnSettingsInSettings.click();		
	}





}
