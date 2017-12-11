package characters.monsters;

import java.util.ArrayList;

import characters.monsters.types.DynamicMonster;
import characters.monsters.types.StaticMonster;


public class MonstersFactory {

	private static int row;
	private static int coloumn;
	private static int gridRows;
	private static int gridColoumns;
	
	MonstersFactory (int row , int coloumn, int gridRows, int gridColumns){
		MonstersFactory.row = row;
		MonstersFactory.coloumn = coloumn;
		MonstersFactory.gridRows = gridRows;
		MonstersFactory.gridColoumns = gridColumns;
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
		if (monster.equalsIgnoreCase("dynamic"))
			return new DynamicMonster(row, coloumn,gridRows,gridColoumns);
		else if (monster.equalsIgnoreCase("static"))
			return new StaticMonster(row, coloumn,gridRows, gridColoumns);
		return null;
	}
}
