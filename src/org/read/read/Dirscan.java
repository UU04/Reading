package org.read.read;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Dirscan {
	static final String libraryPath = "C:\\\\Users\\\\uu04\\\\desktop\\\\History";
	
	static final Boolean ForceCheckEsFile = true;

	static List<String> fileList = new ArrayList<String>();
	
	public static void dirScanLibrary() {
		//0. Directory Scan/chk
		String[] EssentialFiles = {"essential.txt", "need.exe", "history.apc", "Regi.mrc"};
		
		Path dir = Path.of(libraryPath);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
		    for (Path file: stream) {
		    	String s = file.getFileName().toString();
		    	if(s==null) continue;
		    	fileList.add(s);
		    }
		} catch (IOException | DirectoryIteratorException x) {
		    System.err.println(x);
		}
		
		if(ForceCheckEsFile) {
			for (int i = 0; i < EssentialFiles.length; i++) {
				if(!fileList.contains(EssentialFiles[i])) {
					textbook.error("CANNOT FIND ESSENTIAL PLUGIN FILE : " + EssentialFiles[i] + "; SEARCH RECOMMENDED");
				}
			}
		}
		return;
	}
}
