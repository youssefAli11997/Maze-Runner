package cells.walls.types;

import cells.walls.Wall;
import characters.GameCharacter;

public class Fire extends Wall {
	
	private final int decreaseInHealth = 10;
	
	public Fire() {
		super(false, Integer.MAX_VALUE, -1);
	}

	@Override
	public void action(GameCharacter character) {

		if (this instanceof Fire) {
			character.setHealth(character.getHealth() - decreaseInHealth);
		}
	}
}
