package cells.walls;

import java.util.ArrayList;

import cells.Cell;
import cells.walls.types.Fire;
import cells.walls.types.Rock;
import cells.walls.types.Tree;
import cells.walls.types.Wooden;

public class WallsFactory {
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
		if (wall.equalsIgnoreCase("fire"))
			return new Fire();
		else if (wall.equalsIgnoreCase("rock"))
			return new Rock();
		else if (wall.equalsIgnoreCase("tree"))
			return new Tree();
		else if (wall.equalsIgnoreCase("wooden"))
			return new Wooden();
		return null;
	}
	
	public static ArrayList<String> getSupportedWalls(){
		return new ArrayList<String>(walls);
	}
}
