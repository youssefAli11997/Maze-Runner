package characters.players;

import java.util.ArrayList;
import characters.players.types.Man;
import characters.players.types.Woman;

public class PlayersFactory {

	private static int row;
	private static int coloumn;

	PlayersFactory(int row, int coloumn) {
		PlayersFactory.row = row;
		PlayersFactory.coloumn = coloumn;
	}

	private static ArrayList<String> players;
	static {
		players = new ArrayList<>();
		players.add("Man");
		players.add("woman");
	}

	public static boolean canCreate(String player) {
		return players.contains(player);
	}

	public static Player create(String player) {
		if (player.equalsIgnoreCase("man"))
			return new Man(row, coloumn);
		else if (player.equalsIgnoreCase("woman"))
			return new Woman(row, coloumn);
		return null;
	}
}
