package cells.bombs.types;

import org.apache.log4j.Logger;

import cells.bombs.Bomb;
import characters.GameCharacter;
import javafx.scene.image.Image;

public class SmallBomb extends Bomb {
	static Logger log = Logger.getLogger(SmallBomb.class.getName());

    private static final Image IMAGE = new Image("assets/img/small-bomb.png");

    public SmallBomb() {
        super.cellImage = IMAGE;
        super.animation = true;
    }

    @Override
    public void action(GameCharacter character) {
		log.info("small bomb is applied decreas in health");
		character.setHealth(character.getHealth() - 10);
    }

	@Override
	public void load(Image image) {
		if(image != null) {
			super.cellImage = image;
			super.animation = false;
		}
	}
}
