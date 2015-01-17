package com.jerimiahwoods.whereintheword;

import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.pkg.OdfFileDom;
import org.w3c.dom.Node;
import org.apache.xml.dtm.ref.DTMNodeList;

public class WhereInTheWord {

	final static String FILE_CONTAINING_BIBLE_VERSES        = "Bible Verses";
	final static String FILE_CONTAINING_CHAPTER_SUMMARIES   = "Chapter Summaries.ods";
	
	final static String HOME_PANEL                      = "Card to display main panel";
    final static String BIBLE_VERSE_QUESTION_PANEL      = "Card to display questions about bible verses";
    final static String CHAPTER_SUMMARY_QUESTION_PANEL  = "Card to display questions about chapter summaries";
    final static String ANSWER_PANEL                    = "Card to display answers";
    
    final public static String BIBLE_VERSE_QUIZ     = "Bible verse quiz type";
    final public static String CHAPTER_SUMMARY_QUIZ = "Chapter summary quiz type";
    
    private static CardLayout cardLayout;
    
    private static JPanel                      cardPanel;
    private static HomePanel                   homePanel;
	private static BibleVerseQuestionPanel     bibleVerseQuestionPanel;
	private static ChapterSummaryQuestionPanel chapterSummaryQuestionPanel;
	private static AnswerPanel                 answerPanel;
	
	private static String currentQuizType = "Bible Verse Quiz";
	
	private static ArrayList<BibleVerse>     bibleVerses;
	private static ArrayList<ChapterSummary> chapterSummaries;
    
	public static void main(String[] args) throws Exception {
	
		loadData();
		buildUI();
		
	}

	public static void loadData() throws Exception {
		
		loadBibleVerses();
		loadChapterSummaries();
	
	}

	public static void loadBibleVerses() throws IOException {
		
		bibleVerses = new ArrayList<BibleVerse>();
		
		FileReader verseReader = new FileReader(FILE_CONTAINING_BIBLE_VERSES);
		BufferedReader bufferedReader = new BufferedReader(verseReader);
		
		String lineFromBibleVerseFile = "";    
		while ((lineFromBibleVerseFile = bufferedReader.readLine()) != null) {
			
			String[] bibleVerseElements = lineFromBibleVerseFile.split("\\|");
			String book = bibleVerseElements[0];
			String chapter = bibleVerseElements[1];
			String verseNumber = bibleVerseElements[2];
			String text = bibleVerseElements[3];
			
			bibleVerses.add(new BibleVerse(book, chapter, verseNumber, text));
		}
		
		bufferedReader.close();
		
	}
	
	public static void loadChapterSummaries() throws Exception {
	
	    DTMNodeList dataFromSummariesFile = readFromSummariesFile();
	    populateSummariesArray(dataFromSummariesFile);
	    
	}
	
	public static DTMNodeList readFromSummariesFile() throws Exception {
		
		// Using ODFToolkit //
		OdfDocument chapterSummariesSpreadsheet = OdfDocument.loadDocument(new File(FILE_CONTAINING_CHAPTER_SUMMARIES));
		OdfFileDom summariesContent = chapterSummariesSpreadsheet.getContentDom();
		XPath xpath = summariesContent.getXPath();
		DTMNodeList nodeList = (DTMNodeList) xpath.evaluate("//table:table-row/table:table-cell", summariesContent, XPathConstants.NODESET); //Reads empty cells after each row of data
		
		return nodeList;
	}
	
	public static void populateSummariesArray(DTMNodeList nodeList) {
		
		String scriptureReference = "";
		String text = "";
		chapterSummaries =  new ArrayList<ChapterSummary>();
		Boolean nodeContainsScriptureReference = false;
	    
	    for (int i = 0; i < nodeList.getLength(); i++) {
	    	
	    	Node node = nodeList.item(i);
		    String nodeContent = node.getTextContent();
	        if (!node.getTextContent().isEmpty()) { 
	        	
	        	nodeContainsScriptureReference = !nodeContainsScriptureReference;
	        	
		        if (nodeContainsScriptureReference) {
		           	scriptureReference = nodeContent;
		        } 
		        else if (!nodeContainsScriptureReference){
		        	text = nodeContent;
		            ChapterSummary chapterSummary = new ChapterSummary(scriptureReference, text);
		            chapterSummaries.add(chapterSummary);
		        }
	        }
		}
	}
	
	public static void buildUI() {
		
		GUI gui = new GUI();
			
		cardLayout = new CardLayout();
		cardPanel  = new JPanel(cardLayout);
		
		homePanel                   = new HomePanel();
		bibleVerseQuestionPanel     = new BibleVerseQuestionPanel();
		chapterSummaryQuestionPanel = new ChapterSummaryQuestionPanel();
		answerPanel                 = new AnswerPanel();
		
		cardPanel.add(homePanel,                   HOME_PANEL);
		cardPanel.add(bibleVerseQuestionPanel,     BIBLE_VERSE_QUESTION_PANEL);
		cardPanel.add(chapterSummaryQuestionPanel, CHAPTER_SUMMARY_QUESTION_PANEL);
		cardPanel.add(answerPanel,                 ANSWER_PANEL);
		
		cardLayout.show(cardPanel, HOME_PANEL);
		
		gui.add(cardPanel);
		gui.setVisible(true);
		
	}
	
	public static void displayDefaultPanel() {
		
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
		WhereInTheWord.cardLayout = cardLayout;
	}

	public static JPanel getCardPanel() {
		return cardPanel;
	}

	public static void setCardPanel(JPanel cardPanel) {
		WhereInTheWord.cardPanel = cardPanel;
	}

	public static HomePanel getHomePanel() {
		return homePanel;
	}

	public static void setHomePanel(HomePanel homePanel) {
		WhereInTheWord.homePanel = homePanel;
	}

	public static BibleVerseQuestionPanel getBibleVerseQuestionPanel() {
		return bibleVerseQuestionPanel;
	}

	public static void setBibleVerseQuestionPanel(BibleVerseQuestionPanel bibleVerseQuestionPanel) {
		WhereInTheWord.bibleVerseQuestionPanel = bibleVerseQuestionPanel;
	}

	public static ChapterSummaryQuestionPanel getChapterSummaryQuestionPanel() {
		return chapterSummaryQuestionPanel;
	}

	public static void setChapterSummaryQuestionPanel(ChapterSummaryQuestionPanel chapterSummaryQuestionPanel) {
		WhereInTheWord.chapterSummaryQuestionPanel = chapterSummaryQuestionPanel;
	}

	public static AnswerPanel getAnswerPanel() {
		return answerPanel;
	}

	public static void setAnswerPanel(AnswerPanel answerPanel) {
		WhereInTheWord.answerPanel = answerPanel;
	}

	public static String getWhichQuiz() {
		return currentQuizType;
	}

	public static void setCurrentQuizType(String currentQuizType) {
		WhereInTheWord.currentQuizType = currentQuizType;
	}

	public static ArrayList<BibleVerse> getBibleVerses() {
		return bibleVerses;
	}

	public static void setBibleVerses(ArrayList<BibleVerse> bibleVerses) {
		WhereInTheWord.bibleVerses = bibleVerses;
	}

	public static ArrayList<ChapterSummary> getChapterSummaries() {
		return chapterSummaries;
	}

	public static void setChapterSummaries(ArrayList<ChapterSummary> chapterSummaries) {
		WhereInTheWord.chapterSummaries = chapterSummaries;
	}


	
	
}
