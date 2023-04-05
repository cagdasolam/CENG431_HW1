package question;

import java.util.Map;

public class WordMatchingQuestion extends Question{

	private Map <String, String> matchedWords;

	private int point;

	public WordMatchingQuestion(Map<String, String> matchedWords) {
		this.matchedWords = matchedWords;
		this.point = 5;
	}

	public Map<String, String> getMatchedWords() {
		return matchedWords;
	}

	public void setMatchedWords(Map<String, String> matchedWords) {
		this.matchedWords = matchedWords;
	}

	@Override
	public int getPoint() {
		return point;
	}

}
