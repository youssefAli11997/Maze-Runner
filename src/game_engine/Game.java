package game_engine;

import cells.Cell;

public class Game {
	private static Game ourInstance = new Game();
	private Cell[][] gameGrid;

	public static Game getInstance() {
		return ourInstance;
	}

	private Game() {

	}
}
