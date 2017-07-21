/**
 *   File Name: ProductPage.java<br>
 *
 *   Yutaka<br>
 *   Created: Apr 18, 2016
 *   
 */

package org.sqa.slack.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 *  Panel for messages
 *
 */
public class MessagesGeneralPanel extends CommonPage {
	
	// Messages General Page methods using Page factory
	
	@FindBy(css = "#message-input")
	private WebElement messageBox;
	
	@FindBy(id = "team_name")
	private WebElement teamNameLabel;
	
	@FindBy(css = ".notifications_menu_btn.ts_icon.ts_icon_bell_o.ts_tip.ts_tip_bottom.ts_tip_float.btn_unstyle")
	private WebElement notificationsBtn;
	
	@FindBy(css = ".ts_icon.ts_icon_chevron_down.team_name_caret.btn_unstyle")
	private WebElement downTeamNameCaretInfoBtn;
	
	@FindBy(css = ".current_user_name.slack_menu_header_primary.overflow_ellipsis")
	private WebElement currentUserNameInfoLabel;
	
	@FindBy(css = ".current_name.slack_menu_header_secondary.overflow_ellipsis")
	private WebElement currentNameSlackMenuLabel;
	
	@FindBy(css = "#member_account_item>a")
	private WebElement profileAndAccountItem;
	
	@FindBy(css = "#member_prefs_item>a")
	private WebElement preferencesItem;
	
	@FindBy(css = "#member_presence>a")
	private WebElement serYourselfToAwayItem;
	
	@FindBy(css = "#team_help>a")
	private WebElement helpAndFeedbackItem;
	
	@FindBy(css = "(.slack_menu_header_primary.overflow_ellipsis)[2]")
	private WebElement teamNameBelowLabel;
	
	@FindBy(css = ".current_team_name.slack_menu_header_secondary.overflow_ellipsis")
	private WebElement currentTeamNameSlackLabel;
	
	@FindBy(id = "team_invitations")
	private WebElement invitePeopleItem;
	
	@FindBy(id = "manage_team")
	private WebElement manageTeamItem;
	
	@FindBy(id = "team_settings")
	private WebElement manageTeamMembersItem;
	
	@FindBy(id = "team_settings")
	private WebElement teamSettingsItem;
	
	@FindBy(id = "team_services")
	private WebElement appsAndIntegrationsItem;
	
	@FindBy(id = "team_customize")
	private WebElement customizeSlackItem;
	
	@FindBy(id = "team_statistics")
	private WebElement statisticsItem;
	
	@FindBy(id = "team_billing")
	private WebElement billingItem;
	
	@FindBy(css = "logout")
	private WebElement signOutItem;
	
	@FindBy(id = "add_team")
	private WebElement signInToAnotherTeamItem;
	
	@FindBy(id = "team_apps")
	private WebElement downloadTheSlackAppItem;
	
	@FindBy(css = ".channel_list_header_label.btn_unstyle")
	private WebElement channelsBtn;
	
	@FindBy(css = ".channel_C1X9VR607.channel")
	private WebElement channel01Top;
	
	@FindBy(css = ".channel_C1X9VR63H.channel")
	private WebElement channel02FromTop;
	
	@FindBys(@FindBy(css = "#channel-list .channel_name .overflow_ellipsis"))
	private List <WebElement> channelName;
	
	@FindBys(@FindBy(css = "#channel-list .channel_name"))
	private List <WebElement> channelBtn;
	
	@FindBy(id = "direct_messages_header")
	private WebElement directMessagesBtn;
	
	@FindBy(css = ".member_USLACKBOT.member.cursor_pointer")
	private WebElement slackbotBtn;
	
	@FindBy(css = ".member_U1X888BEX.member.cursor_pointer")
	private WebElement memberYouBtn;
	
	@FindBy(css = ".member_U1Y2KHEB1.member.away.cursor_pointer")
	private WebElement memberAwayBtn;
	
	@FindBy(css = "channel_list_invites_link")
	private WebElement invitePeopleBtn;
	
	@FindBy(id = "channel_title") 
	private WebElement channelTitle;
	
	@FindBy(css = "(.message_sender.member.member_preview_link.color_U1X888BEX.color_9f69e7)[5]") 
	private WebElement messageSender;	
	
	@FindBy(css = "(.timestamp.ts_tip.ts_tip_top.ts_tip_float.ts_tip_hidden.ts_tip_multiline.ts_tip_delay_300)[5]")
	private WebElement timestamp;

	@FindBys(@FindBy(css = "#msgs_div button.star"))
	private List<WebElement> starBtnList;
	
	@FindBys(@FindBy(xpath = "//div[3]/span[1]/button/span"))
	private List<WebElement> starBtnAttrList;
	
	@FindBy(id = "search_terms")
	private WebElement searchField;
	
	@FindBy(id = "search_heading")
	private WebElement SearchResultsLabel;
	
	@FindBys(@FindBy(css = ".search_result_with_extract .message_content .message_body"))				
	private List<WebElement> searchResultMessageFieldList;
	
	@FindBy(css = ".ts_icon.ts_icon_times")
	private WebElement closeSearchResultsBtn;
	
	@FindBy(id = "stars_toggle")
	private WebElement showStarredItemsBtn;
	
	@FindBys(@FindBy(css = ".star_item .message_content  .message_body"))				
	private List<WebElement> starFilteringMessageFieldList;
	
	@FindBys(@FindBy(css = "#msgs_div .message_body"))
	private List<WebElement> sentMessageFieldList;
	
	private WebDriver driver;

	/**
	 * @param driver
	 */
	public MessagesGeneralPanel(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * @return url
	 */
	public MessagesGeneralPanel navigateToMessagesGeneralPage(){
		driver.get(readFileData.getMessagesGeneralPageUrl());	
		return this;
	}
	
	/**
	 * @param aChannelName
	 */
	public void openChannel(String aChannelName) {
		for (int i = 0; i < channelName.size(); i++) {			
			if (channelName.get(i).getText().equals(aChannelName)) {
				channelBtn.get(i).click();
			}
		}	
	}
	
	/**
	 * @param message
	 */
	public void sendMessage(String message) {
		messageBox.clear();
		messageBox.sendKeys(message);
		messageBox.sendKeys(Keys.RETURN);
	}
	
	/**
	 * @return last Message
	 */
	public String retrieveLastMessage() {
		String lastMessage = sentMessageFieldList.get(sentMessageFieldList.size() - 1).getText();
		return lastMessage;
	}
	
	/**
	 * @param message
	 */
	public void waitForMessageToAppearOnScreen(String message){
		wait.until(ExpectedConditions.textToBePresentInElement(sentMessageFieldList.get(sentMessageFieldList.size() - 1), message));
	}
	
	/**
	 * @return webelement attribute
	 */
	public String markStarLastMessage() {
		waitForAjaxToComplete(5);
		starBtnList.get(starBtnList.size()-1).click();
		return starBtnAttrList.get(starBtnAttrList.size()-1).getAttribute("data-tip-toggle-auto"); // must be "Unstar this message"
	}
	
	/**
	 * @param starMessage
	 * @return boolean result
	 */
	public boolean verifyMessagePresentInSearchByStar(String starMessage) {
		String hasStar = "has:star";
		boolean starMessageFound = false;
		
		/*
			* There is a bug in the application:
			* after marking a message with a star it takes up to 35 seconds to get reflected in search
			* when filtering by "has:star"
			* using implicit wait in this case. 
			* In real automation test case, a bug would be filed and this case would fail until the bug is fixed
		*/
		try {Thread.sleep(35000);} catch (InterruptedException e) {}
		
		searchField.clear();
		searchField.sendKeys(hasStar);
		searchField.sendKeys(Keys.RETURN);
				
		// verify each message from the List in search section
		for (int i = 0; i < searchResultMessageFieldList.size(); i++) {
			if (searchResultMessageFieldList.get(i).getText().equals(starMessage)) {
				starMessageFound = true;
			}			
		}
		
		return starMessageFound;		
	}
	
	/**
	 * @param starMessage
	 * @return true/false if starred message is present
	 */
	public boolean verifyMessageMarkedAsStarred(String starMessage) {
		boolean starredMessagePresent = false;
		showStarredItemsBtn.click();
		// verify each message from the List in Show Starred Items section
		for (int i = 0; i < starFilteringMessageFieldList.size(); i++) {
			String temp1 = starFilteringMessageFieldList.get(i).getText();
			if (starFilteringMessageFieldList.get(i).getText().equals(starMessage)) {
				starredMessagePresent = true;
			}
		}
		
		return starredMessagePresent;		
	}

} // class MessagesGeneralPanel