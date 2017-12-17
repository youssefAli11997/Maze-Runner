package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.NoFire;

public class NoFireGift extends Gift {
	static Logger log = Logger.getLogger(NoFireGift.class.getName());

	@Override
	public void action(GameCharacter character) {
		log.info("no fire gift applied");

		NoFire newState = new NoFire(character);
		character.setCurrentState(newState);
	}

}
