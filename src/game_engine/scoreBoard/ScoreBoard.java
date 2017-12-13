package game_engine.scoreBoard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ScoreBoard {
	private volatile static ScoreBoard uniqueInstance ; // lazy instantiation
	private  Map<String , Double> scoreBoard ;
	private static final String path = "scoreboard.txt";
	
	public static ScoreBoard getInstance() {
		if(uniqueInstance == null) {
			synchronized (ScoreBoard.class) {
				if(uniqueInstance == null)
				uniqueInstance = new ScoreBoard();
			}
		}
		return uniqueInstance;
	}
	
	private ScoreBoard() {
		if(!load(path)) {
			scoreBoard = new HashMap<>();
		}
	}
	
	public boolean addScore(String playerName ,Double score) {
		if(scoreBoard.containsKey(playerName)) {
			Double currentValue = scoreBoard.get(playerName);
			if(score <= currentValue)
				return false;
			scoreBoard.put(playerName, score);
			save(path);
			return true;
		}
		else {
			scoreBoard.put(playerName, score);
			save(path);
			return true;
		}
	}
	
	public Map<String , Double> getScoreBoard(){
		return sort(scoreBoard);
	}
	
	public void save(String path) {
		File file = new File(path);
		try {
			FileWriter fw = new FileWriter(file);
			StringBuilder builder = new StringBuilder();
			for(Map.Entry<String,Double > entry : scoreBoard.entrySet()) {
				builder.append(entry.getKey() + " " + entry.getValue() + System.getProperty("line.separator"));
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
			scoreBoard = new HashMap<>();
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
	
	private Map<String, Double> sort(Map<String, Double> scoreBoard) {
		List<Entry<String , Double>> list = new ArrayList<Entry<String,Double>>(scoreBoard.entrySet());
		Collections.sort(list, new Comparator<Entry<String , Double>>() {

			@Override
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		Map<String , Double> sortedMap = new LinkedHashMap<>();
		for(Entry <String , Double> entry : list)
			sortedMap.put(entry.getKey(), entry.getValue());
		return sortedMap;
	}
}
