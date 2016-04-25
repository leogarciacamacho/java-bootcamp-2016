package com.mycompany.app.recentFileListBehaviour;

public class File {
	
	public void open(RecentFileList recentFileList) {
		recentFileList.addFile(this);
	}

}
