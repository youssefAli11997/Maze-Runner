package cells.bombs;

import cells.Cell;

public abstract class Bomb extends Cell {
    public Bomb(int row, int column) {
        super(row, column);
    }

    @Override
    public abstract void action(Character character);

}
