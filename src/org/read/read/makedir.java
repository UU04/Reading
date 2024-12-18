package org.read.read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class makedir {
	static final String desktopPath = "C:\\\\Users\\\\uu04\\\\desktop";
	static final String libraryPath = "C:\\\\Users\\\\uu04\\\\desktop\\\\History";
	
	static final String dirName = "folder1";
	
	public static void main(String[] args) {
		Path dir = Path.of(desktopPath+"\\\\"+dirName);
		try {
			Files.createDirectory(dir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
