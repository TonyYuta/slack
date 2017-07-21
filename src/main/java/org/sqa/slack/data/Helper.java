/**
 *   File Name: Helper.java<br>
 *
 *   Yutaka<br>
 *   Created: Aug 7, 2016
 *   
 */

package org.sqa.slack.data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Helper methods for tests
 *
 */
public class Helper {
	
	ReadFileData readFileData;
	
	/**
	 * get time stamp for a message
	 * @return date & time
	 */
	public String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate); 
		return formattedDate; 
	}
	
	/**
	 * generating a message
	 * @return a generated message
	 */
	public String getMessage() {
		readFileData = new ReadFileData();
		String message;
		message = getTimeStamp() + " | " + readFileData.pickUpMessage();
		return message;
		
	} 

} // class Helper
