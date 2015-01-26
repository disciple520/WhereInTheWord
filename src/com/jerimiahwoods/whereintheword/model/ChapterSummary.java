package com.jerimiahwoods.whereintheword.model;


public class ChapterSummary extends QuizzableItem {

	public ChapterSummary(String summaryText, String chapterReference) {
		
		super(summaryText, chapterReference);
		
	}
	
	public String toString() {
		return text + " (" + scriptureReference + ")";
	}

}
