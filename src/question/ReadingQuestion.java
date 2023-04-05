package question;

public class ReadingQuestion extends Question {

	private String englishText;
	private String translate;

	private final int point;

	public ReadingQuestion(String englishText, String translate) {
		this.englishText = englishText;
		this.translate = translate;
		this.point = 10;
	}

	public String getEnglishText() {
		return englishText;
	}

	public void setEnglishText(String englishText) {
		this.englishText = englishText;
	}

	public String getTranslate() {
		return translate;
	}

	public void setTranslate(String translate) {
		this.translate = translate;
	}

	@Override
	public int getPoint() {
		return point;
	}
}
