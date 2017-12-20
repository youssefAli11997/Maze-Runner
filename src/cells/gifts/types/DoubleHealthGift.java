package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.DoubleHealth;
import javafx.scene.image.Image;

public class DoubleHealthGift extends Gift {
	static Logger log = Logger.getLogger(DoubleHealthGift.class.getName());
	private static final Image IMAGE = new Image("assets/img/gift.png");
	public DoubleHealthGift() {
		super.cellImage = IMAGE;
        super.animation = true;
	}
	@Override
	public void action(GameCharacter character) {
		log.info("double health gift applied");

		DoubleHealth newState = new DoubleHealth(character);
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
