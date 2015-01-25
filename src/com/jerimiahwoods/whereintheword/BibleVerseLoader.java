package com.jerimiahwoods.whereintheword;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BibleVerseLoader {

	final static String FILE_CONTAINING_BIBLE_VERSES = "Bible Verses";
	
	public static ArrayList<BibleVerse> loadVerses() throws IOException {
		
		ArrayList<BibleVerse> bibleVerses = new ArrayList<BibleVerse>();
		
		FileReader verseReader = new FileReader(FILE_CONTAINING_BIBLE_VERSES);
		BufferedReader bufferedReader = new BufferedReader(verseReader);
		
		String lineFromBibleVerseFile = "";    
		while ((lineFromBibleVerseFile = bufferedReader.readLine()) != null) {
			
			String[] bibleVerseElements = lineFromBibleVerseFile.split("\\|");
			String book        = bibleVerseElements[0];
			String chapter     = bibleVerseElements[1];
			String verseNumber = bibleVerseElements[2];
			String text        = bibleVerseElements[3];
			
			bibleVerses.add(new BibleVerse(book, chapter, verseNumber, text));
		}
		
		bufferedReader.close();
		
		return bibleVerses;
		
	}
}
