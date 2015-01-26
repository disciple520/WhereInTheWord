package com.jerimiahwoods.whereintheword.view;

import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.jerimiahwoods.whereintheword.controller.DataController;

public class UIManager {
	
	final static String HOME_PANEL                      = "Card to display main panel";
    final static String BIBLE_VERSE_QUESTION_PANEL      = "Card to display questions about bible verses";
    final static String CHAPTER_SUMMARY_QUESTION_PANEL  = "Card to display questions about chapter summaries";
    final static String ANSWER_PANEL                    = "Card to display answers";
    
    final public static String BIBLE_VERSE_QUIZ     = "Bible verse quiz type";
    final public static String CHAPTER_SUMMARY_QUIZ = "Chapter summary quiz type";
    
    private static String currentQuizType;
    
    private static CardLayout cardLayout;
    private static JPanel cardPanel;
    
    private static HomePanel homePanel;
	private static BibleVerseQuestionPanel bibleVerseQuestionPanel;
	private static ChapterSummaryQuestionPanel chapterSummaryQuestionPanel;
	private static AnswerPanel answerPanel;
    
    public static void buildUI(DataController dataController) {
		
		GUI gui    = new GUI();
		
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		
		homePanel                   = new HomePanel(dataController);
		bibleVerseQuestionPanel     = new BibleVerseQuestionPanel(dataController);
		chapterSummaryQuestionPanel = new ChapterSummaryQuestionPanel(dataController);
		answerPanel                 = new AnswerPanel(dataController);
		
		BoxLayout homeBoxLayout;
		homeBoxLayout = new BoxLayout(homePanel, BoxLayout.Y_AXIS);
		homePanel.setLayout(homeBoxLayout);
		
		BoxLayout answerBoxLayout;
		answerBoxLayout = new BoxLayout(answerPanel, BoxLayout.Y_AXIS);
		answerPanel.setLayout(answerBoxLayout);
		
		cardPanel.add(homePanel,                   HOME_PANEL);
		cardPanel.add(bibleVerseQuestionPanel,     BIBLE_VERSE_QUESTION_PANEL);
		cardPanel.add(chapterSummaryQuestionPanel, CHAPTER_SUMMARY_QUESTION_PANEL);
		cardPanel.add(answerPanel,                 ANSWER_PANEL);
		
		
		
		cardLayout.show(cardPanel, HOME_PANEL);
		
		gui.add(cardPanel);
		gui.setVisible(true);
		
	}
    
    public static void displayHomePanel() {
		
		cardLayout.show(cardPanel, HOME_PANEL);
		
	}
	
	public static void displayQuestionPanel() {
		
		if (currentQuizType == BIBLE_VERSE_QUIZ) {
			cardLayout.show(cardPanel, BIBLE_VERSE_QUESTION_PANEL);
			bibleVerseQuestionPanel.generateNewQuestion();
		} else if (currentQuizType == CHAPTER_SUMMARY_QUIZ) {
			cardLayout.show(cardPanel, CHAPTER_SUMMARY_QUESTION_PANEL);
			chapterSummaryQuestionPanel.generateNewQuestion();
		}
	}
	
	public static void displayAnswerPanel() {
		
		if (currentQuizType == BIBLE_VERSE_QUIZ) {
			answerPanel.getResultLabel().setText(bibleVerseQuestionPanel.getResultPhrase());
		} else if (currentQuizType == CHAPTER_SUMMARY_QUIZ) {
			answerPanel.getResultLabel().setText(chapterSummaryQuestionPanel.getResultPhrase());
		}
		
		cardLayout.show(cardPanel, ANSWER_PANEL);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
// *********Getters and Setters********* //
	public static CardLayout getCardLayout() {
		return cardLayout;
	}

	public static void setCardLayout(CardLayout cardLayout) {
		UIManager.cardLayout = cardLayout;
	}

	public static JPanel getCardPanel() {
		return cardPanel;
	}

	public static void setCardPanel(JPanel cardPanel) {
		UIManager.cardPanel = cardPanel;
	}

	public static HomePanel getHomePanel() {
		return homePanel;
	}

	public static void setHomePanel(HomePanel homePanel) {
		UIManager.homePanel = homePanel;
	}

	public static BibleVerseQuestionPanel getBibleVerseQuestionPanel() {
		return bibleVerseQuestionPanel;
	}

	public static void setBibleVerseQuestionPanel(BibleVerseQuestionPanel bibleVerseQuestionPanel) {
		UIManager.bibleVerseQuestionPanel = bibleVerseQuestionPanel;
	}

	public static ChapterSummaryQuestionPanel getChapterSummaryQuestionPanel() {
		return chapterSummaryQuestionPanel;
	}

	public static void setChapterSummaryQuestionPanel(ChapterSummaryQuestionPanel chapterSummaryQuestionPanel) {
		UIManager.chapterSummaryQuestionPanel = chapterSummaryQuestionPanel;
	}

	public static AnswerPanel getAnswerPanel() {
		return answerPanel;
	}

	public static void setAnswerPanel(AnswerPanel answerPanel) {
		UIManager.answerPanel = answerPanel;
	}

	public static String getWhichQuiz() {
		return currentQuizType;
	}

	public static void setCurrentQuizType(String currentQuizType) {
		UIManager.currentQuizType = currentQuizType;
	}
}
