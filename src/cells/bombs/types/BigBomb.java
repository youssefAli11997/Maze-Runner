package cells.bombs.types;

import cells.bombs.Bomb;
import characters.GameCharacter;

public class BigBomb extends Bomb {

	@Override
	public void action(GameCharacter character) {
		character.setHealth(0);
	}
}
