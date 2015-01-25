package com.jerimiahwoods.whereintheword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;

public class ChapterSummaryQuestionPanel extends GenericQuestionPanel {

	private ArrayList<ChapterSummary> chapterSummaries;
	
	public ChapterSummaryQuestionPanel() {
		
		chapterSummaries = WhereInTheWord.getChapterSummaries();
		
		final ButtonGroup answerButtonGroup = new ButtonGroup();
		answerButtonGroup.add(answerOneRadioButton);
		answerButtonGroup.add(answerTwoRadioButton);
		answerButtonGroup.add(answerThreeRadioButton);
		answerButtonGroup.add(answerFourRadioButton);
		
		confirmAnswerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				userAnswer = answerButtonGroup.getSelection().getActionCommand();
				checkAnswer();
				WhereInTheWord.displayAnswerPanel();
				
			}
		});
	}

	public ChapterSummary generateRandomAnswer() {
		
		Random randomizer = new Random();
		int randomSummaryIndex = randomizer.nextInt(chapterSummaries.size());
		
		return chapterSummaries.get(randomSummaryIndex);
		
	}
	
}
