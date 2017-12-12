package cells;

import characters.GameCharacter;
import game_engine.RenderEngine;
import javafx.animation.Animation;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public abstract class Cell {
    protected Image cellImage;
    protected boolean animation;
    private ImageView imageView;

    //TODO not in proper place !!
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    public void draw(GridPane gridPane, int row, int column) {
        imageView = new ImageView(cellImage);

        if (animation){
            Animation animation = new RenderEngine(imageView, Duration.seconds(1));
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();
        }

        //if was cell -> replace it, if not add the new one
        Node destroyedCell = getNodeFromGridPane(gridPane, row, column);
        if (destroyedCell != null){//check if not working properly
            destroyedCell = imageView;
        } else {
            gridPane.add(imageView, row, column);
        }
    }

    public abstract void action(GameCharacter character);

}
