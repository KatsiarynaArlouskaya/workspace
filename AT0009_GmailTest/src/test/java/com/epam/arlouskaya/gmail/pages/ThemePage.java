package com.epam.arlouskaya.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThemePage extends AbstractPage{

	@FindBy(xpath="//div[text()='My Photos']")
	WebElement btnMyPhotos;
	
	@FindBy(linkText="Upload a photo")
	WebElement tabUploadPhoto;
	
	@FindBy(className="Xf-dn-wn")
	WebElement btnSelectPhoto;

	
	public ThemePage(WebDriver driver) {
		super(driver);
	}

	public void clickToMyPhotos() {
		btnMyPhotos.click();
		waitForElementIsDisplayed(By.xpath("//div[text()='Select your background image']"));
	}
	

	public void gotoUploadPhoto() {
		tabUploadPhoto.click();		
	}

	public void clickToSelectPhoto() {
		btnSelectPhoto.click();
		
	}
}
