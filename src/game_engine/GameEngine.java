package game_engine;

import cells.Cell;
import cells.EmptyCell;
import cells.bombs.Bomb;
import cells.gifts.Gift;
import cells.walls.types.Tree;
import characters.GameCharacter;
import characters.commands.Command;
import characters.commands.CommandsFactory;
import characters.players.Player;
import game_engine.MazeGenerator.MazeGenerator;
import javafx.animation.AnimationTimer;


public class GameEngine {
	
    //score Magho -- score & time start value --
	private int playerScore  = 20;//depends on level
	private final long StartGameTime = System.currentTimeMillis();
    
	private Cell[][] maze;
    private GameCharacter player;
    private boolean running;
    private Command currentCommand;
    private boolean fireMode;

    public GameEngine(int rows, int columns){
        start(rows, columns);
        loop();
    }

    private void start(int rows, int columns){
        maze = MazeGenerator.create(rows, columns);
        player = new Player(0,0, rows, columns);
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
                    //TODO end the game
                }

                if(currentCommand != null){
                    System.out.println(player.getCurrentRow() + " " + player.getCurrentColumn());
                    if(currentCommand.canExecute()) {
                        int newRow = (int) (player.getCurrentRow() + player.getOffset().getX());
                        int newCol = (int) (player.getCurrentColumn() + player.getOffset().getY());
                        // Move
                        if(maze[newRow][newCol] instanceof EmptyCell){
                            currentCommand.execute();
                        }
                        else if(maze[newRow][newCol] instanceof Tree){
                            currentCommand.execute();
                        }
                        else if(maze[newRow][newCol] instanceof Bomb){
                            currentCommand.execute();
                            maze[newRow][newCol].action(player);
                            maze[newRow][newCol] = new EmptyCell();
                            //maze[player.getCurrentRow()][player.getCurrentColumn()].draw();
                        }
                        else if(maze[newRow][newCol] instanceof Gift){
                            currentCommand.execute();
                            maze[newRow][newCol].action(player);
                            maze[newRow][newCol] = new EmptyCell();
                            //maze[player.getCurrentRow()][player.getCurrentColumn()].draw();
                        }
                        // Monsters: to be implemented

                        // Fire


                        //System.out.println(player.getCurrentRow() + " " + player.getCurrentColumn());
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

    public void setCurrentCommand(String currentCommand) {
        this.currentCommand = new CommandsFactory().create(player, currentCommand);
    }

    public void activateFireMode(){
        fireMode = true;
    }

    public void deactivateFireMode(){
        fireMode = false;
    }
}
