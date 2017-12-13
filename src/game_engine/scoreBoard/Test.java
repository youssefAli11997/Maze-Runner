package game_engine.scoreBoard;

import java.util.Map;
import java.util.Map.Entry;

public class Test {
	public static void main(String [] args) {
		ScoreBoard scoreBoard = ScoreBoard.getInstance();
		scoreBoard.addScore("whatever", 25100.212);
		scoreBoard.addScore("Whatever", 25100.212);
		scoreBoard.addScore("wa645", 201447.0);
		scoreBoard.addScore("eerrer", 1002.22);
		scoreBoard.addScore("wewrwerver", 9420.0);
		Map <String , Double> scoreboard_map = scoreBoard.getScoreBoard();
		for(Entry<String, Double> entry : scoreboard_map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
