package com.epam.arlouskaya.gmail.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Factory;

public class SettingsPage extends AbstractPage{
	
	
	@FindBy(xpath = "//a[contains(@href,'fwdandpop')]")
	private WebElement btnForwardTab;
	
	@FindBy(xpath = "//a[contains(@href,'filters')]")
	private WebElement btnFilterTab;
	
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
	
	@FindBy(xpath = "//span[text()='Create a new filter']")
	private WebElement createNewFilter;
	
	@FindBy(xpath = "//input[@class = 'ZH nr aQa']")
	private WebElement filterFrom;
	
	@FindBy(xpath = "//span[@class='w-Pv ZG']/input")
	private WebElement chbxHasAttachment;
	
	@FindBy(xpath = "//div[@class='nH lZ'][6]/input")
	private WebElement chbxDeleteIt;
	
	@FindBy(xpath = "//div[@class='nH lZ'][8]/input")
	private WebElement chbxAlwaysMark;
	
	@FindBy(xpath = "//div[@class='acM']")
	private WebElement btnCreateFilterNext;
	
	@FindBy(xpath = "//div[@class='T-I J-J5-Ji Zx acL T-I-atl L3']")
	private WebElement btnCreateFilterFinish;

	public SettingsPage(WebDriver driver) {
		super(driver);
	}

	public void chooseForwardTab() {
		btnForwardTab.click();		
	}
	
	public void chooseFilterTab() {
		btnFilterTab.click();		
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

	public void createFilter(String user) {
		createNewFilter.click();
		filterFrom.sendKeys(user);
		chbxHasAttachment.click();
		btnCreateFilterNext.click();
		chbxDeleteIt.click();
		chbxAlwaysMark.click();
		btnCreateFilterFinish.click();

	}

}
