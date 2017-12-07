package cells;

import java.awt.*;

public abstract class Cell {
    private int row;
    private int column;

    public Cell(int row, int column){
        this.row = row;
        this.column = column;
    }

    public Point getIndex(){
        return new Point(row, column);
    }

    public void setIndex(Point index){
        row = ((int) index.getX());
        column = ((int) index.getY());
    }

    public void draw() {}

    public abstract void action();

}
