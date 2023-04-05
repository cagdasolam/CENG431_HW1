package user;

import question.Question;
import quiz.Quiz;

public interface IUser {

	void takesQuiz(Quiz quiz);

	void answerQuestion(Question question);
}
