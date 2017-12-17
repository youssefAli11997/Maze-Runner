package constants;

import javafx.scene.image.Image;

/**
 * Created by M.Sharaf on 07/12/2017.
 */
public class Map {

	public class playerKeys {
		public static final String UP = "w";
		public static final String DOWN = "s";
		public static final String LEFT = "a";
		public static final String RIGHT = "d";
		public static final String FIRE = "x";
	}

	public class CellType {
		public static final int DEFAULT = 0;
		public static final int WALL = 1;
		public static final int BOMB = 2;
		public static final int GIFT = 3;
	}

	public static class PlayerImage{
		public static final Image DRAGON = new Image("assets/img/playerImage/dragon.png");
		public static final Image HORSE = new Image("assets/img/playerImage/horse.png");
		public static final Image CHICKEN = new Image("assets/img/playerImage/chicken.png");
		public static final Image PERSON = new Image("assets/img/playerImage/person.png");
	}

	public class PlayerDirection {
		public static final int DOWN = 0;
		public static final int LEFT = 1;
		public static final int RIGHT = 2;
		public static final int UP = 3;
	}

	public class BombType {

	}

	public class GiftType {

	}

	public class WeaponType {

	}


}
