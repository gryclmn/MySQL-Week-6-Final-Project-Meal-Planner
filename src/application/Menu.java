package application;

import dao.DishDao;
import dao.StatTrackerDao;
import entity.Dish;
import entity.Meal;
import services.MealService;
import utility.Printer;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Menu {

    private Scanner scanner = new Scanner(System.in);
    private List<String> options = Arrays.asList(
            "Display todays meal plan.",
            "Display all dishes.",
            "View and edit a dish.",
            "Create a dish.",
            "Exit"
    );

    private DishDao dishDao = new DishDao();
    private MealService mealService = new MealService();
    private StatTrackerDao statDao = new StatTrackerDao();

    void start() {
        
        String selection;

        do {
            printMenu();
            selection = scanner.nextLine();

            try {
                switch (selection) {
                    case "1": displayMealPlan();
                        break;
                    case "2": displayAllDishes();
                        break;
                    case "3": displayDish();
                        break;
                    case "4": createDish();
                        break;
                    case "5":
                        Printer.printAlert("Goodbye!");
                        break;
                    default:
                        Printer.printAlert("Invalid selection. Please try again.");
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                Printer.printAlert("There was an error retrieving the selected information.");
            }

            Printer.printInstructions("Press enter to continue...");
            scanner.nextLine();

        } while (!selection.equals("5"));

    }

    private void printMenu() {
        Printer.printTitle("Main Menu");
        Printer.printInstructions("Select an option below:");

        for (int i = 0; i < options.size(); i++) {
            Printer.printOption(options.get(i), i + 1);
        }
    }

    private void displayMealPlan() throws SQLException {
        List<Meal> meals = mealService.getDaysMeals(dishDao.getAllDishes());

        for (Meal meal : meals) {
        	Printer.printSubTitle(meal.getType().toString());
            displayMeal(meal);
        }
    }

    private void displayMeal(Meal meal) {
        Printer.printResponse("> Main Dish: " + meal.getMainDish().getDishName());
        StringBuilder sides = new StringBuilder();
        List<Dish> sideDishes = meal.getSideDishes();
        for (int i = 0; i < sideDishes.size(); i++) {
        	sides.append(sideDishes.get(i).getDishName());
        	if (i < sideDishes.size() -1) {
        		sides.append(", ");
        	} 
        }
        Printer.printResponse("\tSides: " + sides.toString());
    }

    private void displayAllDishes() throws SQLException {

        List<Dish> allDishes = dishDao.getAllDishes();

        Printer.printTitle("All Dishes");

        if (allDishes.size() == 0) Printer.printAlert("There are no dishes to display...");

        for (Dish dish : allDishes) {
            printDish(dish);
        }

        Printer.printSectionEnd();
    }

    private void displayDish() throws SQLException {
        Printer.printTitle("Dish");
        System.out.print("enter dish id");
        int id = Integer.parseInt(scanner.nextLine());
        Dish dish = dishDao.getDishById(id);
        printDish(dish);
        Printer.printSectionEnd();
        // TODO - It also may be a good idea to add options when viewing a dish to update and delete, instead of from the main menu
        /* TODO - It may be cool to track stats for a dish? ie: How many times has this dish been scheduled?
            This may be a future feature to add and less important now.
         */
    }

    private void printDish(Dish dish) {
        // TODO - Something like below?
        Printer.printResponse("#" + dish.getDishId() + " " + dish.getDishName() + " " + dish.getType());
    }

    private void createDish() throws SQLException {
        System.out.print("enter new dish name");
        String dishName = scanner.nextLine();
        System.out.print("enter dish type");
        String dishType = scanner.nextLine();
        dishDao.CreateNewDish(dishName, dishType);
    }

}
