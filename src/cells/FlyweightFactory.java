package cells;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class FlyweightFactory {
	
	static Logger log = Logger.getLogger(FlyweightFactory.class.getName());

	private static Map<String, Cell> pool;
	static {
		pool = new HashMap<>();
	}

	public static Cell create(String cell) {
		cell = cell.toLowerCase();
		if (pool.containsKey(cell)){
			log.debug("cell was created before return a reference using flyweight");
			return pool.get(cell);
			}
		else {
			Cell ret = CellsFactory.create(cell);
			pool.put(cell, ret);
			log.debug("cell was not created before create new one ");
			return ret;
		}
	}
}
