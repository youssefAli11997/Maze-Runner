package characters.players;

import characters.GameCharacter;

public class Player extends GameCharacter {

	private int lives;

	public Player(int currentRow, int currentColumn, int gridRows, int gridColumns) {
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
}
