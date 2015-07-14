package com.epam.arlouskaya.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePage extends AbstractPage {
	private static final Logger logger = LogManager.getLogger(InboxPage.class
			.getName());

	@FindBy(xpath = "//div[@aria-label='More']")
	WebElement btnMore;
	
	@FindBy(xpath = "//div[text()='Report spam']")
	WebElement btnSpamReport;
	
	@FindBy(className ="a3s")
	WebElement textEmail;
	
	@FindBy(xpath ="//h2[@class='hP']")
	WebElement themeEmail;


	public MessagePage(WebDriver driver) {
		super(driver);
	}

	public void markLetterAsSpam() {
		btnMore.click();
		btnSpamReport.click();				
	}
	
	public String getMsg(){
		return textEmail.getText();
	}
	
	public String getThemeOfMsg(){
		return themeEmail.getText();
	}
	
	

}
