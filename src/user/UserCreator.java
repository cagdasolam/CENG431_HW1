package user;

import language.Language;
import league.League;
import random_generator.RandomNumberGenerator;
import unit.Unit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserCreator {

	private static final int MIN_QUIZZES = 6; // Minimum number of quizzes a user will take
	private static final int MAX_QUIZZES = 10; // Maximum number of quizzes a user will take
	private List<Language> languages;

	public UserCreator(List<Language> languages) throws IOException {this.languages = languages;}

	public List<User> createUsers(String fileName) throws IOException {
		List<User> users = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = br.readLine()) != null) {
			String[] fields = line.split(";");
			if (fields.length >= 2) {
				String userName = fields[0];
				String password = fields[1];
				Language selectedLanguage = languages.get(RandomNumberGenerator.generateRandomNumber(0,3));
				int streak = RandomNumberGenerator.generateRandomNumber(1, 10); // Random streak between 1 and 10
				int totalPoints = 0; // Initialize totalPoints to 0
				if (fields.length >= 3) {
					totalPoints = Integer.parseInt(fields[2]);
				}
				int numQuizzes = RandomNumberGenerator.generateRandomNumber(MIN_QUIZZES, selectedLanguage.getTotalQuizzes()); // Random number of quizzes
//				int currentUnit = RandomNumberGenerator.generateRandomNumber(numQuizzes); // Random current unit between 1 and numQuizzes

				Unit unit = selectedLanguage.findUnitOfQuiz(numQuizzes);
				User user = new User(userName, password, selectedLanguage, unit, streak, totalPoints);
				addUserToBronzeLeague(selectedLanguage, user);
				users.add(user);
			}
		}
		br.close();
		return users;
	}

	private void addUserToBronzeLeague(Language selectedLanguage, User user){
		List<User> usersOfLeague = selectedLanguage.getBronzeLeague().getUsers();
		usersOfLeague.add(user);
		League newBronze = selectedLanguage.getBronzeLeague();
		newBronze.setUsers(usersOfLeague);
		selectedLanguage.setBronzeLeague(newBronze);
	}

}
