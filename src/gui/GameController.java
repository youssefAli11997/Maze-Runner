
package gui;

import game_engine.RenderEngine;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Created by M.Sharaf on 09/12/2017.
 */

public class GameController {
    public Canvas canvas;
    public Pane mainLayout;
    GraphicsContext graphicsContext;

    private static final int COLUMNS  =   4;
    private static final int COUNT    =  10;
    private static final int OFFSET_X =  18;
    private static final int OFFSET_Y =  25;
    private static final int WIDTH    = 374;
    private static final int HEIGHT   = 243;
    //private static final Image IMAGE = new Image("Assets/The_Horse_in_Motion.jpg");


    public void initialize() throws IOException {

        //final ImageView imageView = new ImageView(IMAGE);


        /*final Animation animation = new RenderEngine(
                imageView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();*/

        /*imageView.setOnMouseClicked(event -> {
            System.out.println("lol");
        });
        imageView.getStyleClass().add("border");
        mainLayout.getChildren().add(imageView);

        graphicsContext = canvas.getGraphicsContext2D();

        Image img = new Image("Assets/grass.png");
        Image def = new Image("Assets/def.png");
        Image wall = new Image("Assets/wall.png");*/

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

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                if (arr[i][j] == 0) {
//                    graphicsContext.drawImage(img, j * 70, i * 70);
//                } else if (arr[i][j] == 1) {
//                    graphicsContext.drawImage(def, j * 70, i * 70);
//                } else {
//                    graphicsContext.drawImage(wall, j * 70, i * 70);
//                }
//            }
//        }
    }


}

