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
	private  Map<String , Double> rushScoreBoard ;
	private  Map<String , Double> survivalScoreBoard ;
	private static final String rushPath = "rushScoreboard.txt";
	private static final String survivalPath = "survivalScoreboard.txt";
	
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
		rushScoreBoard = new HashMap<>();
		survivalScoreBoard = new HashMap<>();
		load(rushPath, rushScoreBoard);
		load(survivalPath, survivalScoreBoard);
	}
	
	public boolean addScore(String mode , String playerName ,Double score) {
		if(mode.equalsIgnoreCase("rush")) {
			if(rushScoreBoard.containsKey(playerName)) {
				Double currentValue = rushScoreBoard.get(playerName);
				if(score <= currentValue)
					return false;
				rushScoreBoard.put(playerName, score);
				save(rushPath , rushScoreBoard);
				return true;
			}
			else {
				rushScoreBoard.put(playerName, score);
				save(rushPath , rushScoreBoard);
				return true;
			}
		}
		else if (mode.equalsIgnoreCase("survival")) {
			if(survivalScoreBoard.containsKey(playerName)) {
				Double currentValue = survivalScoreBoard.get(playerName);
				if(score <= currentValue)
					return false;
				survivalScoreBoard.put(playerName, score);
				save(survivalPath , survivalScoreBoard);
				return true;
			}
			else {
				survivalScoreBoard.put(playerName, score);
				save(survivalPath , survivalScoreBoard);
				return true;
			}
		}
		return false;
	}
	
	public Map<String , Double> getRushScoreBoard(){
		return sort(rushScoreBoard);
	}
	
	public Map<String , Double> getSurvivalScoreBoard(){
		return sort(survivalScoreBoard);
	}
	
	public void save(String path , Map<String ,Double> toSave) {
		File file = new File(path);
		try {
			FileWriter fw = new FileWriter(file);
			StringBuilder builder = new StringBuilder();
			for(Map.Entry<String,Double > entry : toSave.entrySet()) {
				builder.append(entry.getKey() + " " + entry.getValue() + System.getProperty("line.separator"));
			}
			fw.write(builder.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean load(String path, Map<String , Double> toLoad) {
		File file = new File(path);
		if(!file.exists())
			return false;
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String [] score_board = sc.nextLine().split("\\s+");
				toLoad.put(score_board[0], new Double(score_board[1]));
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
