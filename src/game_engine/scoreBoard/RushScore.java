package game_engine.scoreBoard;

import characters.players.Player;

public class RushScore implements ScoreStrategy{

	@Override
	public double getScore(double time, Player player) {
		return player.getLives()*100 + 1000 * (1/time) + player.getScore();
	}

}
