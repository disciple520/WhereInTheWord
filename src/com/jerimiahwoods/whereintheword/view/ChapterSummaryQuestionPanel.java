package com.jerimiahwoods.whereintheword.view;

import java.util.ArrayList;
import java.util.Collections;

import com.jerimiahwoods.whereintheword.controller.DataController;
import com.jerimiahwoods.whereintheword.model.ChapterSummary;
import com.jerimiahwoods.whereintheword.model.QuizzableItem;

public class ChapterSummaryQuestionPanel extends MultipleChoiceQuestionPanel {

	private ArrayList<ChapterSummary> chapterSummaries;
	
	public ChapterSummaryQuestionPanel(DataController dataController) {
		
		super(dataController);
		
	}

	public ArrayList<QuizzableItem> generateRandomAnswers() {
		chapterSummaries = dataController.getUserChapterSummaries();
		Collections.shuffle(chapterSummaries);
		
		ArrayList<QuizzableItem> randomAnswers = new ArrayList<QuizzableItem>();
		
		for (int i=0; i<4; i++){
			randomAnswers.add(chapterSummaries.get(i));
		}
		
		return randomAnswers;
		
	}
	
}
