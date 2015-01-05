package com.jerimiahwoods.whereintheword;

import java.awt.CardLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class WhereInTheWord {

	final static String DEFAULTPANEL = "Card to display welcome panel";
    final static String QUESTIONPANEL    = "Card to display quiz questions";
    final static String ANSWERPANEL  = "Card to display quiz answers";
    
    private static CardLayout cardLayout;
    
    private static JPanel cardPanel;
    private static DefaultPanel defaultPanel;
	private static QuestionPanel questionPanel;
	private static AnswerPanel answerPanel;
	
	private static ArrayList<String> allLinesFromMasterFile;
	private static int totalVerses;
    
	public static void main(String[] args) {
	
		try {
			loadData();	
		}
		catch (IOException e) {
		    System.err.println("Caught IOException: " + e.getMessage());
		}
		
		buildUI();
		
	}

	public static void loadData() throws IOException {
		
		FileReader fileReader = new FileReader("Master Verse List");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		allLinesFromMasterFile = new ArrayList<String>();
		
		String line;
		totalVerses = 0;
		while ((line = bufferedReader.readLine()) != null) {
			allLinesFromMasterFile.add(line);
			totalVerses++;
		}
		
		bufferedReader.close();
		 
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
	
	public static void displayAnswerPanel() {
		
		answerPanel.getResultLabel().setText(questionPanel.getResultPhrase());
		cardLayout.show(cardPanel, ANSWERPANEL);
		
	}

	// Getters and Setters
	public static JPanel getCardPanel() {
		return cardPanel;
	}
	
	public static CardLayout getCardLayout() {
		return cardLayout;
	}

	
	public static ArrayList<String> getAllLinesFromMasterFile() {
		return allLinesFromMasterFile;
	}

	
	public static void setAllLinesFromMasterFile(
			ArrayList<String> allLinesFromMasterFile) {
		WhereInTheWord.allLinesFromMasterFile = allLinesFromMasterFile;
	}

	public static int getTotalVerses() {
		return totalVerses;
	}

	public static void setTotalVerses(int totalVerses) {
		
		WhereInTheWord.totalVerses = totalVerses;
	}

	
	public static QuestionPanel getQuestionPanel() {
		return questionPanel;
	}

	
	public static void setQuestionPanel(QuestionPanel questionPanel) {
		WhereInTheWord.questionPanel = questionPanel;
	}
	
}
