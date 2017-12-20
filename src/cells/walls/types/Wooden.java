package cells.walls.types;

import cells.walls.Wall;
import javafx.scene.image.Image;

public class Wooden extends Wall {

	private static final Image IMAGE = new Image("assets/img/wooden-wall.png");

    public Wooden() {
        super(true, 1, 0);

        super.cellImage = IMAGE;
    }
    
    @Override
	public void load(Image image) {
    	if(image != null)
    		super.cellImage = image;
	}
}
