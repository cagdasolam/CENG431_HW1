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
	private League league;
	private Unit currentUnit;
	private int streak;
	private int totalPoints;

	@Override
	public void takesQuiz(Quiz quiz) {

	}

	@Override
	public void answerQuestion(Question question) {
//		question
	}

}
