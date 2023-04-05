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

	private RandomStringGenerator randomStringGenerator = new RandomStringGenerator();

	private static final String[] LANGUAGES = {"Turkish", "German", "Italian", "Spanish"};
	private static final int MIN_UNITS = 60;
	private static final int MAX_UNITS = 100;
	private static final int MIN_QUIZZES = 1;
	private static final int MAX_QUIZZES = 10;
	private static final int MIN_QUESTIONS = 8;
	private static final int MAX_QUESTIONS = 15;
	private static final String[] QUESTION_TYPES = {"reading", "listening", "speaking", "word-matching"};
	private static final int[] QUESTION_POINTS = {10, 7, 8, 5};

	public Language languageGenerate() {
		try {
			File langCsv = new File("./languages.csv");
			if (!langCsv.exists()){
				FileWriter writer = new FileWriter("languages.csv");

				// Write header row to CSV file
				writer.append("Language,Unit,Quiz,Question Type,Question Points,Question\n");

				// Generate and write random data for each language
				for (String language : LANGUAGES) {
					int numUnits = RandomNumberGenerator.generateRandomNumber(MIN_UNITS, MAX_UNITS);
					for (int unitNum = 1; unitNum <= numUnits; unitNum++) {
						int numQuizzes = RandomNumberGenerator.generateRandomNumber(MIN_QUIZZES, MAX_QUIZZES);
						for (int quizNum = 1; quizNum <= numQuizzes; quizNum++) {
							String questionType = QUESTION_TYPES[RandomNumberGenerator.generateRandomNumber(0, QUESTION_TYPES.length - 1)];
							int questionPoints = QUESTION_POINTS[RandomNumberGenerator.generateRandomNumber(0, QUESTION_POINTS.length - 1)];
							int numQuestions = RandomNumberGenerator.generateRandomNumber(MIN_QUESTIONS, MAX_QUESTIONS);
							for (int questionNum = 1; questionNum <= numQuestions; questionNum++) {
								String questionText = RandomNumberGenerator.generateRandomNumber(questionType);
								writer.append(String.format("%s,%d,%d,%s,%d,%s\n", language, unitNum, quizNum,
										questionType, questionPoints, questionText));
							}
						}
					}
				}

				writer.flush();
				writer.close();
				System.out.println("Data generation complete. File written to 'languages.csv'.");
			}
		} catch (IOException e) {
			System.out.println("Error writing to CSV file: " + e.getMessage());
		}

		return
	}

	private Question selectQuestionType(int randInt) {

		if (randInt == 1) {
			String engText = randomStringGenerator.generate();
			String translatedText = randomStringGenerator.generate();
			return new ReadingQuestion(engText, translatedText);
		}
		if (randInt == 2) {
			String engText = randomStringGenerator.generate();
			int length = RandomNumberGenerator.generateRandomNumber(130);
			Audio audio = new Audio(length);
			return new ListeningQuestion(engText, audio);
		}
		if (randInt == 3) {
			Map<String, String> matchMap = new HashMap<>();
			int length = RandomNumberGenerator.generateRandomNumber(130);
			for (int i = 0; i < length; i++){
				String engText = randomStringGenerator.generate();
				String translatedText = randomStringGenerator.generate();
				matchMap.put(engText, translatedText);
			}
			return new WordMatchingQuestion(matchMap);
		}
		else {
			int length1 = RandomNumberGenerator.generateRandomNumber(130);
			Audio firstAudio = new Audio(length1);
			int length2 = RandomNumberGenerator.generateRandomNumber(130);
			Audio secondAudio = new Audio(length2);
			return new SpeakingQuestion(firstAudio, secondAudio);
		}
	}

}
