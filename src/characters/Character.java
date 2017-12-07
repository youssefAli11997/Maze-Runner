package characters;

import utils.weapons.Weapon;

public abstract class Character {
	
    private int currentRow;
    private int currentColumn;
    private int health ;
    private Weapon weapon; 

    public Character(int currentRow, int currentColumn){
        this.currentRow = currentRow;
        this.currentColumn = currentColumn;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public void move(String direction){
        if(direction.equalsIgnoreCase("up")){
            currentRow --;
        }
        if(direction.equalsIgnoreCase("down")){
            currentRow ++;
        }
        if(direction.equalsIgnoreCase("left")){
            currentColumn --;
        }
        if(direction.equalsIgnoreCase("right")){
            currentColumn ++;
        }
    }

    public abstract void draw();

    public abstract void action();

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	public void SetWeapon (Weapon weapon){
		
	}
}
