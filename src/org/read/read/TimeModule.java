package org.read.read;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeModule {

// github.com/captain0potlid/mujudatetime(source)
	
	public static String time() {
	    LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH");
	    DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("mm");
	    DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("ss");
	    String formattedDate = myDateObj.format(myFormatObj);
	    String formattedDate1 = myDateObj.format(myFormatObj1);
	    String formattedDate2 = myDateObj.format(myFormatObj2);
	    int hours = Integer.parseInt(formattedDate);
	    
	    return hours+":"+formattedDate1+":"+formattedDate2;
	}
	
	public static String date() {
	    LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj3 = DateTimeFormatter.ofPattern("yyyy");
	    DateTimeFormatter myFormatObj4 = DateTimeFormatter.ofPattern("MM");
	    DateTimeFormatter myFormatObj5 = DateTimeFormatter.ofPattern("dd");
	    String formattedDate3 = myDateObj.format(myFormatObj3); //year
	    String formattedDate4 = myDateObj.format(myFormatObj4); //month
	    String formattedDate5 = myDateObj.format(myFormatObj5); //day
	    
	    return formattedDate3+"-"+formattedDate4+"-"+formattedDate5;
	}
	
//	if(hours >= 13) {
//    	ampm = true;
//    	hour = Integer.toString(hours - 12);
//    	thisTail = "오후";
//    }else {
//    	hour = Integer.toString(hours);
//    	thisTail = "오전";
//    }
}
