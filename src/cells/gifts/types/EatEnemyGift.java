package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.EatEnemy;
import javafx.scene.image.Image;

public class EatEnemyGift extends Gift {
	static Logger log = Logger.getLogger(EatEnemyGift.class.getName());
	private static final Image IMAGE = new Image("assets/img/gift.png");
	public EatEnemyGift() {
		super.cellImage = IMAGE;
        super.animation = true;
	}
	@Override
	public void action(GameCharacter character) {
		log.info("eat enemy gift applied");

		EatEnemy newState = new EatEnemy(character);
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
