package game_engine;

import cells.Cell;
import characters.GameCharacter;
import characters.players.Player;
import game_engine.MazeGenerator.MazeGenerator;


public class GameEngine {
    Cell[][] maze;
    GameCharacter player;

    public GameEngine(int rows, int columns){ // like setup in processing
        start(rows, columns);
    }

    public void start(int rows, int columns){
        maze = new MazeGenerator().create(rows, columns);
        player = new Player(0,0);
    }

    public void loop(){ // like draw in processing
        //process input
        //update
        //render





        loop();
    }

    public static void main(String[] args){
        GameEngine ge = new GameEngine(10,10);
        while(true){
            ge.loop();
        }
    }
}
