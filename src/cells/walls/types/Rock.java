package cells.walls.types;

import cells.walls.Wall;
import javafx.scene.image.Image;

public class Rock extends Wall {

    private static final Image IMAGE = new Image("assets/img/rock-wall2.png");

    public Rock() {
        super(false, Integer.MAX_VALUE, 0);

        super.cellImage = IMAGE;
    }
    
    @Override
	public void load(Image image) {
    	if(image != null)
		super.cellImage = image;
	}
}
