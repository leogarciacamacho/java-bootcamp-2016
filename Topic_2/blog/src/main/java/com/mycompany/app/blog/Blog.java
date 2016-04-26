package com.mycompany.app.blog;

import java.util.ArrayList;

public class Blog {
	private ArrayList<Entry> listOfEntries;
	private Entry entry;
	
	public Blog() {
		listOfEntries = new ArrayList<Entry>();
	}
	
	public int newEntry(String title, String body) {
		entry = new Entry(title, body);
		int id = entry.getId();
		listOfEntries.add(entry);
		return id;
	}
	
	public Entry searchEntry(int id) {
		for(Entry searchedEntry : listOfEntries) {
			if(searchedEntry.getId() == id) {				
				return searchedEntry;
			}		
		}
		return null;
	}
	
	public void deleteEntry(int id) {
		for(Entry searchedEntry : listOfEntries) {
			if(searchedEntry.getId() == id) {				
				listOfEntries.remove(searchedEntry);
				break;
			}
		}
	}
	
	public ArrayList<Entry> getMostRecentEntries() {
		 ArrayList<Entry> mostRecentEntries = new ArrayList<Entry>();
		 int indexOfEntry = listOfEntries.size() - 1;
		 for(int i = 0; i <10; i++) {
			 mostRecentEntries.add(listOfEntries.get(indexOfEntry));
			 indexOfEntry--;
		 }
		 return mostRecentEntries;		 
	}
}
