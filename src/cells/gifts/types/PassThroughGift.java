package cells.gifts.types;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.PassThrough;

public class PassThroughGift extends Gift {

	@Override
	public void action(GameCharacter character) {
		
		PassThrough newState = new PassThrough(character);
		character.setCurrentState(newState);		
	}

}
