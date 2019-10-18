package entity;

public class Dish {
	private Integer dishId;
	private String dishName;
	
	Dish(Integer dishId, String dishName){
		this.dishName = dishName;
		this.dishId = dishId;
	}
// getters / setters
	public Integer getDishId() {
		return dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
}
