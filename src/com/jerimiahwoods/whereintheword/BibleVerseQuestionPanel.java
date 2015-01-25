package com.jerimiahwoods.whereintheword;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BibleVerseQuestionPanel extends GenericQuestionPanel {
	
	public BibleVerseQuestionPanel() {
		
		confirmAnswerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAndDisplayAnswer();
			}
		});
	}

	public BibleVerse generateRandomAnswer() {
											
		Random randomizer = new Random();
		int randomScriptureSelector = randomizer.nextInt(WhereInTheWord.getBibleVerses().size());
		
		return WhereInTheWord.getBibleVerses().get(randomScriptureSelector);
	}
		
}
