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

	final static String DEFAULTPANEL = "Card to display welcome panel";
    final static String SCRIPTUREQUESTIONPANEL    = "Card to display quiz questions about specific verses";
    final static String SUMMARYQUESTIONPANEL = "Card to display quiz question about chapter summaries";
    final static String ANSWERPANEL  = "Card to display quiz answers";
    
    private static CardLayout cardLayout;
    
    private static JPanel cardPanel;
    private static DefaultPanel defaultPanel;
	private static QuestionPanel scriptureQuestionPanel;
	private static QuestionPanel summaryQuestionPanel;
	private static AnswerPanel answerPanel;
	
	private static String whichQuiz = "Scripture Quiz";
	
	private static ArrayList<String> allLinesFromMasterFile;
	private static int totalVerses;

	private static ArrayList<ChapterSummary> summaries;
    
	public static void main(String[] args) {
	
		try {
			loadData();	
		}
		catch (IOException e) {
		    System.err.println("Caught IOException: " + e.getMessage());
		}
		catch (Exception e) {
			System.err.println("Caught Exception: " + e.getMessage());
		}
		
		buildUI();
		
	}

	public static void loadData() throws Exception {
		
		FileReader verseReader = new FileReader("Master Verse List");
		BufferedReader bufferedReader = new BufferedReader(verseReader);
		
		allLinesFromMasterFile = new ArrayList<String>();
		
		String line;
		totalVerses = 0;
		while ((line = bufferedReader.readLine()) != null) {
			allLinesFromMasterFile.add(line);
			totalVerses++;
		}
		
		FileReader summaryReader = new FileReader("Chapter Summary Spreadsheet.ods");
		bufferedReader = new BufferedReader(summaryReader);
	
		bufferedReader.close();
		verseReader.close();
	
		try {
			OdfDocument chapterSummariesSpreadsheet = OdfDocument.loadDocument(new File("Chapter Summary Spreadsheet.ods"));
			OdfFileDom summariesContent = chapterSummariesSpreadsheet.getContentDom();
			XPath xpath = summariesContent.getXPath();
		    DTMNodeList nodeList = (DTMNodeList) xpath.evaluate("//table:table-row/table:table-cell", summariesContent, XPathConstants.NODESET);
		    String chapter = "";
		    String text = "";
		    summaries =  new ArrayList<ChapterSummary>();
		    Boolean isChapterReference = false;
		    for (int i = 0; i < nodeList.getLength(); i++) {
		        Node cell = nodeList.item(i);
		        String cellContents = cell.getTextContent();
		        if (!cell.getTextContent().isEmpty()) {
		        	isChapterReference = !isChapterReference;
		            if (isChapterReference) {
		            	chapter = cellContents;
		            } 
		            else {
		            	text = cellContents;
		            	ChapterSummary summary = new ChapterSummary(chapter, text);
		            	summaries.add(summary);
		            }
		        }
		    }
		} catch (Exception ex) {
		        System.out.println(ex.getMessage());
		}
	}


	
	public static void buildUI() {
		
		GUI gui = new GUI();
		
		
		cardLayout = new CardLayout();
		cardPanel  = new JPanel(cardLayout);
		
		defaultPanel           = new DefaultPanel();
		scriptureQuestionPanel = new ScriptureQuestionPanel();
		summaryQuestionPanel   = new SummaryQuestionPanel();
		answerPanel            = new AnswerPanel();
		
		cardPanel.add(defaultPanel,           DEFAULTPANEL);
		cardPanel.add(scriptureQuestionPanel, SCRIPTUREQUESTIONPANEL);
		cardPanel.add(summaryQuestionPanel,   SUMMARYQUESTIONPANEL);
		cardPanel.add(answerPanel,            ANSWERPANEL);
		
		cardLayout.show(cardPanel,            DEFAULTPANEL);
		
		gui.add(cardPanel);
		gui.setVisible(true);
		
	}
	
	public static void displayDefaultPanel() {
		
		cardLayout.show(cardPanel, DEFAULTPANEL);
		
	}
	
	public static void displayQuestionPanel() {
		
		if (whichQuiz == "Scripture Quiz") {
			cardLayout.show(cardPanel, SCRIPTUREQUESTIONPANEL);
			scriptureQuestionPanel.generateNewQuestion();
		} else if (whichQuiz == "Summary Quiz") {
			cardLayout.show(cardPanel, SUMMARYQUESTIONPANEL);
			summaryQuestionPanel.generateNewQuestion();
		}
	}
	
	public static void displayAnswerPanel() {
		
		if (whichQuiz == "Scripture Quiz") {
			answerPanel.getResultLabel().setText(scriptureQuestionPanel.getResultPhrase());
		} else if (whichQuiz == "Summary Quiz") {
			answerPanel.getResultLabel().setText(summaryQuestionPanel.getResultPhrase());
		}
		
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
		return scriptureQuestionPanel;
	}

	
	public static void setQuestionPanel(ScriptureQuestionPanel scriptureQuestionPanel) {
		WhereInTheWord.scriptureQuestionPanel = scriptureQuestionPanel;
	}
	
	public static QuestionPanel getScriptureQuestionPanel() {
		return scriptureQuestionPanel;
	}
	
	public static ArrayList<ChapterSummary> getSummaries() {
		return summaries;
	}
	
	public static String getWhichQuiz() {
		return whichQuiz;
	}
	
	public static void setWhichQuiz(String quizType) {
		whichQuiz = quizType;
	}
	
}
