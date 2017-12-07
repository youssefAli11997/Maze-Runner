package cells;

import characters.GameCharacter;

public class EmptyCell extends Cell {
    public EmptyCell(int row, int column) {
        super(row, column);
    }

    @Override
    public void draw() {

    }
	@Override
	public void action(GameCharacter character) {
		// TODO Auto-generated method stub
		
	}
}
