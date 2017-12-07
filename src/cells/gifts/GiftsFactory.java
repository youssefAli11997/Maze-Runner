package cells.gifts;

import java.util.ArrayList;

import cells.Cell;
import cells.gifts.types.Bullet;
import cells.gifts.types.Health;

public class GiftsFactory {
	private static ArrayList<String> gifts ;
	static {
		gifts = new ArrayList<>();
		gifts.add("bullet");
		gifts.add("health");
	}
	
	public static boolean canCreate(String cell) {
		return gifts.contains(cell);
	}
	
	public static Cell create(String wall) {
		if(wall.equalsIgnoreCase("bullet"))
			return new Bullet();
		else if (wall.equalsIgnoreCase("health"))
			return new Health();
		return null;
	}
}	
