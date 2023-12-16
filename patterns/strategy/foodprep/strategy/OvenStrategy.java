package strategy;

/**
 * The OvenStrategy class represents a strategy for preparing food using an oven.
 * It implements the FoodPrepStrategy interface and defines how food is prepared using an oven.
 */
public class OvenStrategy implements FoodPrepStrategy {

    /**
     * Prepares the given food using an oven.
     *
     * @param food the type of food to be prepared
     * @return an array of strings representing the steps to prepare the food
     */
    @Override
    public String[] prepareFood(String food) {
        return new String[]{
                "Preheat the oven to the appropriate temperature.",
                "Place " + food + " in an oven-safe dish.",
                "Set the dish in the oven.",
                "Bake until " + food + " is done.",
                "Remove " + food + " from the oven and let it cool before serving."
        };
    }
}