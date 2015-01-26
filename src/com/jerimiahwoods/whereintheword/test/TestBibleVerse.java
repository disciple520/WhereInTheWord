package com.jerimiahwoods.whereintheword.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jerimiahwoods.whereintheword.model.BibleVerse;

public class TestBibleVerse {

	@Test
	public void ConstructorShouldCorrectlyCreateObject() {
		
		BibleVerse bibleVerse = new BibleVerse("Ephesians", "2", "4", "But God, being rich in mercy");
		
		assertEquals(bibleVerse.getText(), "\"But God, being rich in mercy\"");
		assertEquals(bibleVerse.getBook(), "Ephesians");
		assertEquals(bibleVerse.getChapter(), "2");
		assertEquals(bibleVerse.getVerseNumber(), "4");
		assertEquals(bibleVerse.getScriptureReference(), "Ephesians 2:4");
	}
	
	@Test
	public void toStringMethodShouldPrintCorrectly() {
		
		BibleVerse bibleVerse = new BibleVerse("Ephesians", "2", "4", "But God, being rich in mercy");
		
		assertEquals(bibleVerse.toString(), "\"But God, being rich in mercy\" - Ephesians 2:4");
		
	}

}
