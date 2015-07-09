package com.epam.arlouskaya.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage extends AbstractPage{
	private final static String DOMAIN = "@gmail.com";
	
	
	@FindBy(xpath = "//div[text()='COMPOSE']")
	WebElement btnCompose;
	
	@FindBy(xpath = "//textarea[@aria-label='To']")
	WebElement inputTo;
	
	@FindBy(xpath = "//textarea[@aria-label='Message Body']")
	WebElement inputMsg;
	
	@FindBy(xpath = "//textarea[@aria-label='Send ‪(Ctrl-Enter)‬']")
	WebElement btnSend;

	@FindBy(className = "iN")
	WebElement tableIn;
	
	public InboxPage(WebDriver driver) {
		super(driver);
	}
	
	public void createNewMsg(String receiver, String msg){
		btnCompose.click();
		inputTo.sendKeys(receiver+DOMAIN);
		tableIn.click();
		inputMsg.sendKeys(msg);
		btnSend.click();
	}

}
