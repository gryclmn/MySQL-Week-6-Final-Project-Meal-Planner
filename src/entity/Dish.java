package entity;

public class Dish {
	private Integer dishId;
	private String dishName;
	private DishType type;
	
	public Dish(Integer dishId, String dishName, DishType type){
		this.dishName = dishName;
		this.dishId = dishId;
		this.type = type;
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

	public DishType getType() {
		return type;
	}

	public void setType(DishType type) {
		this.type = type;
	}

}
