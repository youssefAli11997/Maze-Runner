package utils.weapons;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import cells.Cell;
import cells.walls.Wall;
import characters.monsters.Monster;
import characters.players.Player;
import observer.Observer;
import observer.Subject;

public abstract class Weapon implements Subject{
	private ArrayList<Observer> observers ;
	static Logger log = Logger.getLogger(Weapon.class.getName());

	private int bullets;
	private final int increasedInScore = 3;
	Player player;
	

	public Weapon(Player player) {
		observers = new ArrayList<>();
		this.player = player;
		addObserver(player);
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
	
	@Override
	public void addObserver(Observer ob) {
		observers.add(ob);
	}
	
	@Override
	public void removeObserver(Observer ob) {
		observers.remove(ob);		
	}
	
	@Override
	public void notifyObservers() {
		for(Observer ob : observers)
			ob.update();
	}
}
