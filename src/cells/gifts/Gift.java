package cells.gifts;

import cells.Cell;

public  abstract class Gift extends Cell {
    public Gift(int row, int column) {
        super(row, column);
    }

    @Override
    public void draw() {

    }

    @Override
    public abstract void action(Character character);
}
