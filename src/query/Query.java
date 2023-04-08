package query;

import language.Language;
import league.League;
import user.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Query {

	public User getMaxPointUser(List<User> users) {
		return users.stream()
				.max(Comparator.comparing(User::getTotalPoints))
				.orElse(null);
	}

	public User getMostAdvancedUser(List<User> users, String langName) {
		return users.stream().filter(user -> user.getSelectedLanguage().getLanguageName().equals(langName))
				.max(Comparator.comparing(user -> user.getCurrentUnit().getUnitNumber())).orElse(null);
	}

	public Language getMostUnitLanguage(List<Language> languages) {
		return languages.stream().max(Comparator.comparing(Language::getTotalUnit)).orElse(null);
	}

	public Language getMostQuizLanguage(List<Language> languages) {
		return languages.stream().max(Comparator.comparing(Language::getTotalQuizzes)).orElse(null);
	}

	public List<User> getTopThreeUsers(List<Language> languages, String langName, String leagueName) {
		Language foundLanguage = languages.stream().filter(language -> language.getLanguageName().equals(langName)).findFirst()
				.orElse(null);
		if (foundLanguage == null) {
			return Collections.emptyList();
		}
		League foundLeague = foundLanguage.getAllLeagues().stream().filter(league -> league.getName().equals(leagueName)).findFirst()
				.orElse(null);
		if (foundLeague == null) {
			return Collections.emptyList();
		}
		return foundLeague.getTopThreeUsers();
	}

}
