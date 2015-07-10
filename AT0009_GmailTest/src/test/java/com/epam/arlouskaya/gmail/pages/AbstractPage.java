package com.epam.arlouskaya.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

public abstract class AbstractPage {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public Boolean isElementPresent(By locator) {
		return this.driver.findElements(locator).size() > 0;
	}

	public ExpectedCondition<WebElement> visibilityOfElement(final By locator) {
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver dr) {
				return dr.findElement(locator);
			}
		};
	}
	
	
}
