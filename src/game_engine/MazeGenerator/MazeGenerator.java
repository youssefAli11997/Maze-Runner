package game_engine.MazeGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import cells.Cell;
import cells.FlyweightFactory;
import utilsMath.RandomGenerator;

public class MazeGenerator {
	private static GridCell[][] grid;
	private static boolean[][] visited;
	private static int visitedCount = 0;

	public static Cell[][] create(int rows, int columns) {
		visited = new boolean[rows][columns];
		visitedCount = rows * columns;
		grid = new GridCell[rows][columns];
		initiate(grid);
		dfs(grid[0][0]);
		boolean[][] expandedMap = expandMaze(grid);
		for(int i = 0 ; i < expandedMap.length ; i ++) {
			for(int j = 0 ; j < expandedMap[0].length ; j++) {
				System.out.print(expandedMap[i][j] == true ? "1" + " " : "0" + " ");
			}
			System.out.println();
		}
		return null;
	}

	private static void dfs(GridCell start) {
		GridCell current = start;
    	visited[current.getI()][current.getJ()] = true ;
    	visitedCount -- ;
    	Stack<GridCell> stack = new Stack<>();
    	while(hasUnVisited()) {
    		List<String> unVisitedNeighbours = getUnvisitedNeighbours(current);
    		if(!unVisitedNeighbours.isEmpty()) {
    			stack.push(current);
    			String nextDirection = randomPick(current , unVisitedNeighbours);
    			GridCell next = grid[current.getINeighbour(nextDirection)][current.getJNeighbour(nextDirection)];
    			current.removeWall(nextDirection);
    			next.removeOppositeWall(nextDirection);
    			current = next ;
    			visited[current.getI()][current.getJ()] = true ;
    			visitedCount --;
    		}
    		else if (!stack.isEmpty()) {
    			current = stack.pop();
    		}
    	}	
    }

	private static String randomPick(GridCell current , List<String> unVisitedNeighbours) {
		int picked = RandomGenerator.generateRandom(unVisitedNeighbours.size());
		String direction = unVisitedNeighbours.get(picked);
		return direction;
	}

	private static List<String> getUnvisitedNeighbours(GridCell current) {
		List<String> unvisited = new ArrayList<>();
		if((current.getI()-1 >= 0 && current.getI() -1 < grid.length ) && (current.getJ() >= 0 && current.getJ() < grid[0].length ) && !visited[current.getI()-1][current.getJ()])
			unvisited.add("up");
		if((current.getI() >= 0 && current.getI() < grid.length ) && (current.getJ()+1 >= 0 && current.getJ() +1 < grid[0].length ) && !visited[current.getI()][current.getJ()+1])
			unvisited.add("right");
		if((current.getI()+1 >= 0 && current.getI()+1 < grid.length ) && (current.getJ() >= 0 && current.getJ() < grid[0].length ) && !visited[current.getI()+1][current.getJ()])
			unvisited.add("down");
		if((current.getI() >= 0 && current.getI() < grid.length ) && (current.getJ()-1 >= 0 && current.getJ() -1 < grid[0].length ) && !visited[current.getI()][current.getJ()-1])
			unvisited.add("left");
			return unvisited;
	}

	private static void initiate(GridCell[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++)
				grid[i][j] = new GridCell(i, j);
		}
	}

	private static  boolean hasUnVisited() {
		return visitedCount > 0 ? true : false;
	}
	

	private static boolean[][] expandMaze(GridCell[][] grid) {
		boolean[][] expandedGrid = new boolean[grid.length*2+1][grid[0].length*2+1];
		int m = 0 , n = 0 ;
		for(int i = 0 ; i < expandedGrid.length-1 ; i++) {
			for(int j = 0 ; j < expandedGrid[0].length ; j++) {
				if(i % 2 == 0) {
					if(j % 2 == 0)
						expandedGrid[i][j] = true;
					else {
						expandedGrid[i][j] = grid[m][n].getWall("up");
						n++;
					}
				}
				else {
					if(j % 2 == 0) {
						expandedGrid[i][j] = grid[m][n].getWall("left");
					}
					else {
						expandedGrid[i][j] = false;
						j++;
						expandedGrid[i][j] = grid[m][n].getWall("right"); 
						n++;
					}
				}
			}
			n = 0 ;
			if(i % 2 != 0)
				m ++ ;
		}
		for(int j = 0 ; j < expandedGrid[0].length ; j++) // last row;
			expandedGrid[expandedGrid.length-1][j] = true;
		expandedGrid[1][0] = false; // start portal
		expandedGrid[expandedGrid.length-2][expandedGrid[0].length-1] = false; //end portal
		return expandedGrid;
	}
	
	private static Cell[][] mapMaze(GridCell[][] grid) {
		return null;
	}
}
