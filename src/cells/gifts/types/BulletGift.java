package cells.gifts.types;

import cells.gifts.Gift;
import characters.GameCharacter;
import utils.weapons.Weapon;

public class BulletGift extends Gift {


	@Override
	public void action(GameCharacter character) {
		Weapon  weapon =character.getWeapon();
		weapon.setBullets(weapon.getBullets() + 10);
	}
}
