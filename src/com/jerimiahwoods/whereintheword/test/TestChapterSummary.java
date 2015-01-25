package com.jerimiahwoods.whereintheword.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jerimiahwoods.whereintheword.ChapterSummary;

public class TestChapterSummary {

	private final String TEST_SUMMARY   = "Jesus was flogged and crucified, then he died.";
	private final String TEST_REFERENCE = "John 19";
	
	@Test
	public void toStringMethodShouldFunctionProperly() {
		
		ChapterSummary chapterSummary = new ChapterSummary(TEST_SUMMARY, TEST_REFERENCE);
		
		assertEquals(chapterSummary.toString(), "Jesus was flogged and crucified, then he died. (John 19)");
		
	}
	
	@Test
	public void twoArgConstructorShouldCorrectlyCreateObject() {
		
		ChapterSummary chapterSummary = new ChapterSummary(TEST_SUMMARY, TEST_REFERENCE);
		
		assertEquals(chapterSummary.getText(), TEST_SUMMARY);
		assertEquals(chapterSummary.getScriptureReference(), TEST_REFERENCE);
		
	}

}
