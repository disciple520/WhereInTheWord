package com.jerimiahwoods.whereintheword;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class QuestionPanel extends JPanel {

	String answer = "";
	String correctAnswer = "";
	String resultPhrase = "";
	
	JTextArea questionText;
	ArrayList<JRadioButton> radioButtons;
	JRadioButton optAnswerOne;
	JRadioButton optAnswerTwo;
	JRadioButton optAnswerThree;
	JRadioButton optAnswerFour;
	ButtonGroup answerButtonGroup;
	JButton confirmAnswerButton;
	
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
		    
		confirmAnswerButton = new JButton("Confirm Answer");
		
		this.add(questionText);
		this.add(optAnswerOne);
		this.add(optAnswerTwo);
		this.add(optAnswerThree);
		this.add(optAnswerFour);
		this.add(confirmAnswerButton);
	}
	
	public void checkAnswer() {
		
		System.out.println("You answered " + answer);
		System.out.println("The correct Answer was " + correctAnswer);
		
		if (answer == correctAnswer ) {
			resultPhrase = "Correct!";
		} else {
			resultPhrase = "Incorrect!";
		}
		
	}
	
	public void generateNewQuestion() {
		
	}
	
	public void generateRandomAnswer() {
		
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
