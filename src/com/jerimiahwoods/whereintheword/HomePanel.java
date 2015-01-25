package com.jerimiahwoods.whereintheword;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jerimiahwoods.whereintheword.WhereInTheWord;

public class HomePanel extends JPanel {

	final public String BIBLE_VERSE_QUIZ = WhereInTheWord.BIBLE_VERSE_QUIZ;
	final public String CHAPTER_SUMMARY_QUIZ = WhereInTheWord.CHAPTER_SUMMARY_QUIZ;
	
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
				
				WhereInTheWord.setCurrentQuizType(BIBLE_VERSE_QUIZ);
				WhereInTheWord.displayQuestionPanel();
				
			}
		});
		//startBibleVerseQuizButton.setName("startBibleVerseQuizButton");
		
		startChapterSummaryQuizButton = new JButton("Start ChapterSummary Quiz");
		startChapterSummaryQuizButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				WhereInTheWord.setCurrentQuizType(CHAPTER_SUMMARY_QUIZ);
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
