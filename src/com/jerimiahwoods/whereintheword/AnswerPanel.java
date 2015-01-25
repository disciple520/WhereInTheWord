package com.jerimiahwoods.whereintheword;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnswerPanel extends JPanel {
	
	private JLabel  resultLabel;
	private JButton nextQuestionButton;
	private JButton quitButton;
	
	public AnswerPanel() {
		
		this.setBackground(Color.lightGray);
		
		resultLabel        = new JLabel();
		nextQuestionButton = new JButton("Next Question");
		quitButton         = new JButton("Quit to Main Menu");
		
		this.add(resultLabel);
		this.add(nextQuestionButton);
		this.add(quitButton);
		
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {UIManager.displayHomePanel();}
		});
		
		nextQuestionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {UIManager.displayQuestionPanel();}
		});
	}
	
	
	
	

	
	
	
	
	
	
// *********Getters and Setters********* //
	
	public JLabel getResultLabel() {
		return resultLabel;
	}

	public void setResultLabel(JLabel resultLabel) {
		this.resultLabel = resultLabel;
	}

	public JButton getNextQuestionButton() {
		return nextQuestionButton;
	}

	public void setNextQuestionButton(JButton nextQuestionButton) {
		this.nextQuestionButton = nextQuestionButton;
	}

	public JButton getQuitButton() {
		return quitButton;
	}

	public void setQuitButton(JButton quitButton) {
		this.quitButton = quitButton;
	}


	

}
