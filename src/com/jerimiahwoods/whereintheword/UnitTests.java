package com.jerimiahwoods.whereintheword;

import org.junit.Test;

public class UnitTests {

	@Test
	public void guiWindowIsCreated() {
		//given
		GUI gui = new GUI();
		
		//then
		assert gui != null;
		
	}

	@Test
	public void panelIsConstructedProperly() {
		
		//given
		HomePanel panel = new HomePanel();
		
		//then
		assert panel.isVisible();
		assert panel.getLblTitle().getParent() == panel;
		assert panel.getBtnStartQuiz().getParent() == panel;
		
	}
}
