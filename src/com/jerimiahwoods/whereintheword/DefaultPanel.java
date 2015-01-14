package com.jerimiahwoods.whereintheword;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jerimiahwoods.whereintheword.WhereInTheWord;

public class DefaultPanel extends JPanel {

	private JLabel lblTitle;
	private JButton startScriptureQuizButton;
	private JButton startSummaryQuizButton;
	private JButton quitButton;

	public DefaultPanel() {
		
		this.setBackground(Color.lightGray);
		lblTitle = new JLabel("Where in the Word?");
		lblTitle.setFont(new Font("Serif", Font.PLAIN, 30));
		
		startScriptureQuizButton = new JButton("Start Scripture Quiz");
		startScriptureQuizButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				WhereInTheWord.setWhichQuiz("Scripture Quiz");
				WhereInTheWord.displayQuestionPanel();
				
			}
		});
		
		startSummaryQuizButton = new JButton("Start Summary Quiz");
		startSummaryQuizButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				WhereInTheWord.setWhichQuiz("Summary Quiz");
				WhereInTheWord.displayQuestionPanel();
				
			}
		});
		
		quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		
		this.add(lblTitle);
		this.add(startScriptureQuizButton);
		this.add(startSummaryQuizButton);
		this.add(quitButton);
		
	}
	
	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	public JButton getBtnStartQuiz() {
		return startScriptureQuizButton;
	}

	public void setBtnStartQuiz(JButton btnStartQuiz) {
		this.startScriptureQuizButton = btnStartQuiz;
	}

}
