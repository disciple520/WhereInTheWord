package com.jerimiahwoods.whereintheword;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DefaultPanel extends JPanel {

	private JLabel lblTitle;
	private JButton btnStartQuiz;

	public DefaultPanel() {
		
		lblTitle = new JLabel("Where in the Word");
		lblTitle.setFont(new Font("Serif", Font.PLAIN, 30));
		
		btnStartQuiz = new JButton("Start Quiz");
		ListenForBtnStartQuiz listenForBtnStartQuiz = new ListenForBtnStartQuiz();
		btnStartQuiz.addActionListener(listenForBtnStartQuiz);
		
		this.add(lblTitle);
		this.add(btnStartQuiz);
		System.out.println("lbl Parent:" + lblTitle.getParent().toString() +
				           "\nbtn Parent:" + btnStartQuiz.getParent().toString());
		
	}
	
	private class ListenForBtnStartQuiz implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			JButton btnStartQuiz = (JButton) e.getSource();
			btnStartQuiz.setVisible(false);
			
		}
		
	}
	
	public JLabel getLblTitle() {
		return lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	public JButton getBtnStartQuiz() {
		return btnStartQuiz;
	}

	public void setBtnStartQuiz(JButton btnStartQuiz) {
		this.btnStartQuiz = btnStartQuiz;
	}

}
