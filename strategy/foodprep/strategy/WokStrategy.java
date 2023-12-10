package strategy;

/**
 * The WokStrategy class represents a food preparation strategy using a wok.
 * It implements the FoodPrepStrategy interface and defines how food is prepared using a wok.
 */
public class WokStrategy implements FoodPrepStrategy {

    /**
     * Prepares the given food using a wok for cooking.
     *
     * @param food the type of food to be prepared
     * @return an array of strings representing the steps in preparing the food using a wok
     */
    @Override
    public String[] prepareFood(String food) {
        return new String[]{"Heated wok", "Oiled wok", "Seasoned wok", "Thrown in " + food, "Plated " + food, "Served"};
    }
}
