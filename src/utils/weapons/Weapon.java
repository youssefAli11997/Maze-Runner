package utils.weapons;

import cells.walls.Wall;
import characters.monsters.Monster;

public abstract class Weapon {
	private int bullets;

	public Weapon() {

	}

	public void action(Object object) {

		if (object instanceof Monster) {
			if (!this.isWeaponEmpty()) {
				this.setBullets(this.getBullets() - 1);
				((Monster) object).die();
			}

		} else if (object instanceof Wall) {
			if (!this.isWeaponEmpty()) {
				this.setBullets(this.getBullets() - 1);
				if (((Wall) object).isBreakable() && !((Wall) object).isBreaked()) {
					((Wall) object).setBulletsToBreak(((Wall) object).getBulletsToBreak() - 1);
					if (((Wall) object).getBulletsToBreak() == 0) {
						((Wall) object).setBreaked(true);
					}
				}
			}
		}
	}

	/**
	 * @return the bullets
	 */
	public int getBullets() {
		return bullets;
	}

	/**
	 * @param bullets
	 *            the bullets to set
	 */
	public void setBullets(int bullets) {
		this.bullets = bullets;
	}

	public boolean isWeaponEmpty() {
		return bullets == 0;
	}

}
