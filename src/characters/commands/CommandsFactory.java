package characters.commands;

import org.apache.log4j.Logger;

import characters.GameCharacter;
import characters.players.Player;
import constants.Map;

public class CommandsFactory {
	static Logger log = Logger.getLogger(CommandsFactory.class.getName());

    public Command create(GameCharacter character, String commandBtn){
        if(commandBtn.equalsIgnoreCase(Map.playerKeys.UP)){
            //return new MoveUpCommand(character);
			log.info("move up");
			return new MoveUpCommand(Player.getInstance());
        }
        if(commandBtn.equalsIgnoreCase(Map.playerKeys.DOWN)){
            //return new MoveDownCommand(character);
			log.info("move down");
            return new MoveDownCommand(Player.getInstance());
        }
        if(commandBtn.equalsIgnoreCase(Map.playerKeys.LEFT)){
            //return new MoveLeftCommand(character);
			log.info("move left");
            return new MoveLeftCommand(Player.getInstance());
        }
        if(commandBtn.equalsIgnoreCase(Map.playerKeys.RIGHT)){
            //return new MoveRightCommand(character);
			log.info("move right");
        	return new MoveRightCommand(Player.getInstance());
        }

        return null;
    }
    
    public Command createFireCommand(GameCharacter character, String commandBtn, Object object){
        if(commandBtn.equalsIgnoreCase("space")){
			log.info("player jumped");
            return new FireCommand(character,object);
        }
		return null;
    }
    
}
