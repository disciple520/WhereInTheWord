package com.jerimiahwoods.whereintheword;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel {

	final public String BIBLE_VERSE_QUIZ     = UIManager.BIBLE_VERSE_QUIZ;
	final public String CHAPTER_SUMMARY_QUIZ = UIManager.CHAPTER_SUMMARY_QUIZ;
	
	private JLabel  lblTitle;
	private JButton startBibleVerseQuizButton;
	private JButton startChapterSummaryQuizButton;
	private JButton quitButton;

	public HomePanel() {
		
		this.setBackground(Color.lightGray);
		lblTitle = new JLabel("Where in the Word?");
		lblTitle.setFont(new Font("Serif", Font.PLAIN, 30));
		
		startBibleVerseQuizButton = new JButton("Start Bible Verse Quiz");
		startBibleVerseQuizButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				UIManager.setCurrentQuizType(BIBLE_VERSE_QUIZ);
				UIManager.displayQuestionPanel();
				
			}
		});
		
		startChapterSummaryQuizButton = new JButton("Start ChapterSummary Quiz");
		startChapterSummaryQuizButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				UIManager.setCurrentQuizType(CHAPTER_SUMMARY_QUIZ);
				UIManager.displayQuestionPanel();
				
			}
		});
		
		quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		
		this.add(lblTitle);
		this.add(startBibleVerseQuizButton);
		this.add(startChapterSummaryQuizButton);
		this.add(quitButton);
		
	}
	
	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	public JButton getBtnStartQuiz() {
		return startBibleVerseQuizButton;
	}

	public void setBtnStartQuiz(JButton btnStartQuiz) {
		this.startBibleVerseQuizButton = btnStartQuiz;
	}

}
