package cells.bombs.types;

import org.apache.log4j.Logger;

import cells.bombs.Bomb;
import characters.GameCharacter;
import javafx.scene.image.Image;

public class BigBomb extends Bomb {
	static Logger log = Logger.getLogger(BigBomb.class.getName());

    private static final Image IMAGE = new Image("assets/img/big-bomb.png");

    public BigBomb() {
        super.cellImage = IMAGE;
        super.animation = true;
    }

    @Override
    public void action(GameCharacter character) {
		log.info("big bomb is applied -- dead man -- :)");
        character.setHealth(character.getHealth() - 100);
    }

	@Override
	public void load(Image image) {
		if(image != null) {
			super.cellImage = image;
			super.animation = false;
		}
	}
}
