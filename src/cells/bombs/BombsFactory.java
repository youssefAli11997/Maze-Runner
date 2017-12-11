package cells.bombs;

import java.util.ArrayList;

import cells.Cell;
import cells.bombs.types.BigBomb;
import cells.bombs.types.SmallBomb;

public class BombsFactory {
	private static ArrayList<String> bombs;
	static {
		bombs = new ArrayList<>();
		bombs.add("bigbomb");
		bombs.add("smallbomb");
	}

	public static boolean canCreate(String cell) {
		return bombs.contains(cell);
	}

	public static Cell create(String bomb) {
		if (bomb.equalsIgnoreCase("bigbomb"))
			return new BigBomb();
		else if (bomb.equalsIgnoreCase("smallbomb"))
			return new SmallBomb();
		return null;
	}
	
	public static ArrayList<String> getSupportedBombs(){
		return new ArrayList<String>(bombs);
	}
}
