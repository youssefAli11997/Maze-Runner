package characters.commands;

import characters.GameCharacter;
import characters.players.Player;
import constants.Map;

public class CommandsFactory {

    public Command create(GameCharacter character, String commandBtn){
        if(commandBtn.equalsIgnoreCase(Map.playerKeys.UP)){
            //return new MoveUpCommand(character);
            return new MoveUpCommand(Player.getInstance());
        }
        if(commandBtn.equalsIgnoreCase(Map.playerKeys.DOWN)){
            //return new MoveDownCommand(character);
            return new MoveDownCommand(Player.getInstance());
        }
        if(commandBtn.equalsIgnoreCase(Map.playerKeys.LEFT)){
            //return new MoveLeftCommand(character);
            return new MoveLeftCommand(Player.getInstance());
        }
        if(commandBtn.equalsIgnoreCase(Map.playerKeys.RIGHT)){
            //return new MoveRightCommand(character);
            return new MoveRightCommand(Player.getInstance());
        }

        return null;
    }
    
    public Command createFireCommand(GameCharacter character, String commandBtn, Object object){
        if(commandBtn.equalsIgnoreCase("space")){
            return new FireCommand(character,object);
        }
		return null;
    }
    
}
