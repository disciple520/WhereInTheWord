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
	private JButton startQuizButton;
	private JButton quitButton;

	public DefaultPanel() {
		
		this.setBackground(Color.lightGray);
		lblTitle = new JLabel("Where in the Word?");
		lblTitle.setFont(new Font("Serif", Font.PLAIN, 30));
		
		startQuizButton = new JButton("Start Quiz");
		startQuizButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				WhereInTheWord.displayQuestionPanel();
				
			}
		});
		
		this.add(lblTitle);
		this.add(startQuizButton);
		
	}
	
	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	public JButton getBtnStartQuiz() {
		return startQuizButton;
	}

	public void setBtnStartQuiz(JButton btnStartQuiz) {
		this.startQuizButton = btnStartQuiz;
	}

}
