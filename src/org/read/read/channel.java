package org.read.read;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class channel {
	static final String libraryPath = "C:\\Users\\uu04\\Desktop\\History\\ChannelLive.txt";
	static final String ORlibraryPath = "C:\\Users\\uu04\\Desktop\\History\\origins\\ChannelLive.txt";
	
	static Random rand = new Random();
	static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
	
	static List<String> channelList = new ArrayList();
	
	
	public static String NewChannelCode() {
		int iVal = rand.nextInt(26);
		int iVal1 = rand.nextInt(50);
		String r = alphabet[iVal]+Integer.toString(iVal1);
		return r;
	}
	
	public static void RegisterChannel(String optionCode, Boolean isPublic) {
		String t="";
		if(optionCode == null) t = NewChannelCode();
		if(optionCode != null) t = optionCode;
		
		int count = 0;
		while (channelList.contains(t)) {
			if(count==3) {
				textbook.error("Channel Feed is full. *Unable to register new channel(CODE FULL)");
				return;
			}
			t = NewChannelCode();
			count++;
		}
		
		if(isPublic) t = "public_"+t;
		if(!isPublic) t = "private_"+t;
		
		channelList.add(t);
		textbook.info("New channel has been created. " + t);
		
		HashMap<String, String> temp = new HashMap<String, String>();
		
		for (int i = 0; i < channelList.size(); i++) {
			String thisCH = channelList.get(i);
			
			if(thisCH.split("_").length < 2) {
				textbook.error("ArrayOutOfBound - channel creation failed.");
				return;
			}
			
			String prefix = thisCH.split("_")[0];
			String name = thisCH.split("_")[1];
			
			if(temp.containsKey(prefix)) temp.put(prefix, temp.get(prefix)+"\n"+name);
			if(!temp.containsKey(prefix)) temp.put(prefix, name);
		}
		
		NewPlayer.Write(ORlibraryPath, libraryPath, temp);
	}
	
	public static void disableChannel(String channelCode) {
		if(!channelList.contains(channelCode)) {
			textbook.error(channelCode+" channel does not exist.");
			return;
		}
		channelList.remove(channelCode);
		textbook.info(channelCode + " channel is disabled.");
	}
	
	public static void clearChannel() {
		channelList = new ArrayList();
		textbook.info("<DEV> Channel clear.");
	}
	
	public static void main(String[] args) {
	
	}
}