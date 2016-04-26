package com.mycompany.app.recentFileListBehaviour;

import java.util.LinkedList;

public class RecentFileList {
	
	private LinkedList<File> list = new LinkedList<File>();
	private final static int maxCant = 15;
	
	public void addFile(File file) {
		if(list.contains(file)) {
			list.remove(file);
		}
		if(list.size() == maxCant){
			list.removeFirst();
		}
		list.add(file);
	}
	
	public LinkedList<File> getList(){
		return list;		
	}

	public static int getMaxCant() {
		return maxCant;
	}

	public boolean isEmpty() {
		if(list.size() == 0) {
			return true;
		}
		return false;
	}
	
}
