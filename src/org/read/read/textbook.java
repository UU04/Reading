package org.read.read;

public class textbook {
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
}
