package utils.weapons.types;

import characters.players.Player;
import utils.weapons.Weapon;

public class Gun extends Weapon {
	public Gun(Player player) {
		super(player);
		setInitialBullets();
	}

	public void setInitialBullets() {
		super.setBullets(6);
	}
	
	@Override
	public String toString() {
		return "Gun";
	}
}
