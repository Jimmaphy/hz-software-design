import strategy.FoodPrepStrategy;

/**
 * The FoodContext class represents a context in which food can be prepared using different strategies.
 * It utilizes the FoodPrepStrategy interface to define how food should be prepared.
 */
public class FoodContext {

    /**
     * The strategy by which to prepare the food.
     */
    private FoodPrepStrategy Strategy;

    /**
     * Constructs a new FoodContext with the given initial strategy.
     *
     * @param initialStrategy the initial food preparation strategy
     */
    public FoodContext(FoodPrepStrategy initialStrategy) {
        this.Strategy = initialStrategy;
    }

    /**
     * Sets the strategy for preparing food in this FoodContext.
     * The strategy defines how the food should be prepared.
     *
     * @param strategy the food preparation strategy to be set
     */
    public void setStrategy(FoodPrepStrategy strategy) {
        Strategy = strategy;
    }

    /**
     * Prepares the specified food using the current food preparation strategy.
     * Logs every step of the preparation to the console.
     *
     * @param food the type of food to be prepared
     */
    public void prepareFood(String food) {
        for (String step : this.Strategy.prepareFood(food)) {
            System.out.println(step);
        }
    }
}