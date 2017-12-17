package game_engine.scoreBoard;

import characters.players.Player;

public class SurvivalScore implements ScoreStrategy{

	@Override
	public double score(double time, Player player) {
		return player.getLives()*100 + 1000 * time + player.getScore();
	}
	
}
