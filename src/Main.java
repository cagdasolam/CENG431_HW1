import question.Question;
import question.ReadingQuestion;
import random_generator.RandomStringGenerator;

public class Main {
	public static void main(String[] args) {
		Question reading = new ReadingQuestion("asdasf", "asdasd asd");

		System.out.println(reading.getPoint());


		RandomStringGenerator randomStringGenerator = new RandomStringGenerator();

		System.out.println(randomStringGenerator.generate());


	}
}