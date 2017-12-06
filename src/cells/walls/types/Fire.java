package cells.walls.types;

import cells.walls.Wall;

public class Fire extends Wall {
    public Fire(int row, int column) {
        super(row, column, false, Integer.MAX_VALUE, -1);
    }
}
