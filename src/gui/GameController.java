
package gui;

import game_engine.RenderEngine;
import javafx.animation.Animation;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;

/**
 * Created by M.Sharaf on 09/12/2017.
 */

public class GameController {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double windowWidth = screenSize.getWidth(), windowHeight = screenSize.getHeight();

    @FXML
    private Pane gameLayout;

    @FXML
    private Canvas canvas;

    private GridPane grid;
    private GraphicsContext graphicsContext;
    private static final Image IMAGE = new Image("assets/img/big-bomb.png");

    public void initialize() throws IOException {
        gameLayout.setPrefHeight(windowHeight);
        gameLayout.setPrefWidth(windowWidth);

        final ImageView imageView = new ImageView(IMAGE);
        grid = new GridPane();


        final Animation animation = new RenderEngine(imageView, Duration.seconds(1));

        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        gameLayout.getChildren().add(imageView);

        //graphicsContext = canvas.getGraphicsContext2D();

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

