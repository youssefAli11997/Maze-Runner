package utils.weapons;

public abstract class Weapon {
	private int bullets;
<<<<<<< HEAD

	public Weapon() {
||||||| merged common ancestors
    public Weapon() {
=======
>>>>>>> 9f386c58322f1b8e59f285fd86bd558376260513

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
