package strategy;

/**
 * The FoodPrepStrategy interface represents a strategy for preparing food.
 * Implementations of this interface define how food should be prepared.
 */
public interface FoodPrepStrategy {

    /**
     * Prepares the given food using the selected food preparation strategy.
     *
     * @param food the type of food to be prepared
     * @return an array of strings representing the preparation of the food
     */
    String[] prepareFood(String food);
}
