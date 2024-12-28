package org.read.read;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class channel {
	static Random rand = new Random();
	static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
	
	static List<String> channelList = new ArrayList();
	
	static HashMap<UUID, String> channel_map = new HashMap<UUID, String>();
	
	public static String NewChannelCode() {
		int iVal = rand.nextInt(26);
		int iVal1 = rand.nextInt(50);
		String r = alphabet[iVal]+Integer.toString(iVal1);
		return r;
	}
	
	public static void RegisterChannel(Boolean isPublic) {
		String t = NewChannelCode();
		int count = 0;
		while (channelList.contains(t)) {
			if(count==3) {
				textbook.error("Channel Feed is full. *Unable to register new channel(CODE FULL)");
				return;
			}
			t = NewChannelCode();
			count++;
		}
		
		channelList.add(t);
		textbook.info("New channel has been created. " + t + "(Public: " + isPublic + ")");
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
		System.out.println();
		for (int i = 0; i < 10; i++) {
			RegisterChannel(false);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}