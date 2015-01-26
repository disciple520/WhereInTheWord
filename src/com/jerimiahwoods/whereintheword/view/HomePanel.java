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

public class HomePanel extends JPanel {

	final public String BIBLE_VERSE_QUIZ     = UIManager.BIBLE_VERSE_QUIZ;
	final public String CHAPTER_SUMMARY_QUIZ = UIManager.CHAPTER_SUMMARY_QUIZ;
	
	private DataController dataController;
	
	private JLabel  lblTitle;
	private JButton startBibleVerseQuizButton;
	private JButton startChapterSummaryQuizButton;
	private JButton quitButton;

	public HomePanel(DataController dataController) {
		
		this.dataController = new DataController();
		this.dataController = dataController;
		
		
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
		
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		startBibleVerseQuizButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		startChapterSummaryQuizButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.add(lblTitle);
		this.add(startBibleVerseQuizButton);
		this.add(startChapterSummaryQuizButton);
		this.add(quitButton);
		
	}
	
	public DataController getDataController() {
		return dataController;
	}
	
	public void setDataController(DataController dataController) {
		this.dataController = dataController;
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
