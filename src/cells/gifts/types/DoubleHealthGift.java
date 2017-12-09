package cells.gifts.types;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.DoubleHealth;

public class DoubleHealthGift extends Gift {

	@Override
	public void action(GameCharacter character) {
		DoubleHealth newState = new DoubleHealth(character);
		character.setCurrentState(newState);
	}

}
