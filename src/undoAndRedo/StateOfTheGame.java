package undoAndRedo;

import cells.Cell;

public class StateOfTheGame {

	private int score;
	private Cell[][] maze;
	private int currentRow;
	private int currentColumn;
	private int playerHealth;
	private int playerLives;
	private long time;
	private int[][] enemyPlaces;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Cell[][] getMaze() {
		return maze;
	}

	public void setMaze(Cell[][] maze) {
		this.maze = maze;
	}

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public int getCurrentColumn() {
		return currentColumn;
	}

	public void setCurrentColumn(int currentColumn) {
		this.currentColumn = currentColumn;
	}

	public int getPlayerHealth() {
		return playerHealth;
	}

	public void setPlayerHealth(int playerHealth) {
		this.playerHealth = playerHealth;
	}

	public int getPlayerLives() {
		return playerLives;
	}

	public void setPlayerLives(int playerLives) {
		this.playerLives = playerLives;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int[][] getEnemyPlaces() {
		return enemyPlaces;
	}

	public void setEnemyPlaces(int[][] enemyPlaces) {
		this.enemyPlaces = enemyPlaces;
	}

}
