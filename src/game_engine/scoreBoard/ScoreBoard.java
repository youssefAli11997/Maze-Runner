package game_engine.scoreBoard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScoreBoard {
	private static ScoreBoard uniqueInstance = new ScoreBoard();
	private  Map<String , Double> scoreBoard ;
	private static final String path = "scoreboard.txt";
	
	
	private ScoreBoard() {
		if(!load(path)) {
			scoreBoard = new HashMap<>();
		}
	}
	
	public ScoreBoard getUniqueInstance() {
		return uniqueInstance;
	}
	
	public boolean addScore(String playerName ,Double score) {
		if(scoreBoard.containsKey(playerName)) {
			Double currentValue = scoreBoard.get(playerName);
			if(score <= currentValue)
				return false;
			scoreBoard.put(playerName, score);
			return true;
		}
		else {
			scoreBoard.put(playerName, score);
			return true;
		}
	}
	
	public void save(String path) {
		File file = new File(path);
		try {
			FileWriter fw = new FileWriter(file);
			StringBuilder builder = new StringBuilder();
			for(Map.Entry<String,Double > entry : scoreBoard.entrySet()) {
				builder.append(entry.getKey() + " " + entry.getValue());
			}
			fw.write(builder.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean load(String path) {
		File file = new File(path);
		if(!file.exists())
			return false;
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String [] score_board = sc.nextLine().split("\\s+");
				scoreBoard.put(score_board[0], new Double(score_board[1]));
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}
