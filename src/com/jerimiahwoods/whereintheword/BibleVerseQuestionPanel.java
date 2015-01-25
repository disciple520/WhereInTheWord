package com.jerimiahwoods.whereintheword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class BibleVerseQuestionPanel extends MultipleChoiceQuestionPanel {
	
	ArrayList<BibleVerse> bibleVerses;
	
	public BibleVerseQuestionPanel() {
		
		bibleVerses = WhereInTheWord.getBibleVerses();
		
		confirmAnswerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAndDisplayAnswer();
			}
		});
	}

	public ArrayList<QuizzableItem> generateRandomAnswers() {
					
		Collections.shuffle(bibleVerses);
		
		ArrayList<QuizzableItem> randomAnswers = new ArrayList<QuizzableItem>();
		
		for (int i=0; i<4; i++){
			randomAnswers.add(bibleVerses.get(i));
		}
		
		return randomAnswers;
	}
		
}
