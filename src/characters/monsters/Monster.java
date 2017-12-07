package characters.monsters;

import characters.Character;

public abstract class Monster extends Character {
    public Monster(int currentRow, int currentColumn) {
        super(currentRow, currentColumn);
    }

    @Override
    public abstract void draw();

    @Override
    public abstract void action();
}
