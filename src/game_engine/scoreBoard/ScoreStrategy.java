package game_engine.scoreBoard;

import characters.players.Player;

public interface ScoreStrategy {
	public double getScore(double time , Player player);
}
