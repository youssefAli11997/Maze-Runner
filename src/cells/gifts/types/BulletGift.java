package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import utils.weapons.Weapon;

public class BulletGift extends Gift {
	static Logger log = Logger.getLogger(BulletGift.class.getName());

	@Override
	public void action(GameCharacter character) {
		log.info("bullet gift applied");

		Weapon weapon = character.getWeapon();
		weapon.setBullets(weapon.getBullets() + 6);
	}
}
