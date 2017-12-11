package game_engine;

import cells.Cell;
import characters.GameCharacter;
import characters.commands.Command;
import characters.commands.CommandsFactory;
import characters.players.Player;
import game_engine.MazeGenerator.MazeGenerator;
import javafx.animation.AnimationTimer;


public class GameEngine {
	
    //score Magho -- score & time start value --
	private int playerScore  = 20;//depend on level
	final long StartGameTime = System.currentTimeMillis();
    
	private Cell[][] maze;
    private GameCharacter player;
    private boolean running;
    private Command currentCommand;

    public GameEngine(int rows, int columns){
        start(rows, columns);
        loop();
    }

    private void start(int rows, int columns){ // like setup in processing
        maze = new MazeGenerator().create(rows, columns); // not finished yet
        player = new Player(0,0, rows, columns);

        //score Magho -- set score at the begging --
        //show player.getscore not playerScore on the screen 
        ((Player)player).setScore(playerScore);

        running = true;
    }

    private void loop(){
    	//score Magho -- end game when score == 0 
    	if (playerScore == 0){
    		//TODO end the game
    	}
        //score Magho -- get time at each loop --
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
                if(currentCommand != null){
                    if(currentCommand.execute()) {
                        // Move
                        /*if(cellType(maze[player.getCurrentRow()][player.getCurrentColumn()]).equalsIgnoreCase("empty")){

                        }*/
                        System.out.println(player.getCurrentRow() + " " + player.getCurrentColumn());
                    }
                }



                currentCommand = null;
                //System.out.println(player.getCurrentRow() + " " + player.getCurrentColumn());
            }

           private String cellType(Cell cell) {
               return cell.toString();
           }


       };
        animationTimer.start();
        
        //score Magho -- change score depend on time --
        long timePassed = StartLoopTime - StartGameTime;
        playerScore = (int) (playerScore - timePassed/3600);
        ((Player)player).setScore(playerScore);
        
    }

    public Command getCurrentCommand() {
        return currentCommand;
    }

    public void setCurrentCommand(String currentCommand) {
        this.currentCommand = new CommandsFactory().create(player, currentCommand);
    }
}
