package com.jerimiahwoods.whereintheword;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.*;

public class WhereInTheWord {

	final static String DEFAULTPANEL = "Card to display welcome panel";
    final static String QUESTIONPANEL    = "Card to display quiz questions";
    final static String ANSWERPANEL  = "Card to display quiz answers";
    
    static String result = "";
    
    private static CardLayout cardLayout;
    
    private static JPanel cardPanel;
    private static DefaultPanel defaultPanel;
	private static QuestionPanel questionPanel;
	private static AnswerPanel answerPanel;
    
	public static void main(String[] args) {
	
		buildUI();
		
	}

	public static void buildUI() {
		
		GUI gui = new GUI();
		
		
		cardLayout    = new CardLayout();
		
		cardPanel     = new JPanel(cardLayout);
		defaultPanel  = new DefaultPanel();
		questionPanel = new QuestionPanel();
		answerPanel   = new AnswerPanel();
		
		cardPanel.add(defaultPanel,  DEFAULTPANEL);
		cardPanel.add(questionPanel, QUESTIONPANEL);
		cardPanel.add(answerPanel,   ANSWERPANEL);
		
		cardLayout.show(cardPanel, DEFAULTPANEL);
		
		gui.add(cardPanel);
		gui.setVisible(true);
		
	}
	
	public static void displayDefaultPanel() {
		
		cardLayout.show(cardPanel, DEFAULTPANEL);
		
	}
	
	public static void displayQuestionPanel() {
		
		cardLayout.show(cardPanel, QUESTIONPANEL);
		
	}
	
	public static void checkAnswer() {
		
		if ( questionPanel.getOptAnswerTwo().isSelected() == true) {
			result = "Correct!";
		} else {
			result = "Incorrect!";
		}
		
	}
	
	public static void displayAnswerPanel() {
		
		answerPanel.getResultLabel().setText(result);
		cardLayout.show(cardPanel, ANSWERPANEL);
		
	}

	// Getters and Setters
	public static JPanel getCardPanel() {
		return cardPanel;
	}
	
	public static CardLayout getCardLayout() {
		return cardLayout;
	}
	
	
}
