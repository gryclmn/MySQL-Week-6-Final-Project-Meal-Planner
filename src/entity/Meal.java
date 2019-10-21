package entity;

import java.util.List;

public class Meal {

	private Dish mainDish;
	private List<Dish> sideDishes;
	private MealType type;

	public Meal(Dish mainDish, List<Dish> sideDishes, MealType type) {
		this.mainDish = mainDish;
		this.sideDishes = sideDishes;
		this.type = type;
	}

	public Dish getMainDish() {
		return mainDish;
	}

	public void setMainDish(Dish mainDish) {
		this.mainDish = mainDish;
	}

	public List<Dish> getSideDishes() {
		return sideDishes;
	}

	public void setSideDishes(List<Dish> sideDishes) {
		this.sideDishes = sideDishes;
	}

	public MealType getType() {
		return type;
	}

	public void setType(MealType type) {
		this.type = type;
	}
}