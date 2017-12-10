package game_engine;

import cells.Cell;
import characters.GameCharacter;
import characters.players.Player;
import game_engine.MazeGenerator.MazeGenerator;


public class GameEngine {
    private Cell[][] maze;
    private GameCharacter player;
    private boolean running;

    public GameEngine(int rows, int columns){
        start(rows, columns);
    }

    public void start(int rows, int columns){ // like setup in processing
        maze = new MazeGenerator().create(rows, columns);
        player = new Player(0,0);
        running = true;
    }

    public void loop(){ // like draw in processing
        //process input
        //update
        //render
        if(!running){
            return;
        }
        // if player died, set running by false





        loop();
    }

    public static void main(String[] args){

    }
}
