import language.Language;
import language.LanguageCreator;
import user.User;
import user.UserCreator;

import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {

		LanguageCreator languageCreator = new LanguageCreator();

		List<Language> languages = languageCreator.createLanguages("languages.csv");


		UserCreator userCreator = new UserCreator(languages);
		List<User> users = userCreator.createUsers("users.csv");

		System.out.println(users);
	}
}