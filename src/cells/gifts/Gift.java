package cells.gifts;

import cells.Cell;
import characters.GameCharacter;
import game_engine.RenderEngine;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Gift extends Cell {
    private static final Image IMAGE = new Image("assets/img/gift.png");

    public Gift() {
        super.cellImage = IMAGE;
        super.animation = true;
    }

    @Override
    public abstract void action(GameCharacter character);

    @Override
    public String toString() {
        return "gift";
    }
}
