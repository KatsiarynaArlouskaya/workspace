package com.epam.arlouskaya.gmail.pages;

import java.util.concurrent.TimeUnit;

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
	private final static String DOMAIN = "@gmail.com";
	
	
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
	WebElement btnCompose;
	
	@FindBy(xpath = "//textarea[@name='to']")
	WebElement inputTo;
	@FindBy(xpath = "//input[@placeholder='Subject']")
	WebElement inputSubject;
	
	@FindBy(xpath = "//div[@role='textbox']")
	WebElement inputMsg;
	
	@FindBy(xpath = "//div[contains(@aria-label,'(Ctrl-Enter)‬')]")
	WebElement btnSend;
	
	@FindBy(xpath = "//a[contains(@title,'Google Account')]")
	WebElement btnAccount;
	
	@FindBy(linkText = "Sign out")
	WebElement btnSignOut;
	
	@FindBy(xpath = "//span[text()='More']")
	WebElement btnmMoreInLeftMenu;
	
	@FindBy(linkText = "Spam")
	WebElement btnmSpam;
	

	public InboxPage(WebDriver driver) {
		super(driver);
	}
	
	public void createNewMsg(String receiver, String msg){
		btnCompose.click();
		inputTo.sendKeys(receiver+DOMAIN);
		inputSubject.sendKeys(msg);
		inputMsg.sendKeys(msg);
		btnSend.click();
		//WebElement msgWasSend = (new WebDriverWait(driver, 10)).until(visibilityOfElement(By.xpath("//div[text()='Your message has been sent. ']")));
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
		driver.findElement(By.xpath("//span[@email='"+user+"@gmail.com']")).click();
	}
	
	public void goToSpamFolder() {
		btnmMoreInLeftMenu.click();
		btnmSpam.click();		
	}
	
	public boolean isEmailPresent(String user) {
		return isElementPresent(By.xpath("//span[@email='"+user+"@gmail.com']"));
	}

}
