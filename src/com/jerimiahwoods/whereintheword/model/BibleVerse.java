package com.jerimiahwoods.whereintheword.model;

public class BibleVerse extends QuizzableItem{
	
	private String book;
	private String chapter;
	private String verseNumber;
	
	public BibleVerse() {
		
	}
	
	public BibleVerse(String book, String chapter, String verse, String text) {
		
		this.book         = book;
		this.chapter      = chapter;
		this.verseNumber  = verse;
		
		this.text         = "\"" + text + "\"";
		
		scriptureReference = book + " " + chapter + ":" + verse;
		
	}

	
	
	
	
	
	
	
	
	
// *********Getters and Setters********* //
	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getVerseNumber() {
		return verseNumber;
	}

	public void setVerseNumber(String verseNumber) {
		this.verseNumber = verseNumber;
	}
	
	
	
}
