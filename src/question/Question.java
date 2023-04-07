package question;

public class Question implements IQuestionInterface {

	private int point;
	private boolean givenAnswer;

	public int getPoint() {
		return point;
	}

	public boolean isGivenAnswer() {
		return givenAnswer;
	}

	public void setGivenAnswer(boolean givenAnswer) {
		this.givenAnswer = givenAnswer;
	}
}
