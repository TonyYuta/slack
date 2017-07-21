/**
 *   File Name: DomainSignInPage.java<br>
 *
 *   Yutaka<br>
 *   Created: Mar 4, 2016
 *   
 */

package org.sqa.slack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Sign In users page 
 */
public class SignInPage extends CommonPage{
	
	// Sign In Page methods using Page factory
	@FindBy(css = ".card.align_center.span_4_of_6.col.float_none.margin_auto.large_bottom_margin.no_left_padding.no_right_padding.large_bottom_padding>h1")
	private WebElement signInToAnotherTeamLabel;
	
	@FindBy(css = "(.col.span_4_of_6.float_none.margin_auto.no_right_padding>p)[1]")
	private WebElement EnterYourDomainLabel;
	
	@FindBy(id = "domain")
	private WebElement teamDomainField;
	
	@FindBy(id = "submit_team_domain")
	private WebElement continueBtn;
	
	@FindBy(css = "(.large_bottom_margin)[3]")
	private WebElement DontRememberDomainLabel;
	
	@FindBy(css = "(.bold)[1]")
	private WebElement findYourTeamLink;
	
	@FindBy(css = "(.bold)[2]")
	private WebElement signUpOnTheHomePageLink;
	
	@FindBy(css = "#signin_header")
	private WebElement signinHeader;
	
	@FindBy(css = "(#signin_form>p)[1]")
	private WebElement enterEmailAndPasswordLabel;
	
	@FindBy(id = "email")
	private WebElement emailField;;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(id = "signin_btn")
	private WebElement signInBtn;
	
	@FindBy(css = ".checkbox>input")
	private WebElement  keepMeSignedInCheckBox;
	
	@FindBy(id = "forgot-pw")
	private WebElement iForgotMyPasswordLink;
	
	private WebDriver driver;
	
	/**
	 * @return url
	 */
	public SignInPage navigateToSignInPage(){
		driver.get(readFileData.getSignInPageUrl());	
		return this;
	}
	
	/**
	 * @param teamDomain
	 * @return WebElements for SignInPage
	 */
	public SignInPage signInToAnotherTeamWithValidTeamDomain(String teamDomain) {
		teamDomainField.clear();
		teamDomainField.sendKeys(teamDomain);
		continueBtn.click();
		return PageFactory.initElements(driver, SignInPage.class);		
	}
	
	/**
	 * @param driver
	 */
	public SignInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * @return url
	 */
	public SignInPage navigateToSignInUserPage(){
		driver.get(readFileData.getSignInUserPageUrl());	
		return this;
	}
	
	/**
	 * @param email
	 * @param password
	 * @return WebElements for MessagesGeneralPanel
	 */
	public MessagesGeneralPanel signInWithValidEmailAndPassword(String email, String password) {		
		emailField.clear();
		emailField.sendKeys(email);
		passwordField.clear();
		passwordField.sendKeys(password);
		keepMeSignedInCheckBox.click();
		signInBtn.click();
		return PageFactory.initElements(driver, MessagesGeneralPanel.class);		
	}

} // class SignInPage