package characters;

import characters.players.Player;
import characters.states.Normal;
import constants.Map;
import utils.weapons.Weapon;
import utils.weapons.types.Sword;

import java.awt.*;

public abstract class GameCharacter {

	private int currentRow;
	private int currentColumn;
	private int gridRows;
	private int gridColumns;
	private int health;
	private int healthChange;
	private Point offset;
	private Weapon weapon;
	private CharacterState currentState;

	public GameCharacter(int currentRow, int currentColumn, int gridRows, int gridColumns) {
		this.currentRow = currentRow;
		this.currentColumn = currentColumn;
		this.gridRows = gridRows;
		this.gridColumns = gridColumns;
		weapon = new Sword((Player) this);
		currentState = new Normal(this);
		offset = new Point(0,0);
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

	public boolean canMove(String direction) {
		if (direction.equalsIgnoreCase(Map.playerKeys.UP)) {
			if(currentRow == 0){
				return false;
			}
			offset = new Point(-1,0);
			return true;
		}
		if (direction.equalsIgnoreCase(Map.playerKeys.DOWN)) {
			if(currentRow == gridRows - 1){
				return false;
			}
			offset = new Point(1,0);
			return true;
		}
		if (direction.equalsIgnoreCase(Map.playerKeys.LEFT)) {
			if(currentColumn == 0){
				return false;
			}
			offset = new Point(0,-1);
			return true;
		}
		if (direction.equalsIgnoreCase(Map.playerKeys.RIGHT)) {
			if(currentColumn == gridColumns - 1){
				return false;
			}
			offset = new Point(0,1);
			return true;
		}
		return false;
	}

	public boolean move(String direction) {
		if (direction.equalsIgnoreCase(Map.playerKeys.UP)) {
			if(currentRow == 0){
				return false;
			}
			currentRow--;
			return true;
		}
		if (direction.equalsIgnoreCase(Map.playerKeys.DOWN)) {
			if(currentRow == gridRows - 1){
				return false;
			}
			currentRow++;
			return true;
		}
		if (direction.equalsIgnoreCase(Map.playerKeys.LEFT)) {
			if(currentColumn == 0){
				return false;
			}
			currentColumn--;
			return true;
		}
		if (direction.equalsIgnoreCase(Map.playerKeys.RIGHT)) {
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

	public boolean fire(Object object) {
		currentState.fire(object);
		return weapon.getBullets() == 0;
	}

	public void die() {
		// TODO implement death better to call die than setting health to 0
		currentState.die();
	}

	public Point getOffset() {
		return offset;
	}
}
