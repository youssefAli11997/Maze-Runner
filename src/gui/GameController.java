
package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;

import java.io.IOException;

/**
 * Created by M.Sharaf on 09/12/2017.
 */

public class GameController {
    public Canvas canvas;
    GraphicsContext graphicsContext;

    public void initialize() throws IOException {
        graphicsContext = canvas.getGraphicsContext2D();

        Image img = new Image("Assets/grass.png");
        Image def = new Image("Assets/def.png");
        Image wall = new Image("Assets/wall.png");

        int arr[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0},
                {2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0},
                {2, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                {2, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {2, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {2, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {2, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {2, 1, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    graphicsContext.drawImage(img, i * 70, j * 70);
                } else if (arr[i][j] == 1) {
                    graphicsContext.drawImage(def, i * 70, j * 70);
                } else {
                    graphicsContext.drawImage(wall, i * 70, j * 70);
                }
            }
        }
    }

}

