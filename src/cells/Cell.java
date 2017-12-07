package cells;

import characters.GameCharacter;

public abstract class Cell {

    public void draw() {}

    public abstract void action(GameCharacter character);

}
