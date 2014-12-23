package com.jerimiahwoods.whereintheword;

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

	public DefaultPanel() {
		
		lblTitle = new JLabel("Where in the Word?");
		lblTitle.setFont(new Font("Serif", Font.PLAIN, 30));
		
		startQuizButton = new JButton("Start Quiz");
		ListenForBtnStartQuiz listenForBtnStartQuiz = new ListenForBtnStartQuiz();
		startQuizButton.addActionListener(listenForBtnStartQuiz);
		
		this.add(lblTitle);
		this.add(startQuizButton);
		
	}
	
	private class ListenForBtnStartQuiz implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			WhereInTheWord.startQuiz();
			//WhereInTheWord.getCl().show(WhereInTheWord.getCardPanel(), WhereInTheWord.QUIZPANEL);
			
		}
		
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
