package com.epam.arlouskaya.gmail.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends AbstractPage{
	
	
	@FindBy(xpath = "//a[contains(@href,'fwdandpop')]")
	private WebElement btnForwardTab;
	
	@FindBy(xpath = "//input[@value='Add a forwarding address']")
	private WebElement btnSetForwardAdress;
	
	@FindBy(xpath = "//div[@class='PN']/input")
	private WebElement inputForward;
	
	@FindBy(className ="J-at1-auR")
	private WebElement btnOk;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement btnProceed;
	
	@FindBy(xpath = "//input[@act='verifyText']")
	private WebElement inputVerify;
	
	@FindBy(xpath = "//input[@act='verify']")
	private WebElement btnVerify;
	
	@FindBy(xpath = "//input[@name='sx_em' and @value='1']")
	private WebElement rbtnForwardCopy;

	public SettingsPage(WebDriver driver) {
		super(driver);
	}

	public void chooseForwardTab() {
		btnForwardTab.click();		
	}

	public  void setForwardTo(String user) {
		btnSetForwardAdress.click();
		inputForward.sendKeys(user);
		btnOk.click();
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		btnProceed.click();
		driver.switchTo().window(winHandleBefore);
		btnOk.click();	
	}
	
	public void enterConfirmCode(String confirmCode){
		inputVerify.clear();
		inputVerify.sendKeys(confirmCode);
		btnVerify.click();	
	}

	public void chooseForwardCopy() {
		rbtnForwardCopy.click();
		
	}

}
