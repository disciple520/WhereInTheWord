package com.jerimiahwoods.whereintheword;

public class BibleVerse extends QuizzableItem{
	
	private String book;
	private String chapter;
	private String verse;
	
	
	public BibleVerse(String book, String chapter, String verse, String text) {
		
		this.book = book;
		this.chapter = chapter;
		this.verse = verse;
		scriptureReference = book + " " + chapter + ":" + verse;
		
		this.text = text;
		
	}
	
}
