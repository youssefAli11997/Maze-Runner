package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.Immortal;
import javafx.scene.image.Image;

public class ImmortalGift extends Gift {
	static Logger log = Logger.getLogger(ImmortalGift.class.getName());
	private static final Image IMAGE = new Image("assets/img/gift.png");
	public ImmortalGift() {
		super.cellImage = IMAGE;
        super.animation = true;
	}
	@Override
	public void action(GameCharacter character) {
		log.info("immortal gift applied");

		Immortal newState = new Immortal(character);
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
