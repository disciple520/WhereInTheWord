package com.jerimiahwoods.whereintheword.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jerimiahwoods.whereintheword.controller.DataController;

public class AnswerPanel extends JPanel {
	
	@SuppressWarnings("unused")
	private DataController dataController;
	
	private JLabel  resultLabel;
	private JButton nextQuestionButton;
	private JButton quitButton;
	
	public AnswerPanel(DataController dataController) {
		
		this.dataController = new DataController();
		this.dataController = dataController;
		
		this.setBackground(Color.lightGray);
		
		resultLabel        = new JLabel();
		resultLabel.setFont(new Font("Serif", Font.BOLD, 30));
		
		nextQuestionButton = new JButton("Next Question");
		quitButton         = new JButton("Quit to Main Menu");
		
		resultLabel.       setAlignmentX(Component.CENTER_ALIGNMENT);
		nextQuestionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitButton.        setAlignmentX(Component.CENTER_ALIGNMENT);
		
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
	
	public void setDataController(DataController dataController) {
		this.dataController = dataController;
	}
	
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
