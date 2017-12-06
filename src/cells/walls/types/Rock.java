package cells.walls.types;

import cells.walls.Wall;

public class Rock extends Wall {
    public Rock(int row, int column) {
        super(row, column, false, Integer.MAX_VALUE, 0);
    }
}
