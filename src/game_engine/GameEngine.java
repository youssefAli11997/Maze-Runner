package game_engine;

import cells.Cell;
import characters.GameCharacter;
import characters.commands.Command;
import characters.commands.CommandsFactory;
import characters.players.Player;
import game_engine.MazeGenerator.MazeGenerator;
import javafx.animation.AnimationTimer;


public class GameEngine {
    private Cell[][] maze;
    private GameCharacter player;
    private boolean running;
    private Command currentCommand;

    public GameEngine(int rows, int columns){
        start(rows, columns);
        loop();
    }

    private void start(int rows, int columns){ // like setup in processing
       // maze = new MazeGenerator().create(rows, columns); // not finished yet
        player = new Player(0,0);
        running = true;
    }

    private void loop(){ // like draw in processing
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
            int i=0;
            @Override
            public void handle(long l) {
                if(currentCommand != null){
                    currentCommand.execute();
                }
                currentCommand = null;
                System.out.println(player.getCurrentRow() + " " + player.getCurrentColumn());
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
