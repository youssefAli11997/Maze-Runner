package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.DoubleHealth;

public class DoubleHealthGift extends Gift {
	static Logger log = Logger.getLogger(DoubleHealthGift.class.getName());

	@Override
	public void action(GameCharacter character) {
		log.info("double health gift applied");

		DoubleHealth newState = new DoubleHealth(character);
		character.setCurrentState(newState);
	}

}
