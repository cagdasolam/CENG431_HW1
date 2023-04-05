package question;

import audio.Audio;

public class SpeakingQuestion extends Question {

	private Audio firstAudio;
	private Audio secondAudio;

	private int point;

	public SpeakingQuestion(Audio firstAudio, Audio secondAudio) {
		this.firstAudio = firstAudio;
		this.secondAudio = secondAudio;
		this.point = 8;
	}

	public Audio getFirstAudio() {
		return firstAudio;
	}

	public void setFirstAudio(Audio firstAudio) {
		this.firstAudio = firstAudio;
	}

	public Audio getSecondAudio() {
		return secondAudio;
	}

	public void setSecondAudio(Audio secondAudio) {
		this.secondAudio = secondAudio;
	}

	@Override
	public int getPoint() {
		return point;
	}

}
