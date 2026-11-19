// Stores a single meal and its macronutrient breakdown
public class FoodItem {
    private String name;
    private int calories;
    private double protein;
    private double carbs;
    private double fats;

    public FoodItem(String name, int calories, double protein, double carbs, double fats) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFats() {
        return fats;
    }

    // Formats the meal as a comma separated line for CSV storage
    public String toCsvRow() {
        return name + "," + calories + "," + protein + "," + carbs + "," + fats;
    }

    @Override
    public String toString() {
        return String.format("%s - %d kcal (P: %.1fg | C: %.1fg | F: %.1fg)",
                name, calories, protein, carbs, fats);
    }
}