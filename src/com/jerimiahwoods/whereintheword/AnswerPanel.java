package com.jerimiahwoods.whereintheword;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnswerPanel extends JPanel {
	
	private JLabel resultLabel;
	private JButton nextQuestionButton;
	private JButton quitButton;
	
	public AnswerPanel() {
		
		this.setBackground(Color.lightGray);
		
		resultLabel = new JLabel();
		nextQuestionButton = new JButton("Try Another Question");
		quitButton = new JButton("Quit to Main Menu");
		
		this.add(resultLabel);
		this.add(nextQuestionButton);
		this.add(quitButton);
		
		quitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				WhereInTheWord.displayDefaultPanel();
				
			}
		});
		
		nextQuestionButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				WhereInTheWord.displayQuestionPanel();
				
			}
		});
		
		
	}

// Getters and Setters
	public JLabel getResultLabel() {
		return resultLabel;
	}

}
