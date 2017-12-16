package utils.weapons;

import cells.walls.Wall;
import characters.monsters.Monster;
import characters.players.Player;

public abstract class Weapon {
	private int bullets;
	private final int increasedInScore = 3;
	Player player;
	

	public Weapon(Player player) {
		this.player = player;
	}

	public void action(Object object) {

		if (object instanceof Monster) {
			if (!this.isWeaponEmpty()) {
				this.setBullets(this.getBullets() - 1);
				((Monster) object).die();
				player.setScore(player.getScore() + increasedInScore);
			}

		} else if (object instanceof Wall) {
			if (!this.isWeaponEmpty()) {
				this.setBullets(this.getBullets() - 1);
				if (((Wall) object).isBreakable() && !((Wall) object).isBreaked()) {
					((Wall) object).setBulletsToBreak(((Wall) object).getBulletsToBreak() - 1);
					if (((Wall) object).getBulletsToBreak() == 0) {
						((Wall) object).setBreaked(true);
						player.setScore(player.getScore() + increasedInScore);
					}
				}
			}
		} else {
			player.setScore(player.getScore() + increasedInScore);
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
