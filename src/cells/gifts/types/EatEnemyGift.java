package cells.gifts.types;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.EatEnemy;

public class EatEnemyGift extends Gift{

	@Override
	public void action(GameCharacter character) {
		EatEnemy newState = new EatEnemy(character);
		character.setCurrentState(newState);		
	}

}
