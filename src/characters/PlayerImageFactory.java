package characters;

import constants.Map;
import javafx.scene.image.Image;

/**
 * Created by M.Sharaf on 16/12/2017.
 */
public class PlayerImageFactory {
    public static Image setImage(String image) {
        switch (image) {
            case "dragon":
                return Map.PlayerImage.dragon;

            default:
                //TODO
                return null;
        }
    }
}
