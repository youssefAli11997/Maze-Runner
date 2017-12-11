package characters;

import utils.weapons.Weapon;

public abstract class GameCharacter {

	private int currentRow;
	private int currentColumn;
	private int gridRows;
	private int gridColumns;
	private int health;
	private int healthChange;
	private Weapon weapon;
	private CharacterState currentState;

	public GameCharacter(int currentRow, int currentColumn, int gridRows, int gridColumns) {
		this.currentRow = currentRow;
		this.currentColumn = currentColumn;
		this.gridRows = gridRows;
		this.gridColumns = gridColumns;
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

	// why to set ! move method does the job
	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public boolean move(String direction) {
		if (direction.equalsIgnoreCase("up")) {
			if(currentRow == 0){
				return false;
			}
			currentRow--;
			return true;
		}
		if (direction.equalsIgnoreCase("down")) {
			if(currentRow == gridRows - 1){
				return false;
			}
			currentRow++;
			return true;
		}
		if (direction.equalsIgnoreCase("left")) {
			if(currentColumn == 0){
				return false;
			}
			currentColumn--;
			return true;
		}
		if (direction.equalsIgnoreCase("right")) {
			if(currentColumn == gridColumns - 1){
				return false;
			}
			currentColumn++;
			return true;
		}
		return false;
	}

	public void draw() {
	}

	public void setCurrentState(CharacterState newState) {
		currentState = newState;
	}

	public CharacterState getCurrentState() {
		return currentState;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health
	 *            the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @param health
	 *            the health change to set
	 */
	public void setHealthChange(int health) {
		currentState.setHealthChange(health);
	}

	public int getHealthChange() {
		return healthChange;
	}

	/**
	 * @return the weapon
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * @param weapon
	 *            the weapon to set
	 */
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public boolean fire() {
		if(weapon.getBullets() > 0) {
			currentState.fire();
			return true;
		}
		return false;
	}

	public void die() {
		// TODO implement death better to call die than setting health to 0
		currentState.die();
	}
}
