package cells.gifts.types;

import org.apache.log4j.Logger;

import cells.gifts.Gift;
import characters.GameCharacter;
import javafx.scene.image.Image;
import utils.weapons.Weapon;

public class BulletGift extends Gift {
	static Logger log = Logger.getLogger(BulletGift.class.getName());
	private static final Image IMAGE = new Image("assets/img/bullet.png");
	public BulletGift() {
		super.cellImage = IMAGE;
        super.animation = true;
	}
	@Override
	public void action(GameCharacter character) {
		log.info("bullet gift applied");

		Weapon weapon = character.getWeapon();
		weapon.setBullets(weapon.getBullets() + 6);
	}
	@Override
	public void load(Image image) {
		if(image != null) {
			super.cellImage = image;
			super.animation = false;
		}
	}
}
