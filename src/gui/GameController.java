package gui;

import cells.Cell;
import characters.players.Player;
import constants.Map;
import game_engine.GameEngine;
import game_engine.timer.Timer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import observer.Observer;
import observer.Subject;
import observer.TimerObserver;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by M.Sharaf on 09/12/2017.
 */

public class GameController implements TimerObserver{

    private GameEngine gameEngine = GameEngine.getInstance();
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static double windowWidth = screenSize.getWidth(), windowHeight = screenSize.getHeight();
    private static Timer timer ;
    private Cell[][] maze;
    private static int mazeRows, mazeColumns;
    private static GridPane grid;
    private static GraphicsContext graphicsContext;
    private static Image playerImage = new Image("assets/img/player.png");
    private double scrollHValue, scrollVvalue;

    private Player player = Player.getInstance();


    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane gameLayout;

    @FXML
    private HBox infoBar;

    @FXML
    private Canvas canvas;
    
    @FXML
    private Label timerLabel;
    @FXML
    void initialize() throws IOException, InterruptedException {
    	timer= new Timer("survival", 20000);
        grid = new GridPane();
        gameEngine.setGridPane(grid);
        gameEngine.attach(timer);
        timer.addObserver(this);
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
        player.setPlayerImage(MenuController.playerImage);
        player.draw(Map.PlayerDirection.RIGHT, 1, 0);
        gameLayout.getChildren().add(player.getPlayerImageView());

        graphicsContext = canvas.getGraphicsContext2D();
        canvas.setWidth(mazeRows * 70);
        canvas.setHeight(mazeColumns * 70);
        canvas.getStyleClass().add("red");
    }

    private void initMaze() {
        for (int i = 0; i < mazeRows; i++) {
            grid.addColumn(i);
            for (int j = 0; j < mazeColumns; j++) {
                maze[j][i].draw(grid, i, j);
            }
        }
    }

    @FXML
    void onVScroll() {
        scrollPane.setVvalue(scrollPane.getVvalue() + scrollVvalue);
    }

    @FXML
    void onHScroll() {
        scrollPane.setHvalue(scrollPane.getHvalue() + scrollHValue);
    }

	@Override
	public void update(Subject sb) {
	}

	@Override
	public void update(double time) {
		DateFormat timeFormat = new SimpleDateFormat( "mm:ss" );
		timerLabel.setText(timeFormat.format(time));
	}

}
