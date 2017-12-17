package cells.walls;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import cells.Cell;
import cells.walls.types.Fire;
import cells.walls.types.Rock;
import cells.walls.types.Tree;
import cells.walls.types.Wooden;

public class WallsFactory {

	static Logger log = Logger.getLogger(WallsFactory.class.getName());

	private static ArrayList<String> walls;
	static {
		walls = new ArrayList<>();
		walls.add("fire");
		walls.add("rock");
		walls.add("tree");
		walls.add("wooden");
	}

	public static boolean canCreate(String cell) {
		return walls.contains(cell);
	}

	public static Cell create(String wall) {
		if (wall.equalsIgnoreCase("fire")) {
			log.info("fire wall is created");
			return new Fire();
		} else if (wall.equalsIgnoreCase("rock")) {
			log.info("rock wall is created");
			return new Rock();
		} else if (wall.equalsIgnoreCase("tree")) {
			log.info("tree wall is created");
			return new Tree();
		} else if (wall.equalsIgnoreCase("wooden")) {
			log.info("wooden wall is created");
			return new Wooden();
		}
		return null;
	}

	public static ArrayList<String> getSupportedWalls() {
		return new ArrayList<String>(walls);
	}
}
