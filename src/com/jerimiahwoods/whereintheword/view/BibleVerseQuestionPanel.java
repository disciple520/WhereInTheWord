package com.jerimiahwoods.whereintheword.view;

import java.util.ArrayList;
import java.util.Collections;

import com.jerimiahwoods.whereintheword.controller.DataController;
import com.jerimiahwoods.whereintheword.model.BibleVerse;
import com.jerimiahwoods.whereintheword.model.QuizzableItem;

public class BibleVerseQuestionPanel extends MultipleChoiceQuestionPanel {
	
	public BibleVerseQuestionPanel(DataController dataController) {
		
		super(dataController);
		
	}

	public ArrayList<QuizzableItem> generateRandomAnswers() {
		
		ArrayList<BibleVerse> userBibleVerses;
		userBibleVerses = new ArrayList<BibleVerse>();
		userBibleVerses = dataController.getUserBibleVerses();	
		
		Collections.shuffle(userBibleVerses);
		
		ArrayList<QuizzableItem> randomAnswers = new ArrayList<QuizzableItem>();
		
		for (int i=0; i<4; i++){
			randomAnswers.add(userBibleVerses.get(i));
		}
		
		return randomAnswers;
	}
		
}
