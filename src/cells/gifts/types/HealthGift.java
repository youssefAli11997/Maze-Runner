package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import javafx.scene.image.Image;

public class HealthGift extends Gift {
	static Logger log = Logger.getLogger(HealthGift.class.getName());
	private static final Image IMAGE = new Image("assets/img/heart.png");
	public HealthGift() {
		super.cellImage = IMAGE;
        super.animation = true;
	}
	@Override
	public void action(GameCharacter character) {
		log.info("health gift applied");

		character.setHealthChange(10);
	}
	@Override
	public void load(Image image) {
		if(image != null) {
			super.cellImage = image;
			super.animation = false;
		}
	}
}
