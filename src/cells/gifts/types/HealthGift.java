package cells.gifts.types;

import cells.gifts.Gift;
import characters.GameCharacter;

public class HealthGift extends Gift {
	
	@Override
	public void action(GameCharacter character) {
		character.setHealthChange(10);	
	}
}
