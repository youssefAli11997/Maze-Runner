package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.states.DoubleScore;
import javafx.scene.image.Image;

public class DoubleScoreGift extends Gift{
	static Logger log = Logger.getLogger(DoubleScoreGift.class.getName());
	private static final Image IMAGE = new Image("assets/img/gift.png");
	public DoubleScoreGift() {
		super.cellImage = IMAGE;
        super.animation = true;
	}
	@Override
	public void action(GameCharacter character) {
		log.info("double score gift applied");

		DoubleScore newState = new DoubleScore(character);
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
