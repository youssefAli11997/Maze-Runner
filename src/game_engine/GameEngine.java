package game_engine;

import cells.Cell;
import cells.EmptyCell;
import cells.bombs.Bomb;
import cells.gifts.Gift;
import cells.walls.types.Fire;
import cells.walls.types.Rock;
import cells.walls.types.Tree;
import cells.walls.types.Wooden;
import characters.GameCharacter;
import characters.commands.Command;
import characters.commands.CommandsFactory;
import characters.players.Player;
import constants.Map;
import game_engine.MazeGenerator.MazeGenerator;
import game_engine.timer.Timer;
import gui.GameController;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import observer.Observer;
import observer.Subject;
import observer.TimerObserver;
import utils.weapons.types.Sword;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by M.Sharaf on 13/12/2017.
 */
public class GameEngine implements Observer, Subject , TimerObserver{
    //score Magho -- score & time start value --
    private ArrayList<Observer> observers;
    private String mode ; 
    private boolean win = false;
    private boolean lose = false;
    //private int playerScore  = 20;//depends on level
    private final long StartGameTime = System.currentTimeMillis();
    private Timer timer;
	private Cell[][] maze;
    private static GameCharacter player;
    private static boolean paused;
    private boolean running;
    private static Command currentCommand;
    private static boolean fireMode;
    private GridPane gridPane;
    public Stage winStage;

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    private int rows;
    private int cols;

    private static GameEngine ourInstance;

    public static GameEngine getInstance() {
        if (ourInstance != null)
            return ourInstance;
        return null;
    }

    public static GameEngine getInstance(String diff , String mode ,int rows, int columns) {
        ourInstance = new GameEngine(diff ,mode ,rows , columns);
        return ourInstance;
    }

    private GameEngine(String diff , String mode , int rows, int columns) {
        observers = new ArrayList<>();
        this.mode = mode;
        this.rows = rows;
        this.cols = columns;
        paused = false;
        start(diff ,rows, columns);
        loop();
    }

    public Cell[][] getMaze() {
        return maze;
    }

    private void start(String diff , int rows, int columns) {
        maze = MazeGenerator.create(diff ,rows, columns);
        player = Player.getInstance(1, 0, maze.length, maze[0].length);
        fireMode = false;
        //score Magho -- set score at the begging --
        //show player.getscore not playerScore on the screen
        //((Player)player).setScore(playerScore);

        running = true;
    }

    private void loop() {
        long StartLoopTime = System.currentTimeMillis();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                GameController.clearCanvas();
                double startTime = System.currentTimeMillis();
                boolean moved = false;
                //score Magho -- end game when score == 0
                if (win || lose || paused) {
                    stop();
                }
                if (currentCommand != null) {
                    if (currentCommand.canExecute() && !fireMode) {
                        // Move
                        int newRow = (int) (player.getCurrentRow() + player.getOffset().getX());
                        int newCol = (int) (player.getCurrentColumn() + player.getOffset().getY());
                        if (maze[newRow][newCol] instanceof EmptyCell) {
                            currentCommand.execute();
                            /* (!(maze[1][0] instanceof Rock)) {
                                maze[1][0] = new Rock();
                                maze[1][0].draw(gridPane, 0, 1);
                            }*/
                            moved = true;
                        } else if (maze[newRow][newCol] instanceof Tree) {
                            currentCommand.execute();
                            moved = true;
                        } else if (maze[newRow][newCol] instanceof Bomb) {
                            currentCommand.execute();
                            maze[newRow][newCol].action(player);
                            maze[newRow][newCol] = new EmptyCell();
                            maze[newRow][newCol].draw(gridPane, newCol, newRow);
                            GameController.drawwCollision(newRow, newCol);
                            moved = true;
                        } else if (maze[newRow][newCol] instanceof Gift) {
                            currentCommand.execute();
                            maze[newRow][newCol].action(player);
                            maze[newRow][newCol] = new EmptyCell();
                            maze[newRow][newCol].draw(gridPane, newCol, newRow);
                            GameController.drawwCollision(newRow, newCol);
                            moved = true;
                        }
                        // Monsters: to be implemented

                        try {
                            if (moved) {
                                player.draw(directionMapped(), player.getCurrentRow(), player.getCurrentColumn());
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // Fire
                    if (currentCommand.canExecute() && fireMode) {
                        Point firstTarget = getFirstTarget();
                        if (firstTarget != null) {
                            int row = (int) firstTarget.getX();
                            int col = (int) firstTarget.getY();
                            if(player.getWeapon() instanceof Sword || player.getWeapon().getBullets() > 0) {
                            GameController.drawFire(player.getCurrentRow(), player.getCurrentColumn(),
                                    row, col);

                            player.fire(maze[row][col]);
                            maze[row][col] = new EmptyCell();
                            maze[row][col].draw(gridPane, col, row);
                            GameController.drawwCollision(row, col);
                            }
                        }
                        toggleFireMode();
                    }

                }

                currentCommand = null;
                //score Magho -- change score depend on time --
                long timePassed = StartLoopTime - StartGameTime;
                try {
                    Thread.sleep(75);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                timer.addTime(startTime, System.currentTimeMillis());
                //playerScore = (int) (playerScore - timePassed/1000);
                //((Player)player).setScore(playerScore);

                /*System.out.println("score: " + ((Player) player).getScore());
                System.out.println("lives: " + ((Player) player).getLives());
                System.out.println("health: " + player.getHealth());*/
            }
        };
        animationTimer.start();

    }

    private int directionMapped() {
        if (currentCommand.toString().equalsIgnoreCase("up")) {
            return Map.PlayerDirection.UP;
        } else if (currentCommand.toString().equalsIgnoreCase("down")) {
            return Map.PlayerDirection.DOWN;
        } else if (currentCommand.toString().equalsIgnoreCase("left")) {
            return Map.PlayerDirection.LEFT;
        } else if (currentCommand.toString().equalsIgnoreCase("right")) {
            return Map.PlayerDirection.RIGHT;
        }
        return 0;
    }

    private Point getFirstTarget() {
        String direction = currentCommand.toString();
        int currRow = player.getCurrentRow();
        int currCol = player.getCurrentColumn();

        if (direction.equalsIgnoreCase("up")) {
            if (player.getWeapon() instanceof Sword) {
                if (currRow > 0 && canShoot(maze[currRow - 1][currCol])) {
                    return new Point(currRow - 1, currCol);
                }
            } else {
                for (int i = currRow - 1; i >= 0; i--) {
                    if(maze[i][currCol] instanceof Rock){
                        return null;
                    }
                    if (canShoot(maze[i][currCol])) {
                        return new Point(i, currCol);
                    }
                }
            }
        }
        if (direction.equalsIgnoreCase("down")) {
            if (player.getWeapon() instanceof Sword) {
                if (currRow < maze.length - 1 && canShoot(maze[currRow + 1][currCol])) {
                    return new Point(currRow + 1, currCol);
                }
            } else {
                for (int i = currRow + 1; i <= maze.length; i++) {
                    if(maze[i][currCol] instanceof Rock){
                        return null;
                    }
                    if (canShoot(maze[i][currCol])) {
                        return new Point(i, currCol);
                    }
                }
            }
        }
        if (direction.equalsIgnoreCase("left")) {
            if (player.getWeapon() instanceof Sword) {
                if (currCol > 0 && canShoot(maze[currRow][currCol - 1])) {
                    return new Point(currRow, currCol - 1);
                }
            } else {
                for (int i = currCol - 1; i >= 0; i--) {
                    if(maze[currRow][i] instanceof Rock){
                        return null;
                    }
                    if (canShoot(maze[currRow][i])) {
                        return new Point(currRow, i);
                    }
                }
            }
        }
        if (direction.equalsIgnoreCase("right")) {
            if (player.getWeapon() instanceof Sword) {
                if (currCol < maze[0].length - 1 && canShoot(maze[currRow][currCol + 1])) {
                    return new Point(currRow, currCol + 1);
                }
            } else {
                for (int i = currCol + 1; i <= maze[0].length; i++) {
                    if(maze[currRow][i] instanceof Rock){
                        return null;
                    }
                    if (canShoot(maze[currRow][i])) {
                        return new Point(currRow, i);
                    }
                }
            }
        }

        return null;
    }

    private boolean canShoot(Cell cell) {
        return cell instanceof Wooden ||
                cell instanceof Gift ||
                cell instanceof Bomb;
    }

    public Command getCurrentCommand() {
        return currentCommand;
    }

    public static void setCurrentCommand(String currentCmd) {
        currentCommand = new CommandsFactory().create(Player.getInstance(), currentCmd);
    }

    public static void toggleFireMode() {
        fireMode = !fireMode;
        System.out.println("fire toggles");
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public static void addKeyListeners(Scene gameScene) {
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // System.out.println(currentCommand);
                if (event.getCode().equals(KeyCode.X)) {
                    toggleFireMode();
                } else if (event.getCode().equals(KeyCode.T)) {
                    player.toggleWeapon();
                } else {
                    setCurrentCommand(event.getCode().toString());
                }
                // System.out.println(currentCommand);
            }
        });

        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.X)) {
                    //deactivateFireMode();
                } else {
                    setCurrentCommand("released");
                }
            }
        });
    }

    public void attach(Timer timer) {
        this.timer = timer;
        timer.addObserver(this);
    }
    
    @Override
    public void update() {
        if (Player.getInstance().getHealth() == 0 && Player.getInstance().getLives() == 0 && !lose && !win) {
            lose = true;
            showWinLoseDialogue();
        }
        else if (Player.getInstance().getCurrentRow() == maze.length - 2 && Player.getInstance().getCurrentColumn() == maze[0].length - 1 && !lose && !win) {
            win = true;
            showWinLoseDialogue();
        }
        notifyObservers();
    }

    @Override
    public void addObserver(Observer ob) {
        observers.add(ob);

    }

    @Override
    public void removeObserver(Observer ob) {
        observers.remove(ob);

    }

    @Override
    public void notifyObservers() {
        for (Observer ob : observers)
            ob.update();
    }
    
    public Timer getTimer() {
		return timer;
	}

    
    private void showWinLoseDialogue() {
    	winStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/gui/win-layout.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        winStage.initStyle(StageStyle.UNDECORATED);
        String css = this.getClass().getResource("/gui/win_layout.css").toExternalForm();
        root.getStylesheets().add(css);
        winStage.setScene(new Scene(root));
        winStage.setResizable(false);
        winStage.show();
    }

	@Override
	public void update(double time) {
		if(time == 0 && mode.equalsIgnoreCase("survival") && !lose && !win) {
			lose = true ;
			showWinLoseDialogue();
		}
	}

	public static void togglePaused(){
        paused = !paused;
        if(!paused){
            GameEngine.getInstance().loop();
        }
    }
    
}