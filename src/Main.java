import language.Language;
import language.LanguageCreator;
import mediator.Mediator;
import user.User;
import user.UserCreator;

import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {

		Mediator mediator = new Mediator();

		mediator.run();
	}
}