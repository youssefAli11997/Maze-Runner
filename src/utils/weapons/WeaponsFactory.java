package utils.weapons;

import java.util.ArrayList;
import utils.weapons.types.Gun;
import utils.weapons.types.Sword;

public class WeaponsFactory {
	private static ArrayList<String> weapons;
	static {
		weapons = new ArrayList<>();
		weapons.add("gun");
		weapons.add("sword");
	}

	public static boolean canCreate(String weapon) {
		return weapons.contains(weapon);
	}

	public static Weapon create(String weapon) {
		if (weapon.equalsIgnoreCase("gun"))
			return new Gun();
		else if (weapon.equalsIgnoreCase("sword"))
			return new Sword();
		return null;
	}
}
