package cells.gifts.types;

import cells.gifts.Gift;
import characters.GameCharacter;

public class Health extends Gift {


	@Override
	public void action(GameCharacter character) {
		character.setCurrentColumn(character.getHealth() + 10);		
	}
}
