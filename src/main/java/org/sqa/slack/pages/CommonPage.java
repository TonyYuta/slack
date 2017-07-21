/**
 *   File Name: HomePage.java<br>
 *
 *   Yutaka<br>
 *   Created: Mar 4, 2016
 *   
 */

package org.sqa.slack.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sqa.slack.data.ReadFileData;

/**
 * Common methods 
 */
public class CommonPage {
	
	// Home Page methods using Page factory
	
	@FindBy(css = ".logo")
	private WebElement logoBtn;
	
	@FindBy(xpath = "(//nav[1]/ul/li[1]/a)[1]")
	private WebElement productBtn;
	
	@FindBy(css = "(.top.no_sticky>ul>li>a)[2]")
	private WebElement pricingBtn;
	
	@FindBy(css = "(.top.no_sticky>ul>li>a)[3]")
	private WebElement supportBtn;
	
	@FindBy(css = "(.top.no_sticky>ul>li>a)[4]")
	private WebElement createANewTeamBtn;
	
	@FindBy(css = "(.top.no_sticky>ul>li>a)[5]")
	private WebElement findYourTeamBtn;
	
	@FindBy(css = ".btn_sticky.btn_filled.opt_nav_signin")
	private WebElement signInBtn;
			
	private WebDriver driver;
	
	ReadFileData readFileData;
	WebDriverWait wait;

	/**
	 * @param driver
	 */
	public CommonPage(WebDriver driver) {
		readFileData = new ReadFileData();
		wait = new WebDriverWait(driver, 10);
		this.driver = driver;
	}
	
	/**
	 * @return url
	 */
	public CommonPage navigateToCommonPage(){
		driver.get(readFileData.getCommonPageUrl());	
		return this;
	}
	
	/**
	 * click on "SignIn" button
	 * @return DomainSignInPage page object
	 */
	public SignInPage clickSignInBtn() {
		signInBtn.click();
		return PageFactory.initElements(driver, SignInPage.class);
	}
	
	/**
	 * @param timeoutInSeconds
	 */
	public void waitForAjaxToComplete(int timeoutInSeconds) {
		Boolean jQcondition = true;
		
		while (jQcondition && (timeoutInSeconds > 0)) {
			jQcondition = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); //reset implicitlyWait
			timeoutInSeconds--;
		}
	}
	
		
} // class CommonPage