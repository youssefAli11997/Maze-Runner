package game_engine.MazeGenerator;
import java.util.Arrays;
import java.util.Stack;

import cells.Cell;

public class MazeGenerator {
	class GridCell{
		int i ;
		int j ;
		private boolean [] walls = new boolean[4];
		public GridCell(int i , int j) {
			Arrays.fill(walls, true);
			this.i = i;
			this.j = j;
		}
		public void remove(String direction) {
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
	private static GridCell[][] grid;
	private static boolean[][] visited;
	
    public Cell[][] create(int rows, int columns){
    	visited = new boolean[rows][columns];
    	grid = new GridCell[rows][columns];
    	initiate(grid);
    	dfs(grid[0][0]);
    	
    	Cell[][] mappedGrid = null;
        return mappedGrid;
    }

	private void dfs(GridCell current) {
    	visited[current.i][current.j] = true ;
    	Stack<GridCell> stack = new Stack<>();
    	if(current.hasNext)
    		
    }
	
	private GridCell getNext() {
		return null;
	}

	private void initiate(GridCell[][] grid) {
		for(int i = 0 ; i < grid.length ; i ++) {
			for(int j = 0 ; j < grid[0].length ; j ++)
				grid[i][j] = new GridCell();
		}
	}
}
