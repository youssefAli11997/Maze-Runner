package characters.players;

import characters.GameCharacter;
import characters.PlayerImageFactory;

public class Player extends GameCharacter {

	private int lives;
	private String playerName;
	private long Score = 0;
	private static Player ourInstance;

	public static Player getInstance(){
		if(ourInstance != null)
			return ourInstance;
		return null;
	}

	public static Player getInstance(int rows, int columns, int gridRows, int gridColumns) {
		ourInstance = new Player(rows,columns,gridRows,gridColumns);
		return ourInstance;
	}

	private Player(int currentRow, int currentColumn, int gridRows, int gridColumns) {
		super(currentRow, currentColumn, gridRows, gridColumns);
		lives = 3;
	}

	public void setPlayerImage (String image){
		super.setPlayerImage(PlayerImageFactory.setImage(image));
	}

	public int getLives() {
		return lives;
	}

	public void extraLife() {
		this.lives++;
		notifyObservers();
	}

	public void loseLife() {
		if (this.lives == 1) {
			this.die();
		} else {
			this.lives--;
		}
		notifyObservers();
	}
	
	public void setHealth(int health) {
		System.out.println(health);
		if(health <= 0) {
			if(lives > 0) {
				lives --;
				super.setHealth(health + 100);
			}
			else {
				super.setHealth(0);
			}
        }
		else {
			super.setHealth(health);
		}
        notifyObservers();
    }

	public long getScore() {
		return Score;
	}

	public void setScore(long score) {
		Score = score;
		notifyObservers();
	}
	
	public void setScoreChange(long score) {
		super.getCurrentState().setScoreChange(score);
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}
