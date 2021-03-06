package com.jerimiahwoods.whereintheword.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import com.jerimiahwoods.whereintheword.controller.DataController;
import com.jerimiahwoods.whereintheword.model.QuizzableItem;

public abstract class MultipleChoiceQuestionPanel extends JPanel {

	DataController dataController;
	
	int numberOfAnswerOptions = 4;
	
	String userAnswer    = "";
	String correctAnswer = "";
	String resultPhrase  = "";
	
	JTextArea questionText;
	
	ArrayList<JRadioButton> radioButtons;
	ButtonGroup  answerButtonGroup;
	JRadioButton answerOneRadioButton;
	JRadioButton answerTwoRadioButton;
	JRadioButton answerThreeRadioButton;
	JRadioButton answerFourRadioButton;
	
	JButton confirmAnswerButton;
	
	public MultipleChoiceQuestionPanel(){
	}
	
	public MultipleChoiceQuestionPanel(DataController dataController) {
		
		this.dataController = new DataController();
		this.dataController = dataController;
		
		this.setBackground(Color.lightGray);
		
		questionText = new JTextArea(1,45);
		questionText.setLineWrap(true);
		questionText.setWrapStyleWord(true);
		questionText.setBackground(Color.lightGray);
		
		answerOneRadioButton   = new JRadioButton();
		answerTwoRadioButton   = new JRadioButton();
		answerThreeRadioButton = new JRadioButton();
		answerFourRadioButton  = new JRadioButton();
		
		radioButtons = new ArrayList<JRadioButton>();
		radioButtons.add(answerOneRadioButton);
		radioButtons.add(answerTwoRadioButton);
		radioButtons.add(answerThreeRadioButton);
		radioButtons.add(answerFourRadioButton);
		
		answerButtonGroup = new ButtonGroup();
		
		for (JRadioButton button : radioButtons) {
			answerButtonGroup.add(button);
			button.addActionListener(new RadioButtonSelectedListener());
		}
		
		confirmAnswerButton = new JButton("Confirm Answer");
		
		confirmAnswerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAndDisplayAnswer();
			}
		});
		
		this.add(questionText);
		this.add(answerOneRadioButton);
		this.add(answerTwoRadioButton);
		this.add(answerThreeRadioButton);
		this.add(answerFourRadioButton);
		this.add(confirmAnswerButton);
	}
	
	private class RadioButtonSelectedListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
            confirmAnswerButton.setEnabled(true);
        }
    };
	
	public void generateNewQuestion() {
		
		QuizzableItem currentRandomScriptureOption;
		String incorrectAnswer;
		
		answerButtonGroup.clearSelection();
		confirmAnswerButton.setEnabled(false);
		
		int indexWhereCorrectAnswerWillBe = (new Random()).nextInt(numberOfAnswerOptions);
		ArrayList<QuizzableItem> randomAnswers = generateRandomAnswers();
		
		for (int i=0;i<radioButtons.size();i++){
			
			JRadioButton currentButton = radioButtons.get(i);
			currentRandomScriptureOption = randomAnswers.get(i);
			
			if (i == indexWhereCorrectAnswerWillBe) {
				correctAnswer = currentRandomScriptureOption.getScriptureReference();
				currentButton.setText(correctAnswer);
				currentButton.setActionCommand(correctAnswer);
				questionText.setText(randomAnswers.get(i).getText());
			} else {
				incorrectAnswer = currentRandomScriptureOption.getScriptureReference();
				currentButton.setText(incorrectAnswer);
				currentButton.setActionCommand(incorrectAnswer);
			}
		}	
	}
	
	protected abstract ArrayList<QuizzableItem> generateRandomAnswers();
	
	public void checkAndDisplayAnswer() {
			userAnswer = answerButtonGroup.getSelection().getActionCommand();
			checkAnswer();
			UIManager.displayAnswerPanel();
	}
	
	public void checkAnswer() {
		
		System.out.println("You answered " + userAnswer);
		System.out.println("The correct Answer was " + correctAnswer);
		
		if (userAnswer == correctAnswer ) {
			resultPhrase = "Correct!";
		} else {
			resultPhrase = "Incorrect!";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
// *********Getters and Setters********* //
	
	public void setDataController(DataController dataController) {
		this.dataController = dataController;
	}
	
	public int getNumberOfAnswerOptions() {
		return numberOfAnswerOptions;
	}

	public void setNumberOfAnswerOptions(int numberOfAnswerOptions) {
		this.numberOfAnswerOptions = numberOfAnswerOptions;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getResultPhrase() {
		return resultPhrase;
	}

	public void setResultPhrase(String resultPhrase) {
		this.resultPhrase = resultPhrase;
	}

	public JTextArea getQuestionText() {
		return questionText;
	}

	public void setQuestionText(JTextArea questionText) {
		this.questionText = questionText;
	}

	public ArrayList<JRadioButton> getRadioButtons() {
		return radioButtons;
	}

	public void setRadioButtons(ArrayList<JRadioButton> radioButtons) {
		this.radioButtons = radioButtons;
	}

	public ButtonGroup getAnswerButtonGroup() {
		return answerButtonGroup;
	}

	public void setAnswerButtonGroup(ButtonGroup answerButtonGroup) {
		this.answerButtonGroup = answerButtonGroup;
	}

	public JRadioButton getAnswerOneRadioButton() {
		return answerOneRadioButton;
	}

	public void setAnswerOneRadioButton(JRadioButton answerOneRadioButton) {
		this.answerOneRadioButton = answerOneRadioButton;
	}

	public JRadioButton getAnswerTwoRadioButton() {
		return answerTwoRadioButton;
	}

	public void setAnswerTwoRadioButton(JRadioButton answerTwoRadioButton) {
		this.answerTwoRadioButton = answerTwoRadioButton;
	}

	public JRadioButton getAnswerThreeRadioButton() {
		return answerThreeRadioButton;
	}

	public void setAnswerThreeRadioButton(JRadioButton answerThreeRadioButton) {
		this.answerThreeRadioButton = answerThreeRadioButton;
	}

	public JRadioButton getAnswerFourRadioButton() {
		return answerFourRadioButton;
	}

	public void setAnswerFourRadioButton(JRadioButton answerFourRadioButton) {
		this.answerFourRadioButton = answerFourRadioButton;
	}

	public JButton getConfirmAnswerButton() {
		return confirmAnswerButton;
	}

	public void setConfirmAnswerButton(JButton confirmAnswerButton) {
		this.confirmAnswerButton = confirmAnswerButton;
	}
	
}
