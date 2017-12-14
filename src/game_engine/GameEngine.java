  package game_engine;

import cells.Cell;
import cells.EmptyCell;
import cells.bombs.Bomb;
import cells.gifts.Gift;
import cells.walls.types.Rock;
import cells.walls.types.Tree;
import characters.GameCharacter;
import characters.commands.Command;
import characters.commands.CommandsFactory;
import characters.players.Player;
import game_engine.MazeGenerator.MazeGenerator;
import gui.GameController;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

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
        deactivateFireMode();
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
                //score Magho -- end game when score == 0
                if (playerScore == 0 || player.getHealth() <= 0){
                   //stop();
                }
                //System.out.println(currentCommand);
                if(currentCommand != null){
                    if(currentCommand.canExecute()) {
                        System.out.println("before " + player.getCurrentRow() + " " + player.getCurrentColumn());
                        GameController.movePlayer (player.getCurrentRow(),player.getCurrentColumn());
                        // Move
                        int newRow = (int) (player.getCurrentRow() + player.getOffset().getX());
                        int newCol = (int) (player.getCurrentColumn() + player.getOffset().getY());
                        //System.out.println(newRow + " " + newCol);
                        if(maze[newRow][newCol] instanceof EmptyCell){
                            System.out.println("empty");
                            currentCommand.execute();
                            if(!(maze[1][0] instanceof Rock)){
                                maze[1][0] = new Rock();
                                maze[1][0].draw(gridPane,1,0);
                            }
                        }
                        else if(maze[newRow][newCol] instanceof Tree){
                            System.out.println("tree");
                            currentCommand.execute();
                        }
                        else if(maze[newRow][newCol] instanceof Bomb){
                            System.out.println("bomb");
                            currentCommand.execute();
                            maze[newRow][newCol].action(player);
                            maze[newRow][newCol] = new EmptyCell();
                            maze[newRow][newCol].draw(gridPane, newRow, newCol);
                        }
                        else if(maze[newRow][newCol] instanceof Gift){
                            System.out.println("gift");
                            currentCommand.execute();
                            maze[newRow][newCol].action(player);
                            maze[newRow][newCol] = new EmptyCell();
                            maze[newRow][newCol].draw(gridPane, newRow, newCol);
                        }
                        // Monsters: to be implemented

                        // Fire


                        //System.out.println(player.getCurrentRow() + " " + player.getCurrentColumn());
                        System.out.println("after " + player.getCurrentRow() + " " + player.getCurrentColumn());
                        GameController.movePlayer(player.getCurrentRow(), player.getCurrentColumn());
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

    public Command getCurrentCommand() {
        return currentCommand;
    }

    public static void setCurrentCommand(String currentCmd) {
        currentCommand = new CommandsFactory().create(Player.getInstance(), currentCmd);
    }

    public static void activateFireMode(){
        fireMode = true;
    }

    public static void deactivateFireMode(){
        fireMode = false;
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
                if(event.getCode().equals(KeyCode.SPACE)){
                    activateFireMode();
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
                if(event.getCode().equals(KeyCode.SPACE)){
                    deactivateFireMode();
                }
                else {
                    setCurrentCommand("released");
                }
            }
        });
    }

}
