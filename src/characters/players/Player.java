package characters.players;

import characters.GameCharacter;

public class Player extends GameCharacter {

	private int lives;
	private String playerName;
	private long Score;
	private static Player ourInstance;

	public static Player getInstance(){
		if(ourInstance != null)
			return ourInstance;
		return null;
	}

	public static Player getInstance(int rows, int columns, int gridRows, int gridColumns) {
		if(ourInstance == null){
			ourInstance = new Player(rows,columns,gridRows,gridColumns);
		}
		return ourInstance;
	}

	private Player(int currentRow, int currentColumn, int gridRows, int gridColumns) {
		super(currentRow, currentColumn, gridRows, gridColumns);
	}

	public int getLives() {
		return lives;
	}

	public void extraLife() {
		this.lives++;
	}

	public void loseLife() {
		if (this.lives == 1) {
			this.die();
		} else {
			this.lives--;
		}
	}


	public long getScore() {
		return Score;
	}

	public void setScore(long score) {
		Score = score;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}
