package com.jerimiahwoods.whereintheword.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BibleVerseLoader {

	final static String FILE_CONTAINING_BIBLE_VERSES = "Bible Verses";
	
	public static ArrayList<BibleVerse> loadVerses() {
		
		ArrayList<BibleVerse> bibleVerses = new ArrayList<BibleVerse>();
		
		try {
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bibleVerses;
		
	}
}
