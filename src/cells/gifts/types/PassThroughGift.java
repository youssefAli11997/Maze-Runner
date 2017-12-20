package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.PassThrough;
import javafx.scene.image.Image;

public class PassThroughGift extends Gift {
	static Logger log = Logger.getLogger(PassThroughGift.class.getName());
	private static final Image IMAGE = new Image("assets/img/gift.png");
	public PassThroughGift() {
		super.cellImage = IMAGE;
        super.animation = true;
	}
	@Override
	public void action(GameCharacter character) {
		log.info("pass through gift applied");

		PassThrough newState = new PassThrough(character);
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
