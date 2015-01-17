package com.jerimiahwoods.whereintheword;

public class QuizzableItem {
	
	protected String scriptureReference;
	protected String text;
	
	public QuizzableItem() {
		
	}
	
	public QuizzableItem(String scriptureReference, String text) {
		
		this.scriptureReference = scriptureReference;
		this.text = text;
		
	}

	public String getScriptureReference() {
		return scriptureReference;
	}

	public void setScriptureReference(String scriptureReference) {
		this.scriptureReference = scriptureReference;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
