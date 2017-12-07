package cells.walls;

import cells.Cell;
import characters.GameCharacter;

public class Wall extends Cell {
    private boolean breakable;
    private int bulletsToBreak;
    private int healthDecrease;

    public Wall(int row, int column, boolean breakable, int bulletsToBreak, int healthDecrease){
        super(row, column);
        this.breakable = breakable;
        this.bulletsToBreak = bulletsToBreak;
        this.healthDecrease = healthDecrease;
    }


    public boolean isBreakable() {
        return breakable;
    }

    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

    public int getBulletsToBreak() {
        return bulletsToBreak;
    }

    public void setBulletsToBreak(int bulletsToBreak) {
        this.bulletsToBreak = bulletsToBreak;
    }

    public int getHealthDecrease() {
        return healthDecrease;
    }

    public void setHealthDecrease(int healthDecrease) {
        this.healthDecrease = healthDecrease;
    }

    @Override
    public void draw() {

    }

	@Override
	public void action(GameCharacter character) {
		// TODO Auto-generated method stub
		
	}
}
