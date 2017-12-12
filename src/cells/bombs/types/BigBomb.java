package cells.bombs.types;

import cells.bombs.Bomb;
import characters.GameCharacter;
import javafx.scene.image.Image;

public class BigBomb extends Bomb {
    private static final Image IMAGE = new Image("assets/img/big-bomb.png");

    public BigBomb() {
        super.cellImage = IMAGE;
        super.animation = true;
    }

    @Override
    public void action(GameCharacter character) {
        character.setHealth(0);
    }
}
