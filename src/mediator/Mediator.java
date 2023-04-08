package mediator;

import language.Language;
import language.LanguageCreator;
import league.BronzeLeague;
import league.GoldLeague;
import league.League;
import league.SapphireLeague;
import league.SilverLeague;
import query.Query;
import user.User;
import user.UserCreator;

import java.io.IOException;
import java.util.List;

public class Mediator {

	LanguageCreator languageCreator = new LanguageCreator();
	List<Language> languages = languageCreator.createLanguages("languages.csv");
	UserCreator userCreator = new UserCreator(languages);
	List<User> users = userCreator.createUsers("users.csv");
	Query query = new Query();

	public Mediator() throws IOException {}


	public void run() throws IOException {

		for (Language language : languages) {
			ranking(language);
		}

		User maxPointUser = query.getMaxPointUser(users);
		User mostAdvancedGerman = query.getMostAdvancedUser(users, "German");
		Language mostUnitLanguage = query.getMostUnitLanguage(languages);
		Language mostQuizLanguage = query.getMostQuizLanguage(languages);
		List<User> topThree = query.getTopThreeUsers(languages, "Italian", "Silver");
		System.out.println(maxPointUser.getUserName() + " " + maxPointUser.getTotalPoints() + " points");
		System.out.println(mostAdvancedGerman.getUserName() + " unit " + mostAdvancedGerman.getCurrentUnit().getUnitNumber());
		System.out.println(mostUnitLanguage.getLanguageName() + " " + mostUnitLanguage.getTotalUnit() + " units");
		System.out.println(mostQuizLanguage.getLanguageName() + " " + mostQuizLanguage.getTotalQuizzes() + " quizzes");
		System.out.println("Italian Silver League Top 3: 1. " + topThree.get(0).getUserName() +
				" 2. " + topThree.get(1).getUserName() +
				" 3. " + topThree.get(2).getUserName());

		userCreator.writeToFile("users.csv", users);
	}

	private void ranking(Language language) {
		List<League> leagues = language.getAllLeagues();

		language.getAllLeagues().forEach(league -> {
			league.getUsers().forEach(user -> language.getUnits().stream()
					.filter(unit -> user.getCurrentUnit().getUnitNumber() >= unit.getUnitNumber())
					.flatMap(unit -> unit.getQuizzes().stream())
					.filter(quiz -> user.getLastQuiz().getQuizNumber() >= quiz.getQuizNumber())
					.forEach(user::takesQuiz));

			List<User> advancedUsers = league.getAdvancedUsers();

			if (league instanceof BronzeLeague) {
				rankUp(advancedUsers, league, language.getSilverLeague());
			}

			if (league instanceof SilverLeague) {
				rankUp(advancedUsers, league, language.getGoldLeague());
			}

			if (league instanceof GoldLeague) {
				rankUp(advancedUsers, league, language.getSapphireLeague());
			}

			if (league instanceof SapphireLeague) {
				rankUp(advancedUsers, league, language.getRubyLeague());
			}
		});
	}

	private void rankUp(List<User> advancedUsers, League from, League to) {
		to.getUsers().addAll(advancedUsers);
		from.getUsers().removeAll(advancedUsers);
	}

}
