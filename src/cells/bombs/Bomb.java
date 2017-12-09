package cells.bombs;

import cells.Cell;
import characters.GameCharacter;

public abstract class Bomb extends Cell {

	public abstract void action(GameCharacter character);
}
