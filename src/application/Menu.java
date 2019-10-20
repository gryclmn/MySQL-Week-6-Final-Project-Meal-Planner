package application;

import dao.DishDao;
import dao.MealDao;
import dao.StatTrackerDao;
import entity.Dish;
import entity.StatTracker;
import utility.Printer;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Menu {

    private Scanner scanner = new Scanner(System.in);
    private List<String> options = Arrays.asList(
            "Display todays meal plan.",
            "Display this weeks meal plan.",
            "Recalculate a meal plan.",
            "Display all dishes.",
            "View and edit a dish.",
            "Create a dish.",
            "Exit"
    );

    private DishDao dishDao = new DishDao();
    private MealDao mealDao = new MealDao();
    private StatTrackerDao planDao = new StatTrackerDao();

    void start() {

        StatTracker statTracker = new StatTracker();
        System.out.println(statTracker.getDishStatById(1));
        statTracker.increaseDishStat(1);
        System.out.println(statTracker.getDishStatById(1));
        statTracker.setDishStat(1, 10);
        System.out.println(statTracker.getDishStatById(1));
        statTracker.increaseDishStat(1);
        System.out.println(statTracker.getDishStatById(1));

        String selection;

        do {
            printMenu();
            selection = scanner.nextLine();

            try {
                switch (selection) {
                    case "1": displayMealPlan();
                        break;
                    case "2": displayMealPlan();
                        break;
                    case "3": recalculateMealPlan();
                        break;
                    case "4": displayAllDishes();
                        break;
                    case "5": displayDish();
                        break;
                    case "6": createDish();
                        break;
                    case "7":
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

        } while (!selection.equals("7"));

    }

    private void printMenu() {
        Printer.printTitle("Main Menu");
        Printer.printInstructions("Select an option below:");

        for (int i = 0; i < options.size(); i++) {
            Printer.printOption(options.get(i), i + 1);
        }
    }

    private void displayMealPlan() throws SQLException {
        /* TODO - We could either pass in two arguments to get a time frame, and thus print
            a days worth of meal planning, or multiple days worth.
            OR we could have two seperate methods, one to print just a days worth, another
            for printing multiple days...?
        */
    }

    private void recalculateMealPlan() throws SQLException {
        // TODO - Redo a specific meal plan. It may be best to get from the user which meal plan to recalculate...

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
        // TODO - get specific dish from user and format its output using printDish()
        Printer.printSectionEnd();
        // TODO - It also may be a good idea to add options when viewing a dish to update and delete, instead of from the main menu
        /* TODO - It may be cool to track stats for a dish? ie: How many times has this dish been scheduled?
            This may be a future feature to add and less important now.
         */
    }

    private void printDish(Dish dish) {
        // TODO - Something like below?
//        Printer.printResponse("#" + dish.getId() + " " + dish.getName() + ......);
    }

    private void createDish() {
        // TODO - create dish
    }

}
