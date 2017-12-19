package characters;

import org.apache.log4j.Logger;

import constants.Map;
import javafx.scene.image.Image;

/**
 * Created by M.Sharaf on 16/12/2017.
 */
public class PlayerImageFactory {
	static Logger log = Logger.getLogger(PlayerImageFactory.class.getName());

    public static Image setImage(String image) {
        image = image.toLowerCase();
        switch (image) {
            case "dragon":
    			log.info("dragon player is created");
                return Map.PlayerImage.DRAGON;

            case "horse":
    			log.info("horse player is created");
            	return Map.PlayerImage.HORSE;

            case "chicken":
    			log.info("chicken player is created");
            	return Map.PlayerImage.CHICKEN;

            case "person":
    			log.info("person player is created");
            	return Map.PlayerImage.PERSON;

            default:
                //TODO
                return null;
        }
    }
}
