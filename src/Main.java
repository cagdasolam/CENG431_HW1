import language.Language;
import language.LanguageCSVGenerator;
import language.LanguageCreator;
import question.Question;
import question.ReadingQuestion;
import random_generator.RandomStringGenerator;
import user.User;
import user.UserCreator;

import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {


		UserCreator userCreator = new UserCreator();
		List<User> users = userCreator.createUsers("users.csv");

		System.out.println(users);
	}
}