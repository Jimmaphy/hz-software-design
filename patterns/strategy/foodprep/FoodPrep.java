import strategy.OvenStrategy;
import strategy.WokStrategy;

/**
 * The FoodPrep class is used for demonstrating the usage of the FoodContext class and its associated strategies.
 * It shows how different strategies can be used to prepare different types of food.
 */
class FoodPrep {

    /**
     * The main method is the entry point for the application.
     * Show the functionality of the strategy pattern by preparing food in different ways.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Show how the foodContext works by making the first dish
        FoodContext foodContext = new FoodContext(new WokStrategy());
        foodContext.prepareFood("Egg Fried Rice");

        // All that's needed to do to change the prep style is change the strategy
        foodContext.setStrategy(new OvenStrategy());
        foodContext.prepareFood("Apple Pie");
    }
}