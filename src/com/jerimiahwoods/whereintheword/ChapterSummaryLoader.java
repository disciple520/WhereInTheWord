package com.jerimiahwoods.whereintheword;

import java.io.File;
import java.util.ArrayList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

import org.apache.xml.dtm.ref.DTMNodeList;
import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.pkg.OdfFileDom;
import org.w3c.dom.Node;

public class ChapterSummaryLoader {

	final static String FILE_CONTAINING_CHAPTER_SUMMARIES   = "Chapter Summaries.ods";
	
	private static ArrayList<ChapterSummary> chapterSummaries;
	
	public ArrayList<ChapterSummary> loadChapterSummaries() throws Exception {
		
	    DTMNodeList dataFromSummariesFile = readFromSummariesFile();
	    populateSummariesArray(dataFromSummariesFile);
	    
	    return chapterSummaries;
	    
	}
	
	public static DTMNodeList readFromSummariesFile() throws Exception {
		
		// Using ODFToolkit //
		OdfDocument chapterSummariesSpreadsheet = OdfDocument.loadDocument(new File(FILE_CONTAINING_CHAPTER_SUMMARIES));
		OdfFileDom summariesContent = chapterSummariesSpreadsheet.getContentDom();
		XPath xpath = summariesContent.getXPath();
		DTMNodeList dataFromSummariesFile = (DTMNodeList) xpath.evaluate("//table:table-row/table:table-cell", summariesContent, XPathConstants.NODESET); //Reads empty cells after each row of data
		
		return dataFromSummariesFile;
	}
	
	public static void populateSummariesArray(DTMNodeList dataFromSummariesFile) {
		
		chapterSummaries =  new ArrayList<ChapterSummary>();
		String scriptureReference = "";
		String text = "";
		Boolean contentsOfDataItemIsScriptureReference = true;
	    
	    for (int i = 0; i < dataFromSummariesFile.getLength(); i++) {
	    	
	    	Node singleItemFromDataFile = dataFromSummariesFile.item(i);
		    String contentsOfDataItem = singleItemFromDataFile.getTextContent();
	        if (!singleItemFromDataFile.getTextContent().isEmpty()) { 
	        	
	        	contentsOfDataItemIsScriptureReference = !contentsOfDataItemIsScriptureReference; //Each alternating item is a Scripture Reference
	        	
		        if (contentsOfDataItemIsScriptureReference) {
		           	scriptureReference = contentsOfDataItem;
		        } 
		        else if (!contentsOfDataItemIsScriptureReference){
		        	text = contentsOfDataItem;
		            ChapterSummary chapterSummary = new ChapterSummary(scriptureReference, text);
		            chapterSummaries.add(chapterSummary);
		        }
	        }
		}
	}
	
}
