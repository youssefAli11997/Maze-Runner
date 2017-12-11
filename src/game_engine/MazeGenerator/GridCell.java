package game_engine.MazeGenerator;

import java.util.Arrays;

public class GridCell {
	private int i;
	private int j;
	private boolean[] walls = new boolean[4];

	public GridCell(int i, int j) {
		Arrays.fill(walls, true);
		this.i = i;
		this.j = j;
	}

	public void removeWall(String direction) {
		switch (direction) {
		case "up":
			walls[0] = false;
			break;
		case "right":
			walls[1] = false;
			break;
		case "down":
			walls[2] = false;
			break;
		case "left":
			walls[3] = false;
			break;
		default:
			break;
		}
	}
	
	public void removeOppositeWall(String direction) {
		switch (direction) {
		case "up":
			walls[2] = false;
			break;
		case "right":
			walls[3] = false;
			break;
		case "down":
			walls[0] = false;
			break;
		case "left":
			walls[1] = false;
			break;
		default:
			break;
		}
	}
	
	public int getINeighbour(String direction) {
		switch (direction) {
		case "up":
			return i-1 ;
		case "right":
			return i;
		case "down":
			return i+1;
		case "left":
			return i;
		default:
			return i;
		}
	}
	
	public int getJNeighbour(String direction) {
		switch (direction) {
		case "up":
			return j ;
		case "right":
			return j+1;
		case "down":
			return j;
		case "left":
			return j-1;
		default:
			return j;
		}
	}
	
	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}
	
	public boolean getWall(String direction) {
		switch (direction) {
		case "up":
			return walls[0] ;
		case "right":
			return walls[1];
		case "down":
			return walls[2];
		case "left":
			return walls[3];
		default:
			return true;
		}
	}
}
