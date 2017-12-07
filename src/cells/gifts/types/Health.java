package cells.gifts.types;

import cells.gifts.Gift;
import characters.GameCharacter;

public class Health extends Gift {
    public Health(int row, int column) {
        super(row, column);
    }

	@Override
	public void action(GameCharacter character) {
		character.setCurrentColumn(character.getHealth() + 10);		
	}
}
