/**
 *   File Name: HomePageTest.java<br>
 *
 *   Yutaka<br>
 *   Created: Mar 4, 2016
 *   
 */

package org.sqa.slack.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.sqa.slack.data.ReadFileData;
import org.sqa.slack.pages.CommonPage;
import org.sqa.slack.pages.MessagesGeneralPanel;
import org.sqa.slack.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * SignIn Tests for 
 */

public class SignInTest {
	private WebDriver driver;
	ReadFileData readFileData;
	
	// creating instance of class CommonPage
	CommonPage commonPage;	

	/**
	 * instances creating
	 */
	@BeforeMethod
	public void createInstanceOfFirefox() {
		readFileData = new ReadFileData();	
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		commonPage = PageFactory.initElements(driver, CommonPage.class);		
	}

	/**
	 * quit a driver
	 */
	@AfterMethod
	public void quitInsanceOfFirefox() {
		driver.quit();
	}

	/**
	 * Sign In Owner With Valid Credentials
	 */
	@Test(enabled = true, groups = {"smoke", "signin"})
	public void signInOwnerWithValidCredentials() {
		
		// expected result: Messages General Page title
		String expected = "general | "+ readFileData.getTeamNameOwner() + " Slack";
		
		// navigate to "Common" page
		commonPage.navigateToCommonPage();
		

		// click on "Sign in" button
		SignInPage signInPage = commonPage.clickSignInBtn();
		
		signInPage = signInPage.signInToAnotherTeamWithValidTeamDomain(readFileData.getTeamDomainOwner());	
		
		MessagesGeneralPanel messagesGeneralPanel = signInPage.signInWithValidEmailAndPassword(readFileData.getEmailOwner(), readFileData.getPwdOwner());
		
		// assertion Product Page title
		Assert.assertEquals(expected, driver.getTitle(), "Title doesn't match a Product page title");
	}
	
	/**
	 * Sign In Coworker With Valid Credentials
	 */
	@Test(enabled = true, groups = {"smoke", "signin"})
	public void signInCoworkerWithValidCredentials() {
		
		// expected result: Messages General Page title
		String expected = "general | "+ readFileData.getTeamNameOwner() + " Slack";
		
		// navigate to "Common" page
		commonPage.navigateToCommonPage();
		

		// click on "Sign in" button
		SignInPage signInPage = commonPage.clickSignInBtn();
		
		signInPage = signInPage.signInToAnotherTeamWithValidTeamDomain(readFileData.getTeamDomainOwner());	
		
		MessagesGeneralPanel messagesGeneralPanel = signInPage.signInWithValidEmailAndPassword(readFileData.getEmailCoworker(), readFileData.getPwdCoworker());
		
		// assertion Product Page title
		Assert.assertEquals(expected, driver.getTitle(), "Title doesn't match a Product page title");
	}
	
	/**
	 * Sign In User With Valid Credentials
	 */
	@Test(enabled = true, groups = {"smoke", "signin"})
	public void signInUserWithValidCredentials() {
		
		// expected result: Messages General Page title
		String expected = "general | "+ readFileData.getTeamNameOwner() + " Slack";
		
		// navigate to "Common" page
		commonPage.navigateToCommonPage();
		

		// click on "Sign in" button
		SignInPage signInPage = commonPage.clickSignInBtn();
		
		signInPage = signInPage.signInToAnotherTeamWithValidTeamDomain(readFileData.getTeamDomainOwner());	
		
		MessagesGeneralPanel messagesGeneralPanel = signInPage.signInWithValidEmailAndPassword(readFileData.getEmailUser(), readFileData.getPwdUser());
		
		// assertion Product Page title
		Assert.assertEquals(expected, driver.getTitle(), "Title doesn't match a Product page title");
	}
	
} // class SignInTest