package org.read.read;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class textbook {
	final static String LogPath = "";
	
	final static String LogPrefix = TimeModule.date()+" "+TimeModule.time();
	final static String LogErrorPrefix = " [ERROR] ";
	final static String LogInfoPrefix = " [INFO] ";
	
	final static Boolean AutoAlertsLog = true;
	final static String DateChangeAlert = "SYSTEM DATE HAS CHANGED.";

	final static String LogWARNPrefix = "[***WARNING***] ";
	
	final static String DefaultPrefix = LogPrefix+LogInfoPrefix;
	
	static void error(String error) {
		System.out.println(LogPrefix+LogErrorPrefix+error);
	}
	
	static void info(String info) {
		System.out.println(LogPrefix+LogInfoPrefix+info);
	}
	
	static void warn(String warn) {
		System.out.println(LogPrefix+LogWARNPrefix+warn);
	}
	
	static void DefaultLogVoid() { //minimum cycle length : 1sec
		String[] list = TimeModule.time().split(":");
		int v = 0;
		for (int i = 0; i < list.length; i++) {
			int d = Integer.parseInt(list[i]);
			if(d==0) v++;
		}
		
		if(v==3) System.out.println(DateChangeAlert);
	}

	
	public static void log(String s) {
		List<String> beforeLog = ReadModule.readOriginal(LogPath);
		beforeLog.add("\n"+s);
		
		try {
			FileWriter fw = new FileWriter(LogPath);
			fw.write(s);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			textbook.error("IOEXCEPTION");
			e.printStackTrace();
		}
	}
}
