package cells.gifts;

import cells.Cell;

public abstract  class Gift extends Cell {
    public Gift(int row, int column) {
        super(row, column);
    }

    public abstract void action();
}
