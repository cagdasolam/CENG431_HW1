package question;

public class Question implements IQuestionInterface {

	private int point;
	private boolean isTrue;

	public int getPoint() {
		return point;
	}

	public boolean isTrue() {
		return isTrue;
	}

	public void setTrue(boolean aTrue) {
		isTrue = aTrue;
	}
}
