package user;

import language.Language;
import question.Question;
import quiz.Quiz;
import unit.Unit;

import java.util.List;
import java.util.Random;

public class User implements IUser {

	private String userName;
	private String password;
	private Language selectedLanguage;
	private Unit currentUnit;
	private int streak;
	private int totalPoints;
	private Quiz lastQuiz;

	public User(String userName, String password, Language selectedLanguage, Unit currentUnit, int streak, int totalPoints, Quiz lastQuiz) {
		this.userName = userName;
		this.password = password;
		this.selectedLanguage = selectedLanguage;
		this.currentUnit = currentUnit;
		this.streak = streak;
		this.totalPoints = totalPoints;
		this.lastQuiz = lastQuiz;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Language getSelectedLanguage() {
		return selectedLanguage;
	}

	public void setSelectedLanguage(Language selectedLanguage) {
		this.selectedLanguage = selectedLanguage;
	}

	public Unit getCurrentUnit() {
		return currentUnit;
	}

	public void setCurrentUnit(Unit currentUnit) {
		this.currentUnit = currentUnit;
	}

	public int getStreak() {
		return streak;
	}

	public void setStreak(int streak) {
		this.streak = streak;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public Quiz getLastQuiz() {
		return lastQuiz;
	}

	public void setLastQuiz(Quiz lastQuiz) {
		this.lastQuiz = lastQuiz;
	}

	@Override
	public void takesQuiz(Quiz quiz) {
		List<Question> questionList = quiz.getQuestionList();
		for (Question question : questionList) {
			answerQuestion(question);
		}
		this.lastQuiz = quiz;
	}

	@Override
	public void answerQuestion(Question question) {

		boolean givenAnswer = new Random().nextBoolean();
		question.setGivenAnswer(givenAnswer);

		if (givenAnswer) {
			this.totalPoints += question.getPoint();
		}
	}

	@Override
	public int getSolvedQuizzesNumber() {
		int quizNumber = 0;
		for (Unit unit : this.selectedLanguage.getUnits()) {
			if (this.currentUnit.getUnitNumber() > unit.getUnitNumber()) {
				quizNumber += unit.getQuizzes().size();
			}
			if (this.currentUnit.getUnitNumber() == unit.getUnitNumber()) {
				quizNumber += this.lastQuiz.getQuizNumber();
			}
		}
		return quizNumber;
	}

	@Override
	public String toString() {
		return "User{" +
				"userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", selectedLanguage=" + selectedLanguage.getLanguageName() +
				", currentUnit=" + currentUnit.getUnitNumber() +
				", streak=" + streak +
				", totalPoints=" + totalPoints +
				", lastQuiz=" + lastQuiz.getQuizNumber() +
				'}';
	}
}
