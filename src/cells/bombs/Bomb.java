package cells.bombs;

import cells.Cell;
import characters.GameCharacter;

public abstract class Bomb extends Cell {
    public Bomb(int row, int column) {
        super(row, column);
    }

    public abstract void action(GameCharacter character);

}
