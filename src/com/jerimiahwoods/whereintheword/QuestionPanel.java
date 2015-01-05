package com.jerimiahwoods.whereintheword;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;



public class QuestionPanel extends JPanel {

	private String answer = "";
	private String correctAnswer = "";
	private String resultPhrase = "";
	
	private ArrayList<String> allLinesFromMasterFile;
	private String randomBook;
	private String randomChapter;
	private String randomVerse;
	private String randomText;
	private String randomReference;
	
	private JTextArea questionText;
	ArrayList<JRadioButton> radioButtons;
	private JRadioButton optAnswerOne;
	private JRadioButton optAnswerTwo;
	private JRadioButton optAnswerThree;
	private JRadioButton optAnswerFour;
	private ButtonGroup answerButtonGroup;
	private JButton confirmAnswerButton;
	
	
	public QuestionPanel() {
		
		this.setBackground(Color.lightGray);
		
		questionText = new JTextArea(1,45);
		questionText.setLineWrap(true);
		questionText.setWrapStyleWord(true);
		questionText.setBackground(Color.lightGray);
			
		optAnswerOne = new JRadioButton();
		optAnswerTwo = new JRadioButton();
		optAnswerThree = new JRadioButton();
		optAnswerFour = new JRadioButton();
		
		radioButtons = new ArrayList<JRadioButton>();
		radioButtons.add(optAnswerOne);
		radioButtons.add(optAnswerTwo);
		radioButtons.add(optAnswerThree);
		radioButtons.add(optAnswerFour);
		
		final ButtonGroup answerButtonGroup = new ButtonGroup();
		answerButtonGroup.add(optAnswerOne);
		answerButtonGroup.add(optAnswerTwo);
		answerButtonGroup.add(optAnswerThree);
		answerButtonGroup.add(optAnswerFour);
		    
		confirmAnswerButton = new JButton("Confirm Answer");
		confirmAnswerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				answer = answerButtonGroup.getSelection().getActionCommand();
				checkAnswer();
				WhereInTheWord.displayAnswerPanel();
				
			}
		});
		
		this.add(questionText);
		this.add(optAnswerOne);
		this.add(optAnswerTwo);
		this.add(optAnswerThree);
		this.add(optAnswerFour);
		this.add(confirmAnswerButton);
		
		generateNewQuestion();
		
	}

	public void generateNewQuestion() {
		
		Random randomizer = new Random();
		int correctIndex = randomizer.nextInt(4);
		
		for (int i=0;i<radioButtons.size();i++){
		    
			JRadioButton button = radioButtons.get(i);
			try {
				generateRandomScripture();
			}
			catch (IOException e) {
			    System.err.println("Caught IOException: " + e.getMessage());
			}
			
			if (i == correctIndex) {
				correctAnswer = randomReference;
				button.setText(correctAnswer);
				button.setActionCommand(correctAnswer);
				questionText.setText(randomText);
			}
			else {
				button.setText(randomReference);
			}
		}
	}
	public void generateRandomScripture() throws IOException {
		
		Random randomizer = new Random();
		int randomVerseIndex = randomizer.nextInt(WhereInTheWord.getTotalVerses()) + 1;
		
		String randomLine = WhereInTheWord.getAllLinesFromMasterFile().get(randomVerseIndex);
		String[] bookChapterVerseText = randomLine.split("\\|");
		randomBook = bookChapterVerseText[0];
		randomChapter = bookChapterVerseText[1];
		randomVerse = bookChapterVerseText[2];
		randomText = bookChapterVerseText[3];
		randomReference = randomBook + " " + randomChapter + ":" + randomVerse;
		
	}

	private void checkAnswer() {
		
		if (answer == correctAnswer ) {
			resultPhrase = "Correct!";
		} else {
			resultPhrase = "Incorrect!";
		}
		
	}
	
// Getters and Setters
	public ButtonGroup getAnswerButtonGroup() {
		return answerButtonGroup;
	}

	public JRadioButton getOptAnswerOne() {
		return optAnswerOne;
	}

	public void setOptAnswerOne(JRadioButton optAnswerOne) {
		this.optAnswerOne = optAnswerOne;
	}

	public JRadioButton getOptAnswerTwo() {
		return optAnswerTwo;
	}

	public void setOptAnswerTwo(JRadioButton optAnswerTwo) {
		this.optAnswerTwo = optAnswerTwo;
	}

	public JRadioButton getOptAnswerThree() {
		return optAnswerThree;
	}

	public void setOptAnswerThree(JRadioButton optAnswerThree) {
		this.optAnswerThree = optAnswerThree;
	}

	public JRadioButton getOptAnswerFour() {
		return optAnswerFour;
	}

	public void setOptAnswerFour(JRadioButton optAnswerFour) {
		this.optAnswerFour = optAnswerFour;
	}

	
	public String getResultPhrase() {
		return resultPhrase;
	}

	
	public void setResultPhrase(String resultPhrase) {
		this.resultPhrase = resultPhrase;
	}
	
	
	
}
