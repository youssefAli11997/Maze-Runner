package cells.gifts.types;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.Armored;

public class ArmorGift extends Gift {

	@Override
	public void action(GameCharacter character) {
		Armored newState = new Armored(character);
		character.setCurrentState(newState);
	}

}
