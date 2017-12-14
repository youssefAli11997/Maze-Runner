package gui;

import cells.Cell;
import game_engine.GameEngine;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

/**
 * Created by M.Sharaf on 09/12/2017.
 */

public class GameController {

    private GameEngine gameEngine = GameEngine.getInstance();
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static double windowWidth = screenSize.getWidth(), windowHeight = screenSize.getHeight();
    private Cell[][] maze;
    private int mazeRows, mazeColumns;
    private static GridPane grid;
    private static GraphicsContext graphicsContext;
    private static Image playerImage = new Image("assets/img/player.png");
    private double scrollHValue, scrollVvalue;


    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane gameLayout;

    @FXML
    private HBox infoBar;

    @FXML
    private Canvas canvas;

    @FXML
    void initialize() throws IOException {
        grid = new GridPane();
        gameEngine.setGridPane(grid);
        maze = gameEngine.getMaze();
        mazeRows = maze.length;
        mazeColumns = maze[0].length;

        infoBar.setPrefHeight(windowHeight * .1);
        gameLayout.setPrefHeight(mazeColumns * 70 + 20);
        gameLayout.setPrefWidth(mazeRows * 70 + 20);

        scrollHValue = 70 / (mazeColumns * 70 - windowWidth);
        scrollVvalue = 70 / (mazeRows * 70 - windowHeight);


        initMaze();
        gameLayout.getChildren().add(0, grid);

        graphicsContext = canvas.getGraphicsContext2D();
        canvas.setWidth(mazeRows * 70);
        canvas.setHeight(mazeColumns * 70);
        canvas.getStyleClass().add("red");

        graphicsContext.drawImage(playerImage, 0, 70);
    }

    private void initMaze() {
        for (int i = 0; i < mazeRows; i++) {
            grid.addColumn(i);
            for (int j = 0; j < mazeColumns; j++) {
                maze[j][i].draw(grid, i, j);
            }
        }
    }

    public static void movePlayer(int playerRow, int playerColumn) {
        graphicsContext.clearRect(0, 0, windowWidth, windowHeight);
        graphicsContext.drawImage(playerImage, playerRow, playerColumn);
    }

    @FXML
    void onVScroll() {
        scrollPane.setVvalue(scrollPane.getVvalue() + scrollVvalue);
    }

    @FXML
    void onHScroll() {
        scrollPane.setHvalue(scrollPane.getHvalue() + scrollHValue);
    }

}
