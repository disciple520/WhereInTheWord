package com.jerimiahwoods.whereintheword;

public class QuizzableItem {
	
	protected String text;
	protected String scriptureReference;
	
	
	public QuizzableItem() {
	}
	
	public QuizzableItem(String text, String scriptureReference) {
		
		this.text = text;
		this.scriptureReference = scriptureReference;
		
	}
	
	public String toString() {
		return text + " - " + scriptureReference;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
// *********Getters and Setters********* //
	
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
