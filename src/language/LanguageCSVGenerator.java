package language;

import audio.Audio;
import question.ListeningQuestion;
import question.Question;
import question.ReadingQuestion;
import question.SpeakingQuestion;
import question.WordMatchingQuestion;
import random_generator.RandomNumberGenerator;
import random_generator.RandomStringGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LanguageCSVGenerator {


	private static final String[] LANGUAGES = {"Turkish", "German", "Italian", "Spanish"};
	private static final int MIN_UNITS = 60;
	private static final int MAX_UNITS = 100;
	private static final int MIN_QUIZZES = 1;
	private static final int MAX_QUIZZES = 10;
	private static final int MIN_QUESTIONS = 8;
	private static final int MAX_QUESTIONS = 15;
	private static final String[] QUESTION_TYPES = {"reading", "listening", "speaking", "matching"};

	public void languageGenerate() {
		try {
			File langCsv = new File("./languages.csv");
			if (!langCsv.exists()) {
				FileWriter writer = new FileWriter("languages.csv");

				// Generate and write random data for each language
				for (String language : LANGUAGES) {
					StringBuilder line = new StringBuilder(String.format("%s", language));
					int numUnits = RandomNumberGenerator.generateRandomNumber(MIN_UNITS, MAX_UNITS);
					for (int unitNum = 1; unitNum <= numUnits; unitNum++) {
						int numQuizzes = RandomNumberGenerator.generateRandomNumber(MIN_QUIZZES, MAX_QUIZZES);
						for (int quizNum = 1; quizNum <= numQuizzes; quizNum++) {
							int numQuestions = RandomNumberGenerator.generateRandomNumber(MIN_QUESTIONS, MAX_QUESTIONS);

							Map<String, Integer> questionTypeAmountMap = new HashMap<>();
							questionTypeAmountMap.put("reading", 0);
							questionTypeAmountMap.put("listening", 0);
							questionTypeAmountMap.put("speaking", 0);
							questionTypeAmountMap.put("matching", 0);

							for (int questionNum = 1; questionNum <= numQuestions; questionNum++) {
								String questionType = QUESTION_TYPES[RandomNumberGenerator.generateRandomNumber(0, QUESTION_TYPES.length - 1)];
								questionTypeAmountMap.put(questionType, questionTypeAmountMap.get(questionType) + 1);
							}
							line.append(String.format(";%d,%d,%d,%d,%d,%d", unitNum, quizNum,
									questionTypeAmountMap.get("reading"), questionTypeAmountMap.get("listening"),
									questionTypeAmountMap.get("speaking"), questionTypeAmountMap.get("matching")));
						}
					}
					writer.append(line.append("\n"));
				}

				writer.flush();
				writer.close();
				System.out.println("Data generation complete. File written to 'languages.csv'.");
			}
		} catch (IOException e) {
			System.out.println("Error writing to CSV file: " + e.getMessage());
		}
	}

}
