package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.PassThrough;

public class PassThroughGift extends Gift {
	static Logger log = Logger.getLogger(PassThroughGift.class.getName());

	@Override
	public void action(GameCharacter character) {
		log.info("pass through gift applied");

		PassThrough newState = new PassThrough(character);
		character.setCurrentState(newState);
	}

}
