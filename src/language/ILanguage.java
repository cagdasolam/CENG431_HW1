package language;

import league.League;
import quiz.Quiz;
import unit.Unit;
import user.User;

import java.util.List;

public interface ILanguage {

	int getTotalUnit();
	int getTotalQuizzes();
	List<User> getAllUsers();
	List<League> getAllLeagues();
	Unit findUnitOfQuiz(int qNumber);
	Quiz findLastQuiz(int qNumber);

}
