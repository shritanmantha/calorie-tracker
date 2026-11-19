import java.util.ArrayList;
import java.util.Scanner;

// Runs the interactive command line interface for tracking meals and daily macro totals
public class Main {
    private static final int DAILY_CALORIE_GOAL = 2200;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<FoodItem> meals = new ArrayList<>();
        boolean running = true;

        System.out.println("=== Calorie & Macro Tracker ===");

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                logMeal(scanner, meals);
            } else if (choice.equals("2")) {
                viewSummary(meals);
            } else if (choice.equals("3")) {
                running = false;
                System.out.println("Exiting tracker. Good luck with your goals!");
            } else {
                System.out.println("Invalid option. Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n1. Log a meal");
        System.out.println("2. View daily summary");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    private static void logMeal(Scanner scanner, ArrayList<FoodItem> meals) {
        System.out.print("Meal name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Meal name cannot be empty.");
            return;
        }

        // Use nextLine() + parsing so stray newlines don't skip future prompts
        Integer calories = readNonNegativeInt(scanner, "Calories: ");
        Double protein = readNonNegativeDouble(scanner, "Protein (g): ");
        Double carbs = readNonNegativeDouble(scanner, "Carbs (g): ");
        Double fats = readNonNegativeDouble(scanner, "Fats (g): ");

        if (calories == null || protein == null || carbs == null || fats == null) {
            System.out.println("Meal not saved due to invalid numeric input.");
            return;
        }

        meals.add(new FoodItem(name, calories, protein, carbs, fats));
        System.out.println("Logged: " + name);
    }

    private static void viewSummary(ArrayList<FoodItem> meals) {
        if (meals.isEmpty()) {
            System.out.println("No meals logged yet today.");
            return;
        }

        int totalCalories = 0;
        double totalProtein = 0;
        double totalCarbs = 0;
        double totalFats = 0;

        System.out.println("\n--- Today's Meals ---");
        for (FoodItem item : meals) {
            System.out.println("  " + item);
            totalCalories += item.getCalories();
            totalProtein += item.getProtein();
            totalCarbs += item.getCarbs();
            totalFats += item.getFats();
        }

        int remaining = DAILY_CALORIE_GOAL - totalCalories;
        System.out.println("---------------------");
        System.out.printf("Total Calories: %d / %d kcal (%d remaining)%n",
                totalCalories, DAILY_CALORIE_GOAL, remaining);
        System.out.printf("Total Macros: %.1fg Protein | %.1fg Carbs | %.1fg Fats%n",
                totalProtein, totalCarbs, totalFats);
    }

    private static Integer readNonNegativeInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            int value = Integer.parseInt(scanner.nextLine().trim());
            if (value < 0) {
                System.out.println("Please enter a non-negative whole number.");
                return null;
            }
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid whole number.");
            return null;
        }
    }

    private static Double readNonNegativeDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        try {
            double value = Double.parseDouble(scanner.nextLine().trim());
            if (value < 0) {
                System.out.println("Please enter a non-negative number.");
                return null;
            }
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return null;
        }
    }
}