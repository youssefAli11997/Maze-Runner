
package gui;

import cells.Cell;
import game_engine.Game;
import game_engine.GameEngine;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.IOException;

/**
 * Created by M.Sharaf on 09/12/2017.
 */

public class GameController {

    private GameEngine gameEngine = GameEngine.getInstance();
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double windowWidth = screenSize.getWidth(), windowHeight = screenSize.getHeight();
    private Cell[][] maze;

    @FXML
    private Pane gameLayout;

    @FXML
    private HBox infoBar;

    @FXML
    private Canvas canvas;

    private GridPane grid;
    private GraphicsContext graphicsContext;

    public void initialize() throws IOException {
        grid = new GridPane();
        gameEngine.setGridPane(grid);
        maze = gameEngine.getMaze();

        infoBar.setPrefHeight(windowHeight * .1);
        gameLayout.setPrefHeight(windowHeight);
        gameLayout.setPrefWidth(windowWidth);

        initMaze();
        gameLayout.getChildren().add(grid);
    }

    private void initMaze() {
        for (int i = 0; i < maze.length; i++) {
            grid.addColumn(i);
            for (int j = 0; j < maze[0].length; j++) {
                maze[j][i].draw(grid, i, j);
            }
        }
    }

}

