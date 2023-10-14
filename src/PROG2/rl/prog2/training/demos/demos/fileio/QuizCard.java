package rl.prog2.training.demos.demos.fileio;

import java.io.Serializable;

/**
 * Represents a quiz card. A quiz card contains a question and and answer.
 * 
 * @author Ruediger Lunde
 */
public class QuizCard implements Serializable {
	private static final long serialVersionUID = 3562615400722105508L;

	private String question;
	private String answer;

	public QuizCard() {
		this("", "");
	}

	public QuizCard(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
