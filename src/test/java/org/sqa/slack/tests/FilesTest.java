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
import org.sqa.slack.pages.FilesGeneralPanel;
import org.sqa.slack.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * file visibility testing
 */

public class FilesTest extends Helper {
	
	private WebDriver driver;
	
	CommonPage commonPage;

	FilesGeneralPanel filesGeneralPanel;
	
	Helper helper;
	
	ReadFileData readFileData;

	/**
	 * instances creating
	 */
	@BeforeMethod
	public void createInstanceOfFirefox() {
		readFileData = new ReadFileData();	
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		commonPage = PageFactory.initElements(driver, CommonPage.class);	
		filesGeneralPanel = PageFactory.initElements(driver, FilesGeneralPanel.class);		
		helper = new Helper();
		readFileData = new ReadFileData();
	}

	/**
	 * quit driver
	 */
	@AfterMethod
	public void quitInsanceOfFirefox() {
		driver.quit();
	}
	
	/**
	 * File shared into a Channel visible to Creator
	 * A file shared into a public channel should be visible for the creator in that channel
	 * The file shared file by Owner in channel "sf"
	 */
	@Test(enabled = true, groups = {"files", "regression"})
	public void fileOfChannelVisibleToCreator() {
		
		boolean actualResult;
		
		// file owner: Owner
		// shared in channel "sf"
		String fileName1 = "futura01.jpg";
		
		commonPage.navigateToCommonPage();
		
		SignInPage signInPage = commonPage.clickSignInBtn();
		
		// sign in as Owner
		signInPage = signInPage.signInToAnotherTeamWithValidTeamDomain(readFileData.getTeamDomainOwner());				
		signInPage.signInWithValidEmailAndPassword(readFileData.getEmailOwner(), readFileData.getPwdOwner());
		
		// navigate to files page and "sf" channel
		filesGeneralPanel.navigateToChannelFiles("sf");

		// search file shared by Owner in channel "sf" 
		actualResult = filesGeneralPanel.searchSharedFile(fileName1);
					
		// assertion Owner can see shared file in channel "sf"
		Assert.assertTrue(actualResult, "Shared file was not found.");
	}
	
	/**
	 * Shared File Test
	 * search shared file in channel "sf" for Coworker
	 */
	@Test(enabled = true, groups = {"files", "regression"})
	public void searchSharedFileCoworkerTest() {
		
		boolean actualResult;
		
		// file owner: Owner
		// shared in channel "sf"
		String fileName1 = "futura01.jpg";
		
		commonPage.navigateToCommonPage();
				
		SignInPage signInPage = commonPage.clickSignInBtn();
		
		// sign in as Coworker
		signInPage = signInPage.signInToAnotherTeamWithValidTeamDomain(readFileData.getTeamDomainOwner());				
		signInPage.signInWithValidEmailAndPassword(readFileData.getEmailCoworker(), readFileData.getPwdCoworker());
		
		// navigate to files page and "sf" channel
		filesGeneralPanel.navigateToChannelFiles("sf");

		// search file shared by Owner in channel "sf" 
		actualResult = filesGeneralPanel.searchSharedFile(fileName1);
					
		// assertion Coworker can see shared file in channel "sf"
		Assert.assertTrue(actualResult, "Shared file was not found.");
	}
	
	/**
	 * Shared File Test
	 * search shared file by User in channel "sf" for User
	 */
	@Test(enabled = true, groups = {"files", "regression"})
	public void searchSharedFileUserTest() throws InterruptedException {
		boolean actualResult;
		
		// file owner: Owner
		// shared in channel "sf"
		String fileName1 = "futura01.jpg";
		
		commonPage.navigateToCommonPage();
				
		SignInPage signInPage = commonPage.clickSignInBtn();
		
		// sign in as User
		signInPage = signInPage.signInToAnotherTeamWithValidTeamDomain(readFileData.getTeamDomainOwner());				
		signInPage.signInWithValidEmailAndPassword(readFileData.getEmailUser(), readFileData.getPwdUser());
		
		// navigate to files page for "sf" channel
		filesGeneralPanel.navigateToChannelFiles("sf");

		// search file shared by Owner in channel "sf" 
		actualResult = filesGeneralPanel.searchSharedFile(fileName1);
					
		// assertion user can see shared file in channel "sf"
		Assert.assertTrue(actualResult, "Shared file was not found.");
	}
	
} // class FilesTest