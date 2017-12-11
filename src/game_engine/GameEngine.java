package game_engine;

import cells.Cell;
import cells.EmptyCell;
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

    public GameEngine(int rows, int columns){
        start(rows, columns);
        loop();
    }

    private void start(int rows, int columns){ // like setup in processing
        maze = MazeGenerator.create(rows, columns); // not finished yet
        player = new Player(0,0, rows, columns);

        //score Magho -- set score at the begging --
        //show player.getscore not playerScore on the screen 
        ((Player)player).setScore(playerScore);

        running = true;
    }

    private void loop(){
    	long StartLoopTime = System.currentTimeMillis();
    	
    	// like draw in processing
        /*while(true){
            //process input
            //update
            //render
            if(!running){
                return;
            }
            // if player died, set running by false
        }*/

       AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                //score Magho -- end game when score == 0
                if (playerScore == 0){
                    //TODO end the game
                }

                if(currentCommand != null){
                    if(currentCommand.execute()) {
                        // Move
                        if(maze[player.getCurrentRow()][player.getCurrentColumn()] instanceof EmptyCell){
                            
                        }
                        System.out.println(player.getCurrentRow() + " " + player.getCurrentColumn());
                    }
                }



                currentCommand = null;
                //System.out.println(player.getCurrentRow() + " " + player.getCurrentColumn());
                //score Magho -- change score depend on time --
                long timePassed = StartLoopTime - StartGameTime;
                playerScore = (int) (playerScore - timePassed/3600);
                ((Player)player).setScore(playerScore);
            }

           private String cellType(Cell cell) {
               return cell.toString();
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
}
