package characters.monsters;

import java.util.ArrayList;

import characters.monsters.types.DynamicMonster;
import characters.monsters.types.StaticMonster;


public class MonstersFactory {

	private static int row;
	private static int coloumn;
	MonstersFactory (int row , int coloumn){
		MonstersFactory.row = row;
		MonstersFactory.coloumn = coloumn;
	}
	
	private static ArrayList<String> monsters;
	static {
		monsters = new ArrayList<>();
		monsters.add("dynamic");
		monsters.add("static");
	}

	public static boolean canCreate(String monster) {
		return monsters.contains(monster);
	}

	public static Monster create(String monster) {
		if (monster.equalsIgnoreCase("dunamic"))
			return new DynamicMonster(row, coloumn);
		else if (monster.equalsIgnoreCase("static"))
			return new StaticMonster(row, coloumn);
		return null;
	}
}
