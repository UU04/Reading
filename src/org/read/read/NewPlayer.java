package org.read.read;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

public class NewPlayer {
	static Random rand = new Random();

	static final String libraryPath = "C:\\\\Users\\\\uu04\\\\desktop\\\\History";
	static final String UserlibraryPath = libraryPath+"\\\\Userdata";
	
	static final String OriginPath = libraryPath+"\\Userdata\\0000-00AA";
	static final String[] UserComponents = {"channelhistory.txt","inventoryreport.txt"
			, "loginhistory.txt", "logouthistory.txt", "securityInfo.txt"};
	
	public static HashMap<String, String> map = new HashMap<String, String>();
	
	public static void Write(String originpath, String newpath) {
		List<String> a = ReadModule.read(originpath, false);
		String all = "";
		for (int i = 0; i < a.size(); i++) {
			String afterTag = TagLine(a.get(i));
			all += afterTag+"\n";
		}
		try {
			FileWriter fw = new FileWriter(newpath);
			fw.write(all);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			textbook.error("IOEXCEPTION");
			e.printStackTrace();
		}
	}
	
	public static String TagLine(String s) {
		String t = s;
		List<String> list;
		if(s.contains("${")&&s.contains("}")) {
			String[] segment = s.split("\\$\\{");
			list = Arrays.stream(segment).collect(Collectors.toList());
//			list = new ArrayList<>(Arrays.asList(segment));
			
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).contains("}")) {
					String code = list.get(i).replace("}", "");
					if(map.containsKey(code)) s = s.replace("${"+code+"}", map.get(code));
					if(!map.containsKey(code)) {
						s = s.replace("${"+code+"}", "NULL");
						textbook.error("TagLine Error, " + code + " value cannot be found.");
						textbook.error("ORIGINAL :");
						textbook.error(t);
					}
				}
			}
		}
		return s;
	}
	
	public static void RegisterPlayer(UUID uuid) {
		String PlayerName = "PLAYERNAME HERE";
		
		int TotalPlayers = 88;
		int digit = Integer.toString(TotalPlayers).length();
		
		if(digit>4) {
			textbook.error("CANNOT REGISTER PLAYER " + PlayerName + "(*digit limit reached)");
			textbook.error("UUID: " + uuid);
			textbook.error("Player Num: " + TotalPlayers);
			return;
		}
		String NewID = "";
		for (int i = 0; i < 4-digit; i++) {
			NewID += "0";
		}
		NewID += TotalPlayers + "-";
		
		for(int i = 0; i<4; i++) {
			int iValue = rand.nextInt(10);
			NewID += Integer.toString(iValue);
		}
		
		System.out.println(PlayerName + "[" + NewID + "]");
		
		TotalPlayers += 1;
		
	}
	
	public static void main(String[] args) {
		//0. Check for directory / value setup
		
		String PlayerName = "PLAYERNAME HERE";
		String PlayerID = "PLAYERID HERE";
		String PlayerUUID = "UUID";
		
		map.put("name", PlayerName);
		map.put("id", PlayerID);
		map.put("uuid", PlayerUUID);
		
		String PlayerPath = UserlibraryPath + "\\\\" + PlayerID;
		
		//1. create player directory
		Dirscan.CreateDir(PlayerPath);
		
		//2. copy files(auto-tagged)
		for (int i = 0; i < UserComponents.length; i++) {
			String a = UserComponents[i];
			Write(OriginPath+"\\\\"+a, PlayerPath+"\\\\"+a);	
		}
	}
}
