package cells.weapons;

import cells.Cell;

public abstract class Weapon extends Cell {
    public Weapon(int row, int column) {
        super(row, column);
    }

    public abstract void action();
}
