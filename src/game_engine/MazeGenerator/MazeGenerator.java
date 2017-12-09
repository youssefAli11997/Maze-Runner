package game_engine.MazeGenerator;
import java.util.Arrays;
import java.util.Stack;

import cells.Cell;

public class MazeGenerator {
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
				grid[i][j] = new GridCell(i,j);
		}
	}
}
