package com.jerimiahwoods.whereintheword;

import java.util.ArrayList;

public class WhereInTheWord {
	
	private static ArrayList<BibleVerse>     bibleVerses;
	private static ArrayList<ChapterSummary> chapterSummaries;
    
	public static void main(String[] args) throws Exception {
	
		loadQuizQuestionArrays();
		UIManager.buildUI();
		
	}

	public static void loadQuizQuestionArrays() throws Exception {
		
		bibleVerses      = BibleVerseLoader.loadVerses();
		chapterSummaries = ChapterSummaryLoader.loadChapterSummaries();
		
	}

	
	
	
	
	
	
	
	
	
// *********Getters and Setters********* //

	public static ArrayList<BibleVerse> getBibleVerses() {
		return bibleVerses;
	}

	public static void setBibleVerses(ArrayList<BibleVerse> bibleVerses) {
		WhereInTheWord.bibleVerses = bibleVerses;
	}

	public static ArrayList<ChapterSummary> getChapterSummaries() {
		return chapterSummaries;
	}

	public static void setChapterSummaries(ArrayList<ChapterSummary> chapterSummaries) {
		WhereInTheWord.chapterSummaries = chapterSummaries;
	}


	
	
}
