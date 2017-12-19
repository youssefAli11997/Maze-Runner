package game_engine.scoreBoard;

import java.util.Map;
import java.util.Map.Entry;

public class Test {
	public static void main(String [] args) {
		ScoreBoard scoreBoard = ScoreBoard.getInstance();
		scoreBoard.addScore("survival" ,"tototo", 123123.212);
		scoreBoard.addScore("rush" , "Whatever", 25100.212);
		scoreBoard.addScore("rush" , "wa645", 201447.0);
		scoreBoard.addScore("survival" , "eerrer", 1002.22);
		scoreBoard.addScore("survival" , "wewrwerver", 9420.0);
		Map <String , Double> scoreboard_map = scoreBoard.getRushScoreBoard();
		for(Entry<String, Double> entry : scoreboard_map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		scoreboard_map = scoreBoard.getSurvivalScoreBoard();
		for(Entry<String, Double> entry : scoreboard_map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
