package com.jerimiahwoods.whereintheword.controller;

import java.io.File;
import java.util.ArrayList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

import org.apache.xml.dtm.ref.DTMNodeList;
import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.pkg.OdfFileDom;
import org.w3c.dom.Node;

import com.jerimiahwoods.whereintheword.model.ChapterSummary;

public class ChapterSummaryLoader {

	final static String FILE_CONTAINING_CHAPTER_SUMMARIES   = "Chapter Summaries.ods";
	
	private static ArrayList<ChapterSummary> chapterSummaries;
	
	public static ArrayList<ChapterSummary> loadChapterSummaries() throws Exception {
		
	    DTMNodeList dataFromSummariesFile = readFromSummariesFile();
	    populateSummariesArray(dataFromSummariesFile);
	    
	    return chapterSummaries;
	    
	}
	
	public static DTMNodeList readFromSummariesFile() throws Exception {
		
		OdfDocument chapterSummariesSpreadsheet = OdfDocument.loadDocument(new File(FILE_CONTAINING_CHAPTER_SUMMARIES));
		OdfFileDom summariesContent = chapterSummariesSpreadsheet.getContentDom();
		XPath xpath = summariesContent.getXPath();
		DTMNodeList dataFromSummariesFile = (DTMNodeList) xpath.evaluate("//table:table-row/table:table-cell", summariesContent, XPathConstants.NODESET); //Reads empty cells after each row of data
		
		return dataFromSummariesFile;
	}
	
	public static void populateSummariesArray(DTMNodeList dataFromSummariesFile) {
		
		chapterSummaries =  new ArrayList<ChapterSummary>();
		String text = "";
		String scriptureReference = "";
	    
	    for (int i = 0; i < dataFromSummariesFile.getLength() - 4; i+=3) { //every third node is empty, as well as 4 nodes at EOF

	    	Node textNode = dataFromSummariesFile.item(i);
	    	text = textNode.getTextContent();
	    	
	    	Node scriptureReferenceNode = dataFromSummariesFile.item(i+1);
		    scriptureReference = scriptureReferenceNode.getTextContent();
		     	
		    ChapterSummary chapterSummary = new ChapterSummary(text, scriptureReference);
		    chapterSummaries.add(chapterSummary);
		        
	     }
	}
}
