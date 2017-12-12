package cells.walls.types;

import cells.walls.Wall;
import characters.GameCharacter;
import game_engine.RenderEngine;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Fire extends Wall {
    private static final Image IMAGE = new Image("assets/img/fire.png");

    private final int decreaseInHealth = 10;

    public Fire() {
        super(false, Integer.MAX_VALUE, -1);

        super.cellImage = IMAGE;
        super.animation = true;
    }

    @Override
    public void action(GameCharacter character) {

        if (this instanceof Fire) {
            character.setHealth(character.getHealth() - decreaseInHealth);
        }
    }
}
