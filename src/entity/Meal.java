package entity;

import java.sql.Date;

public class Meal {
	
	private Integer mealId;
	private Integer mainDishId;
	private Integer[] sideDishIds;
	private Date mealTime;
	private MealType type;
	
	Meal(Integer mealId, Integer mainDishId, Integer[] sideDishIds, MealType mealType) {
		this.setMealId(mealId);
		this.setMainDishId(mainDishId);
		this.setMealTime(mealTime);
		this.type = mealType;
	}
//getters / setters
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
	public Date getMealTime() {
		return mealTime;
	}
	public void setMealTime(Date mealTime) {
		this.mealTime = mealTime;
	}
	public MealType getType() {
		return type;
	}
	public void setType(MealType type) {
		this.type = type;
	}
	
}