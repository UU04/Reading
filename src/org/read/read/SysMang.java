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
			channel.channelList = channels;
			System.out.println("updated channelList");
		}
		
	}
}
