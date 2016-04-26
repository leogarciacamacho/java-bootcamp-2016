package com.mycompany.app.recentFileListBehaviour;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecentFileListTest {
	private RecentFileList recentFileList;
	private File file;
	
	@Before
	public void setUp() {
		recentFileList = new RecentFileList();	
	}
	
	@Test
	public void whenProgramIsRunForFirstTimeThenListIsEmpty() {
		assertTrue(recentFileList.isEmpty());
	}
	
	@Test
	public void whenAFileIsOpenedThenItIsAddedToTheRecentFileList() {
		file = new File();
		file.open(recentFileList);
		assertTrue(recentFileList.getList().contains(file));
	}
	
	@Test
	public void whenAnOpenedFileAlreadyExistInTheListThenItIsBumpedToTheTop() {	
		for(int i = 0;i<5;i++) {
			file = new File();
			file.open(recentFileList);
		}
		
		int listSize = recentFileList.getList().size();
		
		file = recentFileList.getList().get(2);
		
		file.open(recentFileList);
		
		assertEquals(listSize, recentFileList.getList().size());		
	}
	
	@Test
	public void whenTheListIsFullThenOlderItemIsRemovedWhenNewOneIsAdded() {
		for(int i = 0; i < RecentFileList.getMaxCant(); i++) {
			file = new File();
			file.open(recentFileList);
		}
		File olderFile = recentFileList.getList().get(0);
		assertTrue(recentFileList.getList().contains(olderFile));
		
		file = new File();
		file.open(recentFileList);
		
		assertFalse(recentFileList.getList().contains(olderFile));
	}
}
