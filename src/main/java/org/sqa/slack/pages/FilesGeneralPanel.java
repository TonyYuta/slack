/**
 *   File Name: ProductPage.java<br>
 *
 *   Yutaka<br>
 *   Created: Apr 18, 2016
 *   
 */

package org.sqa.slack.pages;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * General Files Panel  
 */
public class FilesGeneralPanel extends CommonPage{
	
	// Messages General Page methods using Page factory
	
	@FindBy(css = "#message-input")
	protected WebElement messageBox;
	
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
	protected List <WebElement> channelName;
	
	@FindBys(@FindBy(css = "#channel-list .channel_name"))
	protected List <WebElement> channelBtn;
	
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

	@FindBys(@FindBy(css = ".message_content .star.ts_icon.ts_icon_star_o.ts_icon_inherit.star_message.ts_tip.ts_tip_top.ts_tip_float.ts_tip_hidden.btn_unstyle"))
	protected List<WebElement> starBtn;
	
	@FindBys(@FindBy(xpath = "//div[3]/span[1]/button/span"))
	protected List<WebElement> starAttrBtn;
	
	@FindBy(id = "search_terms")
	protected WebElement searchField;
	
	@FindBy(id = "search_heading")
	protected WebElement SearchResultsLabel;
	
	@FindBys(@FindBy(css = ".search_result_with_extract .message_content .message_body"))				
	protected List<WebElement> searchResultsMessages;
	
	@FindBy(css = ".ts_icon.ts_icon_times")
	private WebElement closeSearchResultsBtn;
	
	@FindBy(id = "stars_toggle")
	protected WebElement showStarredItemsBtn;
	
	@FindBys(@FindBy(css = ".star_item .message_content  .message_body"))				
	protected List<WebElement> showStarredItemsResultsMessages;
	
	@FindBy(css = ".message_body")
	public Collection<? extends WebElement> messageBody;
	
	@FindBys(@FindBy(css = ".message_body"))
	protected List<WebElement> messagesBodies;
	
	@FindBy(id = "flex_menu_toggle")
	protected WebElement moreItems;
	
	@FindBy(id = "files_all")
	protected WebElement allFiles;
	
	@FindBys(@FindBy(css = ".title.overflow_ellipsis.no_preview"))
	protected List<WebElement> visibleFiles;
	

	protected WebDriver driver;

	/**
	 * @param driver
	 */
	public FilesGeneralPanel(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/**
	 * @return url
	 */
	public FilesGeneralPanel navigateToFilesGeneralPage(){
		driver.get(readFileData.getFilesGeneralPageUrl());	
		return this;
	}
	

	/**
	 * @param aChannelName
	 */
	public void navigateToChannelFiles(String aChannelName) {
		for (int i = 0; i < channelName.size(); i++) {			
			if (channelName.get(i).getText().equals(aChannelName)) {
				channelBtn.get(i).click();
			}
		}	
		
		moreItems.click();
		allFiles.click();
	}
	
	/**
	 * @param sharedFile
	 * @return boolean result
	 */
	public boolean searchSharedFile(String sharedFile) {
		wait = new WebDriverWait(driver, 10);	
		boolean foundSharedFile = false;
		
		waitForAjaxToComplete(5);
		for (int i = 0; i < visibleFiles.size(); i++) {
			String temp = visibleFiles.get(i).getText();
			if (visibleFiles.get(i).getText().equals(sharedFile)) {
				foundSharedFile = true;
			}
		}
		return foundSharedFile;
	}

} // class FilesGeneralPanel