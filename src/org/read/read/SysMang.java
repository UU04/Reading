package org.read.read;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

public class SysMang {
	static final String libraryPath = "C:\\Users\\uu04\\Desktop\\History\\ChannelLive.txt";
	static final String ORlibraryPath = "C:\\Users\\uu04\\Desktop\\History\\origins\\ChannelLive.txt";
	
	public static HashMap<String, String> map = new HashMap<String, String>();
	
	
	public static void main() {
		List<String> lines = ReadModule.readOriginal(libraryPath);
		List<String> channels = new ArrayList();
		
		String push_prefix = "ERR";
		for (int i = 0; i < lines.size(); i++) {
			if(lines.get(i).isBlank()) continue;
			if(lines.get(i).contains("*")) {
				push_prefix = lines.get(i).replace("***Chat Channels - ", "");
				continue;
			}
			channels.add(push_prefix + "_"+lines.get(i));
		}
		
		DefaultListModel listModel = new DefaultListModel();
		JList list = new JList(listModel);
		int count = 0;
		for (int i = 0; i < channels.size(); i++) {
			count++;
			listModel.addElement(channels.get(i));
		}
		
		if(MyWindow.itemcount != count) {
			MyWindow.list.setModel(listModel);
			MyWindow.itemcount = count;
		}
	}
	
	public static void ChannelRegister() {
		List<String> lines = ReadModule.readOriginal(libraryPath);
		List<String> channels = new ArrayList();
		
		String push_prefix = "ERR";
		int load = 0;
		for (int i = 0; i < lines.size(); i++) {
			if(lines.get(i).isBlank()) continue;
			if(lines.get(i).contains("*")) {
				load++;
				push_prefix = lines.get(i).replace("***Chat Channels - ", "");
				continue;
			}
			channels.add(lines.get(i));
		}
		
		map.put("public", "");
		
		Write(ORlibraryPath, libraryPath);
	}
	
	public static void Write(String originpath, String newpath) {
		List<String> a = ReadModule.readOriginal(originpath);
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
}
