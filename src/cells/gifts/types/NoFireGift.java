package cells.gifts.types;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.NoFire;

public class NoFireGift extends Gift {

	@Override
	public void action(GameCharacter character) {
		NoFire newState = new NoFire(character);
		character.setCurrentState(newState);
	}

}
