package utilsMath;

import java.util.Random;

public class RandomGenerator {
	public static int generateRandom(int range) {
		Random generator = new Random();
		int x = generator.nextInt();
		return x < 0 ? x * -1 % range : x % range ;
	}
}
