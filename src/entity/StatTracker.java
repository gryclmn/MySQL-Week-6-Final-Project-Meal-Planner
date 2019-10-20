package entity;

import java.util.HashMap;
import java.util.Map;

public class StatTracker {

	private Map<Integer, Integer> dishStats = new HashMap();

	public Integer getDishStatById(int id) {
		if (dishStats.containsKey(id)) {
			return dishStats.get(id);
		}
		return -1;
	}

	public void setDishStat(Integer dishId, Integer stat) {
		dishStats.put(dishId, stat);
	}

	public void increaseDishStat(Integer dishId) {
		Integer stat = dishStats.get(dishId);
		if (stat != null) {
			dishStats.put(dishId, ++stat);
		} else {
			dishStats.put(dishId, 1);
		}
	}
}
