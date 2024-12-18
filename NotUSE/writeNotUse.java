package org.read.read;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class test {
	public static void main(String[] args) {
		List<String> a = ReadModule.read("C:\\\\Users\\\\uu04\\\\eclipse-workspace\\\\reading\\\\src\\\\org\\\\read\\\\read\\\\AE29.txt", true);
		String all = "";
		for (int i = 0; i < a.size(); i++) {
			all += a.get(i)+"\n";
		}
		try {
			FileWriter fw = new FileWriter("src\\\\org\\\\read\\\\read\\\\e.txt");
			fw.write(all);
			fw.close();
			System.out.println(all);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
