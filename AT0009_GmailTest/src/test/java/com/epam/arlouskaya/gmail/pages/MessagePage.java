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

	@FindBy(xpath = "//div[@data-tooltip='Report spam']")
	WebElement btnSpamReport1;
	@FindBy(xpath = "//div[@title='Report spam']")
	WebElement btnSpamReport2;
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji nN T-I-ax7 T-I-Js-Gs T-I-Js-IF ar7']")
	WebElement btnSpamReport3;

	public MessagePage(WebDriver driver) {
		super(driver);
	}

	public void markLetterAsSpam() {
		if (isElementPresent(By.xpath("//div[@data-tooltip='Report spam']"))) {
			btnSpamReport1.click();
			logger.info("xpath(//div[@data-tooltip='Report spam']");
		} else {
			
			if (isElementPresent(By
					.xpath("//div[@title='Report spam']"))) {
				btnSpamReport2.click();
				logger.info("xpath(//div[@title='Report spam']");
			} else {

				if (isElementPresent(By
						.xpath("//div[@class='T-I J-J5-Ji nN T-I-ax7 T-I-Js-Gs T-I-Js-IF ar7']"))) {
					btnSpamReport3.click();
					logger.info("xpath(//div[@class='T-I J-J5-Ji nN T-I-ax7 T-I-Js-Gs T-I-Js-IF ar7']");
				}
			}
		}

	}

}
