package services;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import dao.StatTrackerDao;
import entity.Dish;
import entity.DishType;
import entity.Meal;
import entity.MealType;
import entity.StatTracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MealService {

    private List<Dish> mainDishes = new ArrayList<Dish>();
    private List<Dish> sideDishes = new ArrayList<Dish>();
    private StatTrackerDao statDao = new StatTrackerDao();
    private StatTracker statTracker = new StatTracker(statDao.getAll());

    public void populateLists(List<Dish> dishes) {
        mainDishes.removeAll(mainDishes);
        sideDishes.removeAll(sideDishes);

        if (!dishes.isEmpty()) {
            dishes.forEach(dish -> {
                if (dish.getType() == DishType.MAIN) {
                    mainDishes.add(dish);
                } else {
                    sideDishes.add(dish);
                }
            });
        }
    }

    public Meal getMeal(MealType type, int numOfSides) {
        int index = getRandomNum(mainDishes.size());
        Dish mainDish = mainDishes.get(index);
        
        try {
			statDao.increaseDishStat(mainDish.getDishId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        if (mainDishes.size() > 2) mainDishes.remove(index);
        List<Dish> sides = new ArrayList<Dish>();

        for (int i = 0; i < numOfSides; i++) {
        	int sideDishCount = sideDishes.size();
            index = getRandomNum(sideDishCount);
            Dish side = sideDishes.get(index);
            sides.add(side);
            
            try {
    			statDao.increaseDishStat(side.getDishId());
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
            
            if (sideDishes.size() > 2) sideDishes.remove(index);
        }

        return new Meal(mainDish, sides, type);
    }

    public List<Meal> getDaysMeals(List<Dish> dishes) {
    	populateLists(dishes);
        List<Meal> meals = new ArrayList();
        meals.add(getMeal(MealType.BREAKFAST, getRandomNum(3)));
        meals.add(getMeal(MealType.LUNCH, getRandomNum(3)));
        meals.add(getMeal(MealType.DINNER, getRandomNum(3)));

        return meals;
    }

    private int getRandomNum(int max) {
        Random rand = new Random();
        int r = rand.nextInt(max);
        return r;
    }

}
