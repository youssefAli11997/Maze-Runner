package cells;

import cells.bombs.BombsFactory;
import cells.gifts.GiftsFactory;
import cells.walls.WallsFactory;

public class CellsFactory {
	public static Cell create(String cell) {
		if(cell.equalsIgnoreCase("empty"))
			return new EmptyCell();
		else if(WallsFactory.canCreate(cell))
			return WallsFactory.create(cell);
		else if(GiftsFactory.canCreate(cell))
			return GiftsFactory.create(cell);
		else if(BombsFactory.canCreate(cell))
			return BombsFactory.create(cell);
		return null;
	}
    
}
