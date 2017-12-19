package utils.weapons;

import org.apache.log4j.Logger;

import cells.Cell;
import cells.walls.Wall;
import characters.monsters.Monster;
import characters.players.Player;

public abstract class Weapon {
	static Logger log = Logger.getLogger(Weapon.class.getName());

	private int bullets;
	private final int increasedInScore = 3;
	Player player;
	

	public Weapon(Player player) {
		this.player = player;
	}

	public void action(Object object) {

		if (object instanceof Monster) {
			log.info("player is shooting the emeny");
			if (!this.isWeaponEmpty()) {
				this.setBullets(this.getBullets() - 1);
				((Monster) object).die();
				player.setScore(player.getScore() + increasedInScore);
			}

		} else if (object instanceof Wall) {
			if (!this.isWeaponEmpty()) {
				log.info("player is shooting the wall");
				this.setBullets(this.getBullets() - 1);
				if (((Wall) object).isBreakable() && !((Wall) object).isBreaked()) {
					((Wall) object).setBulletsToBreak(((Wall) object).getBulletsToBreak() - 1);
					if (((Wall) object).getBulletsToBreak() == 0) {
						((Wall) object).setBreaked(true);
						player.setScore(player.getScore() + ((Cell)object).getScoreIncrease());
					}
				}
			}
		} else {
			player.setScore(player.getScore() + ((Cell)object).getScoreIncrease());
			log.info("adding score to the player");
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
