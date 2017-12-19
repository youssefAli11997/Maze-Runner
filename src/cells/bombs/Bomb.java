package cells.bombs;

import cells.Cell;
import characters.GameCharacter;

public abstract class Bomb extends Cell {
	private static final int SCORE = 50;
	public Bomb() {
		setScoreIncrease(SCORE);
	}
	
	public abstract void action(GameCharacter character);

	@Override
	public String toString() {
		return "bomb";
	}
}
