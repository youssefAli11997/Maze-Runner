package cells.bombs.types;

import cells.bombs.Bomb;
import characters.GameCharacter;
import javafx.scene.image.Image;

public class SmallBomb extends Bomb {
    private static final Image IMAGE = new Image("assets/img/small-bomb.png");

    public SmallBomb() {
        super.cellImage = IMAGE;
        super.animation = true;
    }

    @Override
    public void action(GameCharacter character) {
        character.setCurrentColumn(character.getHealth() - 10);
    }
}
