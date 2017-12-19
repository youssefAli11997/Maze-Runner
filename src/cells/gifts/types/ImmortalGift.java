package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.Immortal;

public class ImmortalGift extends Gift {
	static Logger log = Logger.getLogger(ImmortalGift.class.getName());

	@Override
	public void action(GameCharacter character) {
		log.info("immortal gift applied");

		Immortal newState = new Immortal(character);
		character.setCurrentState(newState);
	}

}
