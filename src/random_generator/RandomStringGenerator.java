package random_generator;

import java.security.SecureRandom;
import java.util.Random;

public class RandomStringGenerator {
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private final Random random;
	private final char[] symbols;

	public RandomStringGenerator() {
		this.random = new SecureRandom();
		this.symbols = new char[CHARACTERS.length()];
		CHARACTERS.getChars(0, CHARACTERS.length(), this.symbols, 0);
	}

	public String generate() {
		char[] buf = new char[symbols.length];
		for (int idx = 0; idx < buf.length; ++idx) {
			buf[idx] = symbols[random.nextInt(symbols.length)];
		}
		return new String(buf);
	}
}
