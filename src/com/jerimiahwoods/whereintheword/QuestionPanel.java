package com.jerimiahwoods.whereintheword;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class QuestionPanel extends JPanel {

	private String jn3_16 = "For God so loved the world he gave his only begotten son that whoever would believe in him should not perish but have eternal life";

	private JTextArea questionText;
	private JRadioButton optAnswerOne;
	private JRadioButton optAnswerTwo;
	private JRadioButton optAnswerThree;
	private JRadioButton optAnswerFour;
	private ButtonGroup answerButtonGroup;
	private JButton confirmAnswerButton;
	
	public QuestionPanel() {
		
		this.setBackground(Color.lightGray);
		
		questionText = new JTextArea(1,40);
		questionText.setText("Where is the verse \"" + jn3_16 + "\" located?");
		questionText.setLineWrap(true);
		questionText.setWrapStyleWord(true);
		questionText.setBackground(Color.lightGray);
		
		optAnswerOne = new JRadioButton("Revelation 9:9");
		optAnswerTwo = new JRadioButton("John 3:16");
		optAnswerThree = new JRadioButton("Hebrews 6:23", true);
		optAnswerFour = new JRadioButton("Exodus 22:11");
		
		ButtonGroup answerButtonGroup = new ButtonGroup();
		answerButtonGroup.add(optAnswerOne);
		answerButtonGroup.add(optAnswerTwo);
		answerButtonGroup.add(optAnswerThree);
		answerButtonGroup.add(optAnswerFour);
		
		confirmAnswerButton = new JButton("Confirm Answer");
		confirmAnswerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				WhereInTheWord.checkAnswer();
				WhereInTheWord.displayAnswerPanel();
				
			}
		});
		
		this.add(questionText);
		this.add(optAnswerOne);
		this.add(optAnswerTwo);
		this.add(optAnswerThree);
		this.add(optAnswerFour);
		this.add(confirmAnswerButton);
		
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
	
	
	
}
