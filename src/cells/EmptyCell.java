package cells;

import characters.GameCharacter;
import javafx.scene.image.Image;

public class EmptyCell extends Cell {
    private static final Image IMAGE = new Image("assets/img/empty-cell.png");

    public EmptyCell() {
        super.cellImage = IMAGE;
    }

    @Override
    public void action(GameCharacter character) {
    }

    @Override
    public String toString() {
        return "empty";
    }
}
