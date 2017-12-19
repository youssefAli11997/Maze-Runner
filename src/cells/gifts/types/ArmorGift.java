package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.Armored;

public class ArmorGift extends Gift {
	static Logger log = Logger.getLogger(ArmorGift.class.getName());


	@Override
	public void action(GameCharacter character) {
		log.info("Armor gift applied");

		Armored newState = new Armored(character);
		character.setCurrentState(newState);
	}

}
