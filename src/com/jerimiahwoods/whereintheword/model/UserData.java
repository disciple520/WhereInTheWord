package com.jerimiahwoods.whereintheword.model;

import java.util.ArrayList;

public class UserData {
	
	private ArrayList<BibleVerse>     bibleVerses;
	private ArrayList<ChapterSummary> chapterSummaries;
	
	public ArrayList<BibleVerse> getBibleVerses() {
		return bibleVerses;
	}
	public void setBibleVerses(ArrayList<BibleVerse> bibleVerses) {
		this.bibleVerses = bibleVerses;
	}
	public ArrayList<ChapterSummary> getChapterSummaries() {
		return chapterSummaries;
	}
	public void setChapterSummaries(ArrayList<ChapterSummary> chapterSummaries) {
		this.chapterSummaries = chapterSummaries;
	}
	
}
