package com.mycompany.app.blog;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BlogTest {
	private Blog blog;
	private int id;
	
	@Before
	public void setUp() {
		blog = new Blog();		
	}	

	@Test
	public void whenANewEntryIsSentToTheBlogThenItIsAddedToTheListOfEntries() {		
		id = blog.newEntry("title1 test1","body");
		assertNotNull(blog.searchEntry(id));		
	}

	@Test
	public void whenAnEntryIsDeletedThenItIsRemovedFromTheListOfEntries() {	
		blog.newEntry("title1 test2","body");
		id = blog.newEntry("title2 test2","body");	
		blog.newEntry("title3 test2","body");	
		assertNotNull(blog.searchEntry(id));		
		
		blog.deleteEntry(id);
		assertNull(blog.searchEntry(id));
	}
	
	@Test
	public void returnsThe10mostRecentEntries() {
		boolean isRecent1 = false;
		boolean isRecent2 = false;
		boolean isRecent11 = false;
		
		int id1 = blog.newEntry("title1 test3","body");	
		int id2 = blog.newEntry("title2 test3","body");
		blog.newEntry("title3 test3","body");
		blog.newEntry("title4 test3","body");
		blog.newEntry("title5 test3","body");
		blog.newEntry("title6 test3","body");
		blog.newEntry("title7 test3","body");
		blog.newEntry("title8 test3","body");
		blog.newEntry("title9 test3","body");
		blog.newEntry("title10 test3","body");
		int id11 = blog.newEntry("title11 test3","body");
		
		ArrayList<Entry> mostRecentEntries = blog.getMostRecentEntries();
		
		for(Entry entry : mostRecentEntries) {
			if(entry.getId() == id1) {
				isRecent1 = true;
			} else if(entry.getId() == id2) {
				isRecent2 = true;
			} else if(entry.getId() == id11) {
				isRecent11 = true;
			}
		}		
		assertFalse(isRecent1);
		assertTrue(isRecent2);
		assertTrue(isRecent11);
		assertEquals(10, mostRecentEntries.size());
	}
}
