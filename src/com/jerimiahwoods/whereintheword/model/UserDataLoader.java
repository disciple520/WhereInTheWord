package com.jerimiahwoods.whereintheword.model;

import com.jerimiahwoods.whereintheword.controller.BibleVerseLoader;
import com.jerimiahwoods.whereintheword.controller.ChapterSummaryLoader;

public class UserDataLoader {
	
	public static UserData loadUserData() throws Exception {
		
		UserData userData = new UserData();
		userData.setBibleVerses(BibleVerseLoader.loadVerses());
		userData.setChapterSummaries(ChapterSummaryLoader.loadChapterSummaries()) ;

		return userData;
		
	}
}
