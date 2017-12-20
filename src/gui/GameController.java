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
import javafx.scene.paint.Color;
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
    private static Cell[][] maze;
    private static int mazeRows, mazeColumns;
    public static GridPane grid;
    public static GraphicsContext graphicsContext;
    private static Image collision = new Image("assets/img/collision.png");
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
    private Label livesLabel;
    @FXML
    private Label healthLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label currentState;
    @FXML
    private Label currentWeapon;
    @FXML
    private Label currentBullets;
    @FXML
    void initialize() throws IOException, InterruptedException {
    	
    	timer= new Timer(MenuController.mode);
        grid = new GridPane();
        gameEngine.setGridPane(grid);
        gameEngine.attach(timer);
        timer.addObserver(this);
        GameEngine.getInstance().addObserver(this);
        update();
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
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.RED);
        graphicsContext.setLineWidth(3);
        graphicsContext.setStroke(Color.ORANGE);
        scrollPane.requestFocus();
    }

    public static void initMaze() {
        for (int i = 0; i < mazeRows; i++) {
            grid.addColumn(i);
            for (int j = 0; j < mazeColumns; j++) {
                maze[j][i].draw(grid, i, j);
            }
        }
    }

    @FXML
    void onMenuClick (){
        GameEngine.togglePaused();
        MenuController.gameStage.hide();
        Main.menu.show();
    }

	@Override
	public void update() {
		healthLabel.setText("Health : " + Player.getInstance().getHealth());
		livesLabel.setText("Lives : " + Player.getInstance().getLives());
		scoreLabel.setText("Score : " + Player.getInstance().getScore());
		currentState.setText("State : "+ Player.getInstance().getCurrentState().toString());
		currentWeapon.setText("Weapon : " + Player.getInstance().getWeapon().toString());
		currentBullets.setText("Bullets : " + Player.getInstance().getWeapon().getBullets());
	}

	@Override
	public void update(double time) {
		DateFormat timeFormat = new SimpleDateFormat( "mm:ss" );
		timerLabel.setText(timeFormat.format(time));
	}

	public static void drawFire (int playerRow, int playerCol, int cellRow, int cellCol){
        GameController.graphicsContext.fillPolygon(
                new double[]{playerCol * 71 + 35, cellCol * 71 + 35, cellCol * 71 + 40, playerCol * 71 + 40},
                new double[]{playerRow * 71 + 35, cellRow * 71 + 35, cellRow * 71 + 40, playerRow * 71 + 40},
                4
        );

        GameController.graphicsContext.strokePolygon(
                new double[]{playerCol * 71 + 35, cellCol * 71 + 35, cellCol * 71 + 40, playerCol * 71 + 40},
                new double[]{playerRow * 71 + 35, cellRow * 71 + 35, cellRow * 71 + 40, playerRow * 71 + 40},
                4
        );
    }

	public static void clearCanvas(){
        graphicsContext.clearRect(0, 0, mazeRows * 70, mazeColumns * 70);
    }

    public static void drawwCollision (int row, int col) {
        graphicsContext.drawImage(collision, col * 71, row * 71);
    }

}
