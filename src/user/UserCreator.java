package user;

import language.Language;
import random_generator.RandomNumberGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserCreator {

	private static final int MIN_QUIZZES = 6; // Minimum number of quizzes a user will take
	private static final int MAX_QUIZZES = 10; // Maximum number of quizzes a user will take

	public static List<User> createUsers(String fileName) throws IOException {
		List<User> users = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = br.readLine()) != null) {
			String[] fields = line.split(";");
			if (fields.length >= 2) {
				String userName = fields[0];
				String password = fields[1];
//				Language selectedLanguage = Language.values()[RandomNumberGenerator.generateRandomNumber(0, 5)];
				int streak = RandomNumberGenerator.generateRandomNumber(1, 10); // Random streak between 1 and 10
				int totalPoints = 0; // Initialize totalPoints to 0
				if (fields.length >= 3) {
					totalPoints = Integer.parseInt(fields[2]);
				}
				int numQuizzes = RandomNumberGenerator.generateRandomNumber(MIN_QUIZZES, MAX_QUIZZES); // Random number of quizzes
				int currentUnit = RandomNumberGenerator.generateRandomNumber(numQuizzes); // Random current unit between 1 and numQuizzes
//				User user = new User(userName, password, selectedLanguage, null, null, streak, totalPoints);
//				users.add(user);
			}
		}
		br.close();
		return users;
	}

//	private Language selectLanguage(int randInt) {
//		int numberOfUnit = RandomNumberGenerator.generateRandomNumber(60, 100);
//
//		if (randInt == 1) {
//			return new La(numberOfUnit);
//		}
//		if (randInt == 2) {
//			return new GermanLanguage(numberOfUnit);
//		}
//		if (randInt == 3) {
//			return new SpanishLanguage(numberOfUnit);
//		}
//		if (randInt == 4) {
//			return new ItalianLanguage(numberOfUnit);
//		}
//
////		default English
//		return EnglishLanguage();
//	}
}
