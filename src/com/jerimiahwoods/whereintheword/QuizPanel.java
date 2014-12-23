package com.jerimiahwoods.whereintheword;

import javax.swing.*;


public class QuizPanel extends JPanel {

	private JLabel lblQuestion;
	private JRadioButton optAnswerOne;
	private JRadioButton optAnswerTwo;
	private JRadioButton optAnswerThree;
	private JRadioButton optAnswerFour;
	
	public QuizPanel() {
		
		lblQuestion = new JLabel("For God so loved the world he gave his only begotten son that whoever would believe in him should not perish but have eternal life");
		optAnswerOne = new JRadioButton("Revelation 9:9");
		optAnswerTwo = new JRadioButton("John 3:16");
		optAnswerThree = new JRadioButton("Hebrews 6:23");
		optAnswerFour = new JRadioButton("Exodus 22:11");
		ButtonGroup group = new ButtonGroup();
		
		group.add(optAnswerOne);
		group.add(optAnswerTwo);
		group.add(optAnswerThree);
		group.add(optAnswerFour);
		
		this.add(lblQuestion);
		this.add(optAnswerOne);
		this.add(optAnswerTwo);
		this.add(optAnswerThree);
		this.add(optAnswerFour);
		
	}
	
}
