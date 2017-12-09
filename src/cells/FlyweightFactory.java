package cells;
import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
	private static Map<String, Cell> pool;
	static {
		pool = new HashMap<>();
	}
	public static Cell create(String cell) {
		cell = cell.toLowerCase();
		if(pool.containsKey(cell))
			return pool.get(cell);
		else {
			Cell ret = CellsFactory.create(cell);
			pool.put(cell, ret);
			return ret;
		}
	}
}
