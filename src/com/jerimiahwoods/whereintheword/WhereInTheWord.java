package com.jerimiahwoods.whereintheword;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.*;

public class WhereInTheWord {

	final static String DEFAULTPANEL = "Card to display welcome panel";
    final static String QUIZPANEL    = "Card to display quiz question";
    final static String ANSWERPANEL  = "Card to display quiz answer";
    
    static String result = "";
    
    private static CardLayout cl;
    private static JPanel cardPanel;
    private static DefaultPanel defaultPanel;
	private static QuestionPanel questionPanel;
	private static AnswerPanel answerPanel;
    
	public static void main(String[] args) {
	
		buildUI();
		
	}

	public static void buildUI() {
		
		GUI gui = new GUI();
		
		
		cl = new CardLayout();
		cardPanel     = new JPanel(cl);
		defaultPanel  = new DefaultPanel();
		questionPanel = new QuestionPanel();
		answerPanel   = new AnswerPanel();
		
		defaultPanel.setBackground(Color.lightGray);
		questionPanel.setBackground(Color.lightGray);
		
		cardPanel.setLayout(cl);
		cardPanel.add(defaultPanel,  DEFAULTPANEL);
		cardPanel.add(questionPanel, QUIZPANEL);
		cardPanel.add(answerPanel,   ANSWERPANEL);
		
		cl.show(cardPanel, DEFAULTPANEL);
		
		gui.add(cardPanel);
		gui.setVisible(true);
		
	}
	
	public static void startQuiz() {
		
		cl.show(cardPanel, QUIZPANEL);
		
	}
	
	public static void checkAnswer() {
		
		if ( questionPanel.getOptAnswerTwo().isSelected() == true) {
			result = "Correct!";
		} else {
			result = "Incorrect!";
		}
	
		
	}
	
	public static void displayAnswer() {
		
		answerPanel.getResultLabel().setText(result);
		cl.show(cardPanel, ANSWERPANEL);
		
	}

	public static JPanel getCardPanel() {
		return cardPanel;
	}
	
	public static CardLayout getCl() {
		
		return cl;
		
	}
	
	
}
