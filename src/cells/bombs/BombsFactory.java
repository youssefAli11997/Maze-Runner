package cells.bombs;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import cells.Cell;
import cells.bombs.types.BigBomb;
import cells.bombs.types.SmallBomb;

public class BombsFactory {
	static Logger log = Logger.getLogger(BombsFactory.class.getName());

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
		if (bomb.equalsIgnoreCase("bigbomb")){
			log.info("big bomb created");
			return new BigBomb();
		}
		else if (bomb.equalsIgnoreCase("smallbomb")){
			log.info("small bomb created");
			return new SmallBomb();
		}
		return null;
	}
	
	public static ArrayList<String> getSupportedBombs(){
		return new ArrayList<String>(bombs);
	}
}
