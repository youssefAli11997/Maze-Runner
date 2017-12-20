
package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.players.Player;
import javafx.scene.image.Image;

public class ScoreGift extends Gift{
	static Logger log = Logger.getLogger(ScoreGift.class.getName());
	private static final Image IMAGE = new Image("assets/img/dollar.png");
	public ScoreGift() {
		super.cellImage = IMAGE;
        super.animation = true;
	}
	private final int IncreasedInScore = 20; 
	@Override
	public void action(GameCharacter character) {
		log.info("score gift applied");

		((Player)character).setScoreChange(IncreasedInScore);
	}
	@Override
	public void load(Image image) {
		if(image != null) {
			super.cellImage = image;
			super.animation = false;
		}
	}

}
