package cells.walls;

import cells.Cell;
import characters.GameCharacter;

public class Wall extends Cell {
	private boolean breakable;
	private int bulletsToBreak;
	private int healthDecrease;
	private boolean breaked = false;
	public Wall(boolean breakable, int bulletsToBreak, int healthDecrease) {
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

	//for fire wall affect character health
	public int getHealthDecrease() {
		return healthDecrease;
	}

	//for fire wall affect character health
	public void setHealthDecrease(int healthDecrease) {
		this.healthDecrease = healthDecrease;
	}

	@Override
	public void action(GameCharacter character) {
		// TODO Auto-generated method stub
	}

	/**
	 * @return the breaked
	 */
	public boolean isBreaked() {
		return breaked;
	}

	/**
	 * @param breaked the breaked to set
	 */
	public void setBreaked(boolean breaked) {
		this.breaked = breaked;
	}
}
