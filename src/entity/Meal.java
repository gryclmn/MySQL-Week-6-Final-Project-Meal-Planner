package entity;

public class Meal {
	
	private Integer mealId;
	private Integer mainDishId;
	private Integer[] sideDishIds;
	private MealType type;

	public Meal(Integer mealId, Integer mainDishId, Integer[] sideDishIds, MealType type) {
		this.mealId = mealId;
		this.mainDishId = mainDishId;
		this.sideDishIds = sideDishIds;
		this.type = type;
	}

	public Integer getMealId() {
		return mealId;
	}

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	public Integer getMainDishId() {
		return mainDishId;
	}

	public void setMainDishId(Integer mainDishId) {
		this.mainDishId = mainDishId;
	}

	public Integer[] getSideDishIds() {
		return sideDishIds;
	}

	public void setSideDishIds(Integer[] sideDishIds) {
		this.sideDishIds = sideDishIds;
	}

	public MealType getType() {
		return type;
	}

	public void setType(MealType type) {
		this.type = type;
	}
}