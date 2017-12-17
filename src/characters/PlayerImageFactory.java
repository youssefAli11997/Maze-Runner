package characters;

import constants.Map;
import javafx.scene.image.Image;

/**
 * Created by M.Sharaf on 16/12/2017.
 */
public class PlayerImageFactory {
    public static Image setImage(String image) {
        image = image.toLowerCase();
        switch (image) {
            case "dragon":
                return Map.PlayerImage.DRAGON;

            case "horse":
                return Map.PlayerImage.HORSE;

            case "chicken":
                return Map.PlayerImage.CHICKEN;

            case "person":
                return Map.PlayerImage.PERSON;

            default:
                //TODO
                return null;
        }
    }
}
