package cells.walls;

import cells.Cell;
import characters.GameCharacter;
import javafx.scene.image.Image;

public class Wall extends Cell {
	private static final int SCORE = 30;
	private boolean breakable;
	private int bulletsToBreak;
	private int healthDecrease;
	private boolean breaked = false;

	public Wall(boolean breakable, int bulletsToBreak, int healthDecrease) {
		setScoreIncrease(SCORE);
		this.breakable = breakable;
		this.bulletsToBreak = bulletsToBreak;
		this.healthDecrease = healthDecrease;
	}

	public boolean isBreakable() {
		return breakable;
	}

	public void setBreakable(boolean breakable) {
		this.breakable = breakable;
	}

	public int getBulletsToBreak() {
		return bulletsToBreak;
	}

	public void setBulletsToBreak(int bulletsToBreak) {
		this.bulletsToBreak = bulletsToBreak;
	}

	// for fire wall affect character health
	public int getHealthDecrease() {
		return healthDecrease;
	}

	// for fire wall affect character health
	public void setHealthDecrease(int healthDecrease) {
		this.healthDecrease = healthDecrease;
	}

	@Override
	public void action(GameCharacter character) {

	}

	/**
	 * @return the breaked
	 */
	public boolean isBreaked() {
		return breaked;
	}

	/**
	 * @param breaked
	 *            the breaked to set
	 */
	public void setBreaked(boolean breaked) {
		this.breaked = breaked;
	}

	@Override
	public String toString() {
		return "wall";
	}

	@Override
	public void load(Image image) {
		if(image != null) {
			super.cellImage = image;
		}
	}
}
