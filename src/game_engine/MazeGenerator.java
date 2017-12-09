package game_engine;
import cells.Cell;
import cells.EmptyCell;

public class MazeGenerator {

    public Cell[][] create(int rows, int columns){
        return new EmptyCell[rows][columns];
    }
}
