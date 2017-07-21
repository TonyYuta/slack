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
import org.sqa.slack.data.Helper;
import org.sqa.slack.data.ReadFileData;
import org.sqa.slack.pages.CommonPage;
import org.sqa.slack.pages.MessagesGeneralPanel;
import org.sqa.slack.pages.SignInPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * MessagesTest tests for messaging
 */

public class MessagesTest extends Helper {
	
	private WebDriver driver;
	
	//softAssert functionality for verifying internal test components in a bigger test
	protected SoftAssert softAssert = new SoftAssert();
	
	// creating instance of class CommonPage
	CommonPage commonPage;

	// creating instance of class MessagesGeneralPanel
	MessagesGeneralPanel messagesGeneralPanel;
	
	// creating instance of class Helper
	Helper helper;
	
	// creating instance of class ReadFileData
	ReadFileData readFileData;
	
	// creating instance of class ReadFileData
	ReadFileData rfd;

	/**
	 * instances creating
	 */
	@BeforeMethod
	public void createInstanceOfFirefox() {
		rfd = new ReadFileData();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		commonPage = PageFactory.initElements(driver, CommonPage.class);	
		messagesGeneralPanel = PageFactory.initElements(driver, MessagesGeneralPanel.class);		
		helper = new Helper();
		readFileData = new ReadFileData();
	}

	/**
	 * quit a driver 
	 */
	@AfterMethod
	public void quitInsanceOfFirefox() {
		driver.quit();
	}	
	
	/**
	 * A FUNCTIONAL TEST FOR STARRING A MESSAGE
	 */
	@Test(enabled = true, groups = {"messages", "regression"})
	public void starringMessageTest() {
		
		commonPage.navigateToCommonPage();
				
				
		// ================== Sign In as Owner into Slack and navigate to sf channel ===============				

		SignInPage signInPage = commonPage.clickSignInBtn();
		signInPage = signInPage.signInToAnotherTeamWithValidTeamDomain(readFileData.getTeamDomainOwner());	
		
		MessagesGeneralPanel messagesGeneralPanel = signInPage.signInWithValidEmailAndPassword(rfd.getEmailOwner(), rfd.getPwdOwner());
				
		messagesGeneralPanel.openChannel("sf");

				
		// ================== send a generate a message into sf channel ===============
		// generate a message and send it
		String generatedMessage = helper.getMessage();
		messagesGeneralPanel.sendMessage(generatedMessage);
		
		// ================== click on star for the last Message in sf channel ===============
		messagesGeneralPanel.markStarLastMessage();

		// ================== star message in sf channel present in "Show Starred items" section ===============
		boolean actualResult = messagesGeneralPanel.verifyMessageMarkedAsStarred(generatedMessage);

		softAssert.assertTrue(actualResult, "Message is not marked as Starred");
		
		// ================== search for has:star messages in sf channel ===============
		boolean searchHasStarResult = messagesGeneralPanel.verifyMessagePresentInSearchByStar(generatedMessage);
						
		softAssert.assertTrue(searchHasStarResult,"The message was not found in search by has:star");		

		//summarizing the results of the inner softAssert assertions
		softAssert.assertAll();

	}
	
	
} // class MessagesTest