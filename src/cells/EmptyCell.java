package cells;

import characters.GameCharacter;

public class EmptyCell extends Cell {

	@Override
	public void action(GameCharacter character) {
	}

	@Override
	public String toString() {
		return "empty";
	}
}
