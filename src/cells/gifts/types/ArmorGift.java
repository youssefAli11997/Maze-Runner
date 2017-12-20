package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.Armored;
import javafx.scene.image.Image;

public class ArmorGift extends Gift {
	static Logger log = Logger.getLogger(ArmorGift.class.getName());
	private static final Image IMAGE = new Image("assets/img/gift.png");
	public ArmorGift() {
		super.cellImage = IMAGE;
        super.animation = true;
	}

	@Override
	public void action(GameCharacter character) {
		log.info("Armor gift applied");

		Armored newState = new Armored(character);
		character.setCurrentState(newState);
	}

	@Override
	public void load(Image image) {
		if(image != null) {
			super.cellImage = image;
			super.animation = false;
		}
	}

}
