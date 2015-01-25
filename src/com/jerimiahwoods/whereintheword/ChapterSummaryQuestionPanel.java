package com.jerimiahwoods.whereintheword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ChapterSummaryQuestionPanel extends MultipleChoiceQuestionPanel {

	private ArrayList<ChapterSummary> chapterSummaries;
	
	public ChapterSummaryQuestionPanel() {
		
		chapterSummaries = WhereInTheWord.getChapterSummaries();
		
		confirmAnswerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				checkAndDisplayAnswer();
			}
		});
	}

	public ArrayList<QuizzableItem> generateRandomAnswers() {
		
		Collections.shuffle(chapterSummaries);
		
		ArrayList<QuizzableItem> randomAnswers = new ArrayList<QuizzableItem>();
		
		for (int i=0; i<4; i++){
			randomAnswers.add(chapterSummaries.get(i));
		}
		
		return randomAnswers;
		
	}
	
}
