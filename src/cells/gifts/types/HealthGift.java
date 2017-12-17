package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;

public class HealthGift extends Gift {
	static Logger log = Logger.getLogger(HealthGift.class.getName());

	@Override
	public void action(GameCharacter character) {
		log.info("health gift applied");

		character.setHealthChange(10);
	}
}
