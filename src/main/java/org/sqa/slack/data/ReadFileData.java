/**
 *   File Name: ReadFileData.java<br>
 *
 *   Yutaka<br>
 *   Created: May 7, 2016
 *   
 */

package org.sqa.slack.data;

import java.io.BufferedReader;

/**
 * ReadFileData //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 * 
 * @version     1.0.0
 * @since       1.0
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * Read Data from Files  
 *
 */
public class ReadFileData {
	private String 	commonPageUrl,
					productPageUrl,
					signInPageUrl,
					signInUserPageUrl,
					messagesGeneralPageUrl,
					filesGeneralPageUrl,
					sfChannelPageUrl,
					bayAreaLifeChannelPageUrl,
					teamNameOwner,
					teamDomainOwner,
					emailOwner,
					pwdOwner,
					teamNameCoworker,
					teamDomainCoworker,
					emailCoworker,
					pwdCoworker,
					teamNameUser,
					teamDomainUser,
					emailUser,
					pwdUser;
	
	/**
	 * @return the commonPageUrl
	 */
	public String getCommonPageUrl() {
		return commonPageUrl;
	}

	/**
	 * @return the productPageUrl
	 */
	public String getProductPageUrl() {
		return productPageUrl;
	}

	/**
	 * @return the signInPageUrl
	 */
	public String getSignInPageUrl() {
		return signInPageUrl;
	}

	/**
	 * @return the signInUserPageUrl
	 */
	public String getSignInUserPageUrl() {
		return signInUserPageUrl;
	}

	/**
	 * @return the messagesGeneralPageUrl
	 */
	public String getMessagesGeneralPageUrl() {
		return messagesGeneralPageUrl;
	}
	
	/**
	 * @return the filesGeneralPageUrl
	 */
	public String getFilesGeneralPageUrl() {
		return filesGeneralPageUrl;
	}

	/**
	 * @return the sfChannelPageUrl
	 */
	public String getSfChannelPageUrl() {
		return sfChannelPageUrl;
	}

	/**
	 * @return the bayAreaLifeChannelPageUrl
	 */
	public String getBayAreaLifeChannelPageUrl() {
		return bayAreaLifeChannelPageUrl;
	}

	/**
	 * @return the teamNameOwner
	 */
	public String getTeamNameOwner() {
		return teamNameOwner;
	}

	/**
	 * @return the teamDomainOwner
	 */
	public String getTeamDomainOwner() {
		return teamDomainOwner;
	}

	/**
	 * @return the emailOwner
	 */
	public String getEmailOwner() {
		return emailOwner;
	}

	/**
	 * @return the pwdOwner
	 */
	public String getPwdOwner() {
		return pwdOwner;
	}

	/**
	 * @return the teamNameCoworker
	 */
	public String getTeamNameCoworker() {
		return teamNameCoworker;
	}

	/**
	 * @return the teamDomainCoworker
	 */
	public String getTeamDomainCoworker() {
		return teamDomainCoworker;
	}

	/**
	 * @return the emailCoworker
	 */
	public String getEmailCoworker() {
		return emailCoworker;
	}

	/**
	 * @return the pwdCoworker
	 */
	public String getPwdCoworker() {
		return pwdCoworker;
	}

	/**
	 * @return the teamNameUser
	 */
	public String getTeamNameUser() {
		return teamNameUser;
	}

	/**
	 * @return the teamDomainUser
	 */
	public String getTeamDomainUser() {
		return teamDomainUser;
	}

	/**
	 * @return the emailUser
	 */
	public String getEmailUser() {
		return emailUser;
	}

	/**
	 * @return the pwdUser
	 */
	public String getPwdUser() {
		return pwdUser;
	}


	/**
	 * file reader
	 */
	public ReadFileData(){
		File file = new File("src/main/resources/credentails.properties");
		FileInputStream fileInput = null;
		
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		teamNameOwner = prop.getProperty("teamNameOwner");
		teamDomainOwner = prop.getProperty("teamDomainOwner");
		emailOwner = prop.getProperty("emailOwner");
		pwdOwner = prop.getProperty("pwdOwner");
		
		teamNameCoworker = prop.getProperty("teamNameCoworker");
		teamDomainCoworker = prop.getProperty("teamDomainCoworker");
		emailCoworker = prop.getProperty("emailCoworker");
		pwdCoworker = prop.getProperty("pwdCoworker");
		
		teamNameUser = prop.getProperty("teamNameUser");
		teamDomainUser = prop.getProperty("teamDomainUser");
		emailUser = prop.getProperty("emailUser");
		pwdUser = prop.getProperty("pwdUser");
		
		file = new File("src/main/resources/url.properties");
		fileInput = null;
		
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		commonPageUrl = prop.getProperty("commonPageUrl");
		productPageUrl = prop.getProperty("productPageUrl");
		signInPageUrl = prop.getProperty("signInPageUrl");
		signInUserPageUrl = prop.getProperty("signInUserPageUrl");
		messagesGeneralPageUrl = prop.getProperty("messagesGeneralPageUrl");
		filesGeneralPageUrl = prop.getProperty("filesGeneralPageUrl");
		sfChannelPageUrl = prop.getProperty("sfChannelPageUrl");
		bayAreaLifeChannelPageUrl = prop.getProperty("bayAreaLifeChannelPageUrl");	
	}
	
	/**
	 * @return a random line for a message from messages.csv file
	 */
	public String pickUpMessage() {
		
		BufferedReader reader;				
		List<String> lines = new ArrayList<String>();
		String line;	
		try {
			reader = new BufferedReader(new FileReader("src/main/resources/messages.csv"));
			line = reader.readLine();

			while( line != null ) {
				lines.add(line);
				line = reader.readLine();				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Choose a random one from the list
		Random r = new Random();
		String randomString = lines.get(r.nextInt(lines.size()));
		
		return randomString;
	}
	
} // class ReadFileData