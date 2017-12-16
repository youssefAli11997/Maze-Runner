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
import gui.GameController;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import utils.weapons.types.Sword;

import java.awt.*;

/**
 * Created by M.Sharaf on 13/12/2017.
 */
public class GameEngine {
    //score Magho -- score & time start value --
    private int playerScore  = 20;//depends on level
    private final long StartGameTime = System.currentTimeMillis();

    private Cell[][] maze;
    private static GameCharacter player;
    private boolean running;
    private static Command currentCommand;
    private static boolean fireMode;
    private GridPane gridPane;

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    private int rows;
    private int cols;

    private static GameEngine ourInstance;

    public static GameEngine getInstance(){
        if(ourInstance != null)
            return ourInstance;
        return null;
    }

    public static GameEngine getInstance(int rows, int columns) {
        if(ourInstance == null){
            ourInstance = new GameEngine(rows,columns);
        }
        return ourInstance;
    }

    private GameEngine(int rows, int columns){
        this.rows = rows;
        this.cols = columns;

        start(rows, columns);
        loop();
    }

    public Cell[][] getMaze() {
        return maze;
    }

    private void start(int rows, int columns){
        maze = MazeGenerator.create(rows, columns);
        player = Player.getInstance(1,0, maze.length, maze[0].length);
        fireMode = false;
        //score Magho -- set score at the begging --
        //show player.getscore not playerScore on the screen
        ((Player)player).setScore(playerScore);

        running = true;
    }

    private void loop(){
        long StartLoopTime = System.currentTimeMillis();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                boolean moved = false;
                //score Magho -- end game when score == 0
                if (playerScore == 0 || player.getHealth() <= 0){
                    //stop();
                }
                //if(fireMode)
                //    System.out.println(currentCommand);
                if(currentCommand != null){
                    if(currentCommand.canExecute() && !fireMode) {
                        System.out.println("here");
                        //System.out.println("before " + player.getCurrentRow() + " " + player.getCurrentColumn());
                        //GameController.movePlayer (player.getCurrentRow(),player.getCurrentColumn());
                        // Move
                        int newRow = (int) (player.getCurrentRow() + player.getOffset().getX());
                        int newCol = (int) (player.getCurrentColumn() + player.getOffset().getY());
                        //System.out.println(newRow + " " + newCol);
                        if(maze[newRow][newCol] instanceof EmptyCell){
                            //System.out.println("empty");
                            currentCommand.execute();
                            if(!(maze[1][0] instanceof Rock)){
                                maze[1][0] = new Rock();
                                maze[1][0].draw(gridPane,0,1);
                            }
                            moved = true;
                        }
                        else if(maze[newRow][newCol] instanceof Tree){
                            //System.out.println("tree");
                            currentCommand.execute();
                            moved = true;
                        }
                        else if(maze[newRow][newCol] instanceof Bomb){
                            //System.out.println("bomb");
                            currentCommand.execute();
                            maze[newRow][newCol].action(player);
                            maze[newRow][newCol] = new EmptyCell();
                            maze[newRow][newCol].draw(gridPane, newCol, newRow);
                            moved = true;
                        }
                        else if(maze[newRow][newCol] instanceof Gift){
                            //System.out.println("gift");
                            currentCommand.execute();
                            maze[newRow][newCol].action(player);
                            maze[newRow][newCol] = new EmptyCell();
                            maze[newRow][newCol].draw(gridPane, newCol, newRow);
                            moved = true;
                        }
                        // Monsters: to be implemented

                        //System.out.println(player.getCurrentRow() + " " + player.getCurrentColumn());
                        //System.out.println("after " + player.getCurrentRow() + " " + player.getCurrentColumn());
                        //GameController.movePlayer(player.getCurrentRow(), player.getCurrentColumn());
                        try {
                            if(moved){
                                player.draw(directionMapped(), player.getCurrentRow(), player.getCurrentColumn());
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // Fire
                    if(currentCommand.canExecute() && fireMode){
                        //System.out.println("in fire");
                        Point firstTarget = getFirstTarget();
                        int row = (int) firstTarget.getX();
                        int col = (int) firstTarget.getY();
                        if(firstTarget != null){
                            //System.out.println(currentCommand.toString() + " " + firstTarget);
                            player.fire(maze[row][col]);
                            maze[row][col] = new EmptyCell();
                            maze[row][col].draw(gridPane, col, row);
                        }
                        toggleFireMode();
                    }

                }

                currentCommand = null;
                //System.out.println(player.getCurrentRow() + " " + player.getCurrentColumn());
                //score Magho -- change score depend on time --
                long timePassed = StartLoopTime - StartGameTime;
                playerScore = (int) (playerScore - timePassed/1000);
                ((Player)player).setScore(playerScore);
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

        if(direction.equalsIgnoreCase("up")){
            if(player.getWeapon() instanceof Sword){
                if(currRow > 0 && canShoot(maze[currRow - 1][currCol])){
                    return new Point(currRow - 1, currCol);
                }
            }
            else{
                for(int i = currRow + 1; i >= 0; i--){
                    if(canShoot(maze[i][currCol])) {
                        return new Point(i, currCol);
                    }
                }
            }
        }
        if(direction.equalsIgnoreCase("down")){
            if(player.getWeapon() instanceof Sword){
                if(currRow < maze.length - 1 && canShoot(maze[currRow + 1][currCol])){
                    return new Point(currRow + 1, currCol);
                }
            }
            else{
                for(int i = currRow + 1; i <= maze.length; i++){
                    if(canShoot(maze[i][currCol])) {
                        return new Point(i, currCol);
                    }
                }
            }
        }
        if(direction.equalsIgnoreCase("left")){
            if(player.getWeapon() instanceof Sword){
                if(currCol > 0 && canShoot(maze[currRow][currCol - 1])){
                    return new Point(currRow, currCol - 1);
                }
            }
            else{
                for(int i = currCol + 1; i >= 0; i--){
                    if(canShoot(maze[currRow][i])) {
                        return new Point(currRow, i);
                    }
                }
            }
        }
        if(direction.equalsIgnoreCase("right")){
            if(player.getWeapon() instanceof Sword){
                if(currCol < maze[0].length - 1 && canShoot(maze[currRow][currCol + 1])){
                    return new Point(currRow, currCol + 1);
                }
            }
            else{
                for(int i = currCol + 1; i <= maze[0].length; i++){
                    if(canShoot(maze[currRow][i])) {
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

    public static void toggleFireMode(){
        fireMode = !fireMode;
        System.out.println("fire toggles");
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public static void addKeyListeners(Scene gameScene){
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // System.out.println(currentCommand);
                if(event.getCode().equals(KeyCode.X)){
                    toggleFireMode();
                }
                else if(event.getCode().equals(KeyCode.T)){
                    player.toggleWeapon();
                }
                else {
                    setCurrentCommand(event.getCode().toString());
                }
                // System.out.println(currentCommand);
            }
        });

        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.X)){
                    //deactivateFireMode();
                }
                else {
                    setCurrentCommand("released");
                }
            }
        });
    }

}