package com.jerimiahwoods.whereintheword;

import java.awt.CardLayout;

import javax.swing.*;

public class WhereInTheWord {

	final static String DEFAULTPANEL = "Default card";
    final static String QUIZPANEL    = "Card to display quiz questions";
    
	public static void main(String[] args) {
	
		buildUI();
		
	}

	public static void buildUI() {
		
		GUI gui = new GUI();
		JPanel cardPanel = new JPanel(new CardLayout());
		DefaultPanel defaultPanel = new DefaultPanel();
		QuizPanel quizPanel = new QuizPanel();
		CardLayout cl = new CardLayout();
		
		cardPanel.setLayout(cl);
		cardPanel.add(defaultPanel, DEFAULTPANEL);
		cardPanel.add(quizPanel, QUIZPANEL);	
		cl.show(cardPanel, DEFAULTPANEL);
		gui.add(cardPanel);
		gui.setVisible(true);
		
	}
}
