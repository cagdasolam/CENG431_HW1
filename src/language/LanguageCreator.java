package language;

import audio.Audio;
import question.ListeningQuestion;
import question.Question;
import question.ReadingQuestion;
import question.SpeakingQuestion;
import question.WordMatchingQuestion;
import quiz.Quiz;
import random_generator.RandomNumberGenerator;
import random_generator.RandomStringGenerator;
import unit.Unit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguageCreator {

	private static final RandomStringGenerator randomStringGenerator = new RandomStringGenerator();

	public List<Language> createLanguages(String fileName) throws IOException {
		File langCsv = new File("./languages.csv");
		if (!langCsv.exists()) {
			new LanguageCSVGenerator().languageGenerate();
		}
		List<Language> languages = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = br.readLine()) != null) {
			String[] fields = line.split(";");
			String langName = fields[0];
//			U,Q,R,l,s,W
//			1,1,1,1,1,1;1,2,1,1,1,1;2,1,1,1,1,1
			int currentUnit = 1;
			List<Unit> units = new ArrayList<>();
			List<Quiz> quizzes = new ArrayList<>();
			for (int fieldIndex = 1; fieldIndex < fields.length; fieldIndex++) {
				String[] quiz = fields[fieldIndex].split(",");

				int quizUnit = Integer.parseInt(quiz[0]);
				int quizNumber = Integer.parseInt(quiz[1]);
				int reading = Integer.parseInt(quiz[2]);
				int listening = Integer.parseInt(quiz[3]);
				int speaking = Integer.parseInt(quiz[4]);
				int word = Integer.parseInt(quiz[5]);

				if (currentUnit != quizUnit) {
					Unit unit = new Unit(currentUnit, quizzes);
					currentUnit++;
					units.add(unit);
					quizzes = new ArrayList<>();
				}

				List<Question> questionList = new ArrayList<>();
				for (int i = 0; i < reading; i++) {
					Question question = new ReadingQuestion(randomStringGenerator.generate(), randomStringGenerator.generate());
					questionList.add(question);
				}
				for (int i = 0; i < listening; i++) {
					Audio audio = new Audio(RandomNumberGenerator.generateRandomNumber(32));
					Question question = new ListeningQuestion(randomStringGenerator.generate(), audio);
					questionList.add(question);
				}
				for (int i = 0; i < speaking; i++) {
					Audio audio1 = new Audio(RandomNumberGenerator.generateRandomNumber(32));
					Audio audio2 = new Audio(RandomNumberGenerator.generateRandomNumber(32));
					Question question = new SpeakingQuestion(audio1, audio2);
					questionList.add(question);
				}
				for (int i = 0; i < word; i++) {
					Map<String, String> matching = new HashMap<>();
					for (int j = 0; j < RandomNumberGenerator.generateRandomNumber(4, 8); j++) {
						String str = randomStringGenerator.generate();
						String strTranslated = randomStringGenerator.generate();
						matching.put(str, strTranslated);
					}
					Question question = new WordMatchingQuestion(matching);
					questionList.add(question);
				}
				Quiz quizObj = new Quiz(quizNumber, questionList);
				quizzes.add(quizObj);

			}
			Unit unit = new Unit(currentUnit, quizzes);
			units.add(unit);
			Language language = new Language(langName, units);
			languages.add(language);
		}
		br.close();
		return languages;
	}
}
