package language;

import user.User;

import java.util.List;

public interface ILanguage {

	int getTotalUnit();

	int getTotalQuizzes();

	List<User> getAllUsers();

}
