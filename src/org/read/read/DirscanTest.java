package org.read.read;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DirscanTest {
	static final String desktopPath = "C:\\\\Users\\\\uu04\\\\desktop";
	static final String libraryPath = "C:\\Users\\uu04\\Desktop\\History\\Userdata\\0000-00AA";
	
	static final Boolean ForceCheckEsFile = true;

	static List<String> fileList = new ArrayList<String>();
	
	public static void main(String[] args) {
		//0. Directory Scan/chk
		String[] EssentialFiles = {"essential.txt", "need.exe", "history.apc", "Regi.mrc"};
		
		
		Path dir = Path.of(libraryPath);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
		    for (Path file: stream) {
		    	String s = file.getFileName().toString();
		    	System.out.println(s);
		    	if(s==null) continue;
		    	fileList.add(s);
		    }
		} catch (IOException | DirectoryIteratorException x) {
		    System.err.println(x);
		}
		
		if(ForceCheckEsFile) {
			for (int i = 0; i < EssentialFiles.length; i++) {
				if(!fileList.contains(EssentialFiles[i])) {
//					System.out.println("[!] CANNOT FIND ESSENTIAL PLUGIN FILE : " + EssentialFiles[i]);
				}
			}
		}
	}
}
