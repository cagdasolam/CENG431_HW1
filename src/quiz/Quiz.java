package quiz;

import question.Question;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

	private int quizNumber;

	private List<Question> questionList = new ArrayList<>();

	public Quiz(int quizNumber, List<Question> questionList) {
		this.quizNumber = quizNumber;
		this.questionList = questionList;
	}

	public int getQuizNumber() {
		return quizNumber;
	}

	public void setQuizNumber(int quizNumber) {
		this.quizNumber = quizNumber;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
}
