package utils.weapons;

public abstract class Weapon {
	private int bullets;

	public Weapon() {

	}

	public abstract void action();

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

}
