package cells.walls.types;

import org.apache.log4j.Logger;
import cells.walls.Wall;
import characters.GameCharacter;
import javafx.scene.image.Image;


public class Fire extends Wall {
	static Logger log = Logger.getLogger(Fire.class.getName());

    private static final Image IMAGE = new Image("assets/img/fire.png");

    private final int decreaseInHealth = 10;

    public Fire() {
        super(false, Integer.MAX_VALUE, -1);

        super.cellImage = IMAGE;
        super.animation = true;
    }

    @Override
    public void action(GameCharacter character) {
		log.info("fire wall action is applied -- decrease in health");

        if (this instanceof Fire) {
            character.setHealth(character.getHealth() - decreaseInHealth);
        }
    }
    
    @Override
	public void load(Image image) {
    	if(image != null)
    		super.cellImage = image;
	}
}
