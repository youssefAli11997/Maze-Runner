package utils.weapons.types;

import characters.players.Player;
import utils.weapons.Weapon;

public class Sword extends Weapon {
	private static final int MAX = 9999999;
	public Sword(Player player) {
		super(player);
		setInitialBullets();
	}
	
	public void setInitialBullets() {
		super.setBullets(MAX);
	}
	
	@Override
	public String toString() {
		return "Sword";
	}
}
