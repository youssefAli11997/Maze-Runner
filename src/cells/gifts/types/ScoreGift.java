package cells.gifts.types;

import cells.gifts.Gift;
import characters.GameCharacter;
import characters.players.Player;

public class ScoreGift extends Gift{

	private final int IncreasedInScore = 5; 
	@Override
	public void action(GameCharacter character) {
		((Player)character).setScore(((Player)character).getScore() + IncreasedInScore);
	}

}
