package game_engine.scoreBoard;

import characters.players.Player;

public interface ScoreStrategy {
	public double score(double time , Player player);
}
