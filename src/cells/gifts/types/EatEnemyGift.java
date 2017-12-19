package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.EatEnemy;

public class EatEnemyGift extends Gift {
	static Logger log = Logger.getLogger(EatEnemyGift.class.getName());

	@Override
	public void action(GameCharacter character) {
		log.info("eat enemy gift applied");

		EatEnemy newState = new EatEnemy(character);
		character.setCurrentState(newState);
	}

}
