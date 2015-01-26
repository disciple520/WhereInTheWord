package com.jerimiahwoods.whereintheword.controller;

import com.jerimiahwoods.whereintheword.model.UserData;
import com.jerimiahwoods.whereintheword.model.UserDataLoader;
import com.jerimiahwoods.whereintheword.view.UIManager;

public class WhereInTheWord {
	
	public static void main(String[] args) {
	
		UserData userData = new UserData();
		userData = UserDataLoader.loadUserData();
		
		DataController dataController = new DataController();
		dataController.setUserData(userData);
		
		UIManager.buildUI(dataController);
		
	}

	
	
}
