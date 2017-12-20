package cells;

import org.apache.log4j.Logger;

import characters.GameCharacter;
import game_engine.RenderEngine;
import javafx.animation.Animation;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public abstract class Cell {
	static Logger log = Logger.getLogger(Cell.class.getName());
	private int scoreIncrease = 0 ;
	protected Image cellImage;
    protected boolean animation;
    private ImageView imageView;
    private boolean firstCreation = true;

    //TODO not in proper place !!
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        System.out.println(gridPane);
        for (Node node : gridPane.getChildren()) {
            System.out.println(GridPane.getColumnIndex(node));
            if (gridPane.getColumnIndex(node) == col && gridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    public void draw(GridPane gridPane, int row, int column) {
        imageView = new ImageView(cellImage);

        if (animation) {
            Animation animation = new RenderEngine(imageView, Duration.seconds(1));
            animation.setCycleCount(Animation.INDEFINITE);
            animation.play();
        }

        //if was cell -> replace it, if not add the new one

        Node destroyedCell = null;

        if (!firstCreation) {
            destroyedCell = getNodeFromGridPane(gridPane, row, column);
            firstCreation = false;
        }
        if (destroyedCell != null) {//check if not working properly
            destroyedCell = imageView;
        } else {
            gridPane.add(imageView, row, column);
        }
    }

    public abstract void action(GameCharacter character);
    
    public int getScoreIncrease() {
		return scoreIncrease;
	}

	public void setScoreIncrease(int scoreIncrease) {
		this.scoreIncrease = scoreIncrease;
	}
    
	public abstract void load(Image image);
}
