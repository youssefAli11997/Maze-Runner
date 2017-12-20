package cells.gifts;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import cells.Cell;
import cells.gifts.types.ArmorGift;
import cells.gifts.types.BulletGift;
import cells.gifts.types.DoubleHealthGift;
import cells.gifts.types.DoubleScoreGift;
import cells.gifts.types.EatEnemyGift;
import cells.gifts.types.HealthGift;
import cells.gifts.types.NoFireGift;
import cells.gifts.types.PassThroughGift;
import cells.gifts.types.ScoreGift;

public class GiftsFactory {
	static Logger log = Logger.getLogger(GiftsFactory.class.getName());

	private static ArrayList<String> gifts;
	static {
		gifts = new ArrayList<>();
		gifts.add("bullet");
		gifts.add("health");
		gifts.add("doublehealth");
		gifts.add("doublescore");
		gifts.add("score");
	}

	public static boolean canCreate(String cell) {
		return gifts.contains(cell);
	}

	public static Cell create(String gift) {
		if (gift.equalsIgnoreCase("bullet")) {
			log.info("bullet gift is created");
			return new BulletGift();
		} else if (gift.equalsIgnoreCase("health")) {
			log.info("health gift is created");
			return new HealthGift();
		} else if (gift.equalsIgnoreCase("armor")) {
			log.info("armor gift is created");
			return new ArmorGift();
		} else if (gift.equalsIgnoreCase("doubleHealth")) {
			log.info("doubleHealth gift is created");
			return new DoubleHealthGift();
		} else if (gift.equalsIgnoreCase("eatEnemy")) {
			log.info("eatEnemy gift is created");
			return new EatEnemyGift();
		} else if (gift.equalsIgnoreCase("passThrough")) {
			log.info("passThrough gift is created");
			return new PassThroughGift();
		} else if (gift.equalsIgnoreCase("noFire")) {
			log.info("noFire gift is created");
			return new NoFireGift();
		} else if (gift.equalsIgnoreCase("score")) {
			log.info("noFire gift is created");
			return new ScoreGift();
		}	else if (gift.equalsIgnoreCase("doubleScore")) {
			log.info("doubleScore gift is created");
			return new DoubleScoreGift();
		}
		return null;
	}

	public static ArrayList<String> getSupportedGifts() {
		return new ArrayList<String>(gifts);
	}

}
