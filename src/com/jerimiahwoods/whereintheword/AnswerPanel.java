package com.jerimiahwoods.whereintheword;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnswerPanel extends JPanel {
	
	private JLabel resultLabel;
	
	public AnswerPanel() {
		
		resultLabel = new JLabel();
		this.add(resultLabel);

	}

	public JLabel getResultLabel() {
		return resultLabel;
	}

}
