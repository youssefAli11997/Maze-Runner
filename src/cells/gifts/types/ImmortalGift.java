package cells.gifts.types;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.Immortal;

public class ImmortalGift extends Gift {

	@Override
	public void action(GameCharacter character) {
		Immortal newState = new Immortal(character);
		character.setCurrentState(newState);
	}

}
