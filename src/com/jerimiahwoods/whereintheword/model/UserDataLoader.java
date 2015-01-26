package com.jerimiahwoods.whereintheword.model;


public class UserDataLoader {
	
	public static UserData loadUserData() {
		
		UserData userData = new UserData();
		userData.setBibleVerses(BibleVerseLoader.loadVerses());
		userData.setChapterSummaries(ChapterSummaryLoader.loadChapterSummaries()) ;

		return userData;
		
	}
}
