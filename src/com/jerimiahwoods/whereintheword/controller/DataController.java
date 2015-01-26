package com.jerimiahwoods.whereintheword.controller;

import java.util.ArrayList;

import com.jerimiahwoods.whereintheword.model.BibleVerse;
import com.jerimiahwoods.whereintheword.model.ChapterSummary;
import com.jerimiahwoods.whereintheword.model.UserData;

public class DataController {
	
	UserData userData;
	
	public DataController() {
		userData = new UserData();
	}
	
	public ArrayList<BibleVerse> getUserBibleVerses() {
		
		return userData.getBibleVerses();
		
	}
	
	public ArrayList<ChapterSummary> getUserChapterSummaries() {
		
		return userData.getChapterSummaries();
		
	}

	public UserData getUserData() {
		return userData;
	}
	public void setUserData(UserData userData) {
		this.userData = userData;
	}
	
	
}

