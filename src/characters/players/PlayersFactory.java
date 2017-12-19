

/*
package characters.players;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import characters.players.types.Man;
import characters.players.types.Woman;

public class PlayersFactory {
	static Logger log = Logger.getLogger(PlayersFactory.class.getName());

	private static int row;
	private static int coloumn;
	private static int gridRows;
	private static int gridColumns;
	
	PlayersFactory(int row, int coloumn, int gridRows, int gridColumns) {
		PlayersFactory.row = row;
		PlayersFactory.coloumn = coloumn;
		PlayersFactory.gridRows = gridRows;
		PlayersFactory.gridColumns = gridColumns;
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
		if (player.equalsIgnoreCase("man")){
		    log.info("man player is created");
			return new Man(row, coloumn,gridRows, gridColumns);}
		else if (player.equalsIgnoreCase("woman")){
		    log.info("woman player is created");
			return new Woman(row, coloumn,gridRows, gridColumns);}
		return null;
	}
}
*/
