package cells.gifts;

import cells.Cell;
import characters.GameCharacter;


public  abstract class Gift extends Cell {
	
    @Override
    public abstract void action(GameCharacter character);
}
