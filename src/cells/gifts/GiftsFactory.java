package cells.gifts;

import java.util.ArrayList;

import cells.Cell;
import cells.gifts.types.ArmorGift;
import cells.gifts.types.BulletGift;
import cells.gifts.types.DoubleHealthGift;
import cells.gifts.types.EatEnemyGift;
import cells.gifts.types.HealthGift;
import cells.gifts.types.NoFireGift;
import cells.gifts.types.PassThroughGift;

public class GiftsFactory {
	private static ArrayList<String> gifts;
	static {
		gifts = new ArrayList<>();
		gifts.add("bullet");
		gifts.add("health");
		gifts.add("armor");
		gifts.add("doublehealth");
		gifts.add("eatenemy");
		gifts.add("passthrough");
		gifts.add("nofire");
	}

	public static boolean canCreate(String cell) {
		return gifts.contains(cell);
	}

	public static Cell create(String gift) {
		if (gift.equalsIgnoreCase("bullet"))
			return new BulletGift();
		else if (gift.equalsIgnoreCase("health"))
			return new HealthGift();
		else if (gift.equalsIgnoreCase("armor"))
			return new ArmorGift();
		else if (gift.equalsIgnoreCase("doubleHealth"))
			return new DoubleHealthGift();
		else if (gift.equalsIgnoreCase("eatEnemy"))
			return new EatEnemyGift();
		else if (gift.equalsIgnoreCase("passThrough"))
			return new PassThroughGift();
		else if (gift.equalsIgnoreCase("noFire"))
			return new NoFireGift();
		return null;
	}
	
	public static ArrayList<String> getSupportedGifts() {
		return new ArrayList<String>(gifts);
	}
	
}
