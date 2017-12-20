package cells;

import org.apache.log4j.Logger;

import characters.GameCharacter;
import javafx.scene.image.Image;

public class EmptyCell extends Cell {
	static Logger log = Logger.getLogger(EmptyCell.class.getName());

    private static final Image IMAGE = new Image("assets/img/empty-cell.png");

    public EmptyCell() {
        super.cellImage = IMAGE;
    }

    @Override
    public void action(GameCharacter character) {
		log.info("empty cell action applied");
    }

    @Override
    public String toString() {
        return "empty";
    }

	@Override
	public void load(Image image) {
		if(image != null) {
			super.cellImage = image;
			super.animation = false;
		}
	}
}
