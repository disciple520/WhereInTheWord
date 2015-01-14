package com.jerimiahwoods.whereintheword;

import java.awt.CardLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.doc.OdfTextDocument;
import org.odftoolkit.odfdom.pkg.OdfFileDom;
import org.w3c.dom.Node;
import org.apache.xml.dtm.ref.DTMNodeList;

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

	private static Map<String, String> summaries;
    
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
		
		for(Map.Entry<String, String> entry : summaries.entrySet()) {
			System.out.println(entry.getKey() + "/" + entry.getValue());
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
		    summaries = new HashMap<String, String>();
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
		            	summaries.put(chapter, text);
		            }
		        }
		    }
		} catch (Exception ex) {
		        System.out.println(ex.getMessage());
		}
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
