package user;

import language.Language;
import league.League;
import question.Question;
import quiz.Quiz;
import unit.Unit;

public class User implements IUser {

	private String userName;
	private String password;
	private Language selectedLanguage;
//	private League league;
	private int currentUnit;
	private int streak;
	private int totalPoints;

	public User(String userName, String password, Language selectedLanguage, int currentUnit, int streak, int totalPoints) {
		this.userName = userName;
		this.password = password;
		this.selectedLanguage = selectedLanguage;
//		this.league = league;
		this.currentUnit = currentUnit;
		this.streak = streak;
		this.totalPoints = totalPoints;
	}

	@Override
	public void takesQuiz(Quiz quiz) {

	}

	@Override
	public void answerQuestion(Question question) {
//		question
	}

}
