package characters.states;

import characters.CharacterState;
import characters.GameCharacter;
import characters.players.Player;

public class DoubleScore extends CharacterState{

	public DoubleScore(GameCharacter character) {
		super(character);
	}
	
	@Override
	public void setScoreChange(long score) {
		Player player = (Player)getCharacter();
		player.setScore(player.getScore()+ 2 *score);
	}
	
	@Override
	public String toString() {
		return "Double Score";
	}
}
