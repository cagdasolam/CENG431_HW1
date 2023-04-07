package unit;

import quiz.Quiz;

import java.util.ArrayList;
import java.util.List;

public class Unit implements IUnit {

	private int unitNumber;
	private List<Quiz> quizzes = new ArrayList<>();

	public Unit(int unitNumber, List<Quiz> quizzes) {
		this.unitNumber = unitNumber;
		this.quizzes = quizzes;
	}

	public int getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(int unitNumber) {
		this.unitNumber = unitNumber;
	}

	public List<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
}
