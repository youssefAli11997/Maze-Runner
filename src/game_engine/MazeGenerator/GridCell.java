package game_engine.MazeGenerator;

import java.util.Arrays;

public class GridCell {
	private int i ;
	private int j ;
	private boolean [] walls = new boolean[4];
	public GridCell(int i , int j) {
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
}
