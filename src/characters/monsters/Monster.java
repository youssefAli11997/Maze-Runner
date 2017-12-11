package characters.monsters;

import characters.GameCharacter;

public abstract class Monster extends GameCharacter {
	public Monster(int currentRow, int currentColumn, int gridRows, int gridColumns) {
		super(currentRow, currentColumn, gridRows, gridColumns);
	}

}
