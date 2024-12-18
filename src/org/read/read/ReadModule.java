package org.read.read;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadModule {
	public static List<String> read(String a, boolean b) {
		
		String address = a;
		
		List<String> list = new ArrayList<>();
		List<String> dnrC = new ArrayList<>();
		 
		String DNRsign = "%DNR%"; //DNR HAS TO BE DECLARED BEFORE ANY LINES
		Boolean HasDNR = false;
		Boolean FoundDNR = false;
		 
		Boolean UseDNRsegment = b; //######################### segment DNR
		Boolean StartDNR = false;
		 
	    try {
	      File myObj = new File(address);
	      Scanner myReader = new Scanner(myObj);
	      int n = 0;
	      while (myReader.hasNextLine()) {
	    	n++;
	        String data = myReader.nextLine();
	        
	        if(data.contains(DNRsign)) { //DNR SIGN
	        	if(data.contains("startdnrfalse")) StartDNR = false;
	        	String[] splitStr = data.split(" ");
	        	for(int i=0; i<splitStr.length; i++){
	        	    dnrC.add(splitStr[i]);
	        	}
	        	HasDNR = true;
	        	if(UseDNRsegment && !dnrC.contains("#")) {
	        		dnrC.add("#");
	        	}
	        	continue;
	        }
	        if(!HasDNR) { //NO DNR
	        	list.add(data);
	        	continue;
	        }
	        for (int i = 0; i < dnrC.size(); i++) { //SEARCH
	        	if(data.contains("#") && UseDNRsegment) {
	        		FoundDNR=true;
	        		data="";
	        		StartDNR = !StartDNR;
	        	}
	        	if(data.contains(dnrC.get(i))) {
        			data = "";
        			FoundDNR = true;
        		}
        	}
	        if(StartDNR) {
	        	continue; //START DNR
	        }
	        if(!FoundDNR) {
        		list.add(data);
        		System.out.println(data);
	        }
	        FoundDNR = false;
	        continue; 
	      }
//	      System.out.println("\nfiltered:" + dnrC.toString());
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    
	    return list;
	  }
}