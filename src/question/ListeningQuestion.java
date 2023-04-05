package question;

import audio.Audio;

public class ListeningQuestion extends Question {

	private String string;

	private Audio audio;

	private int point;

	public ListeningQuestion(String string, Audio audio) {
		this.string = string;
		this.audio = audio;
		this.point = 7;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Audio getAudio() {
		return audio;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	@Override
	public int getPoint() {
		return point;
	}

}
