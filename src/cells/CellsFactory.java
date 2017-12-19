package cells;

import cells.bombs.BombsFactory;
import cells.gifts.GiftsFactory;
import cells.walls.WallsFactory;
import org.apache.log4j.Logger;

public class CellsFactory {

	static Logger log = Logger.getLogger(CellsFactory.class.getName());

	public static Cell create(String cell) {
		if (cell.equalsIgnoreCase("empty")) {
			log.info("empty cell is created");
			return new EmptyCell();
		} else if (WallsFactory.canCreate(cell)) {
			log.info("wall cell is created");
			return WallsFactory.create(cell);
		} else if (GiftsFactory.canCreate(cell)) {
			log.info("gift cell is created");
			return GiftsFactory.create(cell);
		} else if (BombsFactory.canCreate(cell)) {
			log.info("bomb cell is created");
			return BombsFactory.create(cell);
		}
		return null;
	}

}
