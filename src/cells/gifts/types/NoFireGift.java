package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.NoFire;
import javafx.scene.image.Image;

public class NoFireGift extends Gift {
	static Logger log = Logger.getLogger(NoFireGift.class.getName());
	private static final Image IMAGE = new Image("assets/img/gift.png");
	public NoFireGift() {
		super.cellImage = IMAGE;
        super.animation = true;
	}
	@Override
	public void action(GameCharacter character) {
		log.info("no fire gift applied");

		NoFire newState = new NoFire(character);
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
