package characters.commands;

import characters.GameCharacter;

public class CommandsFactory {

    public Command create(GameCharacter character, String commandBtn){
        if(commandBtn.equalsIgnoreCase("up")){
            return new MoveUpCommand(character);
        }
        if(commandBtn.equalsIgnoreCase("down")){
            return new MoveDownCommand(character);
        }
        if(commandBtn.equalsIgnoreCase("left")){
            return new MoveLeftCommand(character);
        }
        if(commandBtn.equalsIgnoreCase("right")){
            return new MoveRightCommand(character);
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
