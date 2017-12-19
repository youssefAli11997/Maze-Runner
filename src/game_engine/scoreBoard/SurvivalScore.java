package game_engine.scoreBoard;

import characters.players.Player;

public class SurvivalScore implements ScoreStrategy{

	@Override
	public double getScore(double time, Player player) {
		return player.getLives()*100 + 1000 * time + player.getScore();
	}
	
}
