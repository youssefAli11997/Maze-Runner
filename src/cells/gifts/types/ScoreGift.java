
package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.players.Player;

public class ScoreGift extends Gift{
	static Logger log = Logger.getLogger(ScoreGift.class.getName());

	private final int IncreasedInScore = 5; 
	@Override
	public void action(GameCharacter character) {
		log.info("score gift applied");

		((Player)character).setScore(((Player)character).getScore() + IncreasedInScore);
	}

}
