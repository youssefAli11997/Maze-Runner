package cells.bombs.types;

import cells.bombs.Bomb;
import characters.GameCharacter;

public class SmallBomb extends Bomb {

	@Override
	public void action(GameCharacter character) {
		character.setCurrentColumn(character.getHealth() - 10);
	}
}
