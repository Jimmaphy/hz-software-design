import java.util.NoSuchElementException;

/** Representation of a house, which implements the Enterable interface. */
public class House implements Enterable {
    
    // Make a property that stores the human currently in the house
    private Human human;

    /**
     * The house is enterable by a human.
     * Save the given human as if they've entered the house.
     * 
     * @param human the person entering te house.
     * @throws Exception when a person is already occupiying the house.
     */
    public void enter(Human human) throws Exception {
        // Check whether there is human inside the house, throw an exception if true
        if (this.hasHumanInside()) {
            throw new Exception("There is already a human inside the house");
        }

        // Set the human property to the new Human.
        this.human = human;
    }

    /**
     * Human should be able to leave the house.
     * Return the Human object when they do so.
     * Make sure the human property is reset.
     * 
     * @return the human leaving the house.
     * @throws NoSuchElementException when there is no human inside the house.
     */
    public Human leave() throws NoSuchElementException {
        // Check whether there is a human in the house, throw an exception if not
        if (this.human == null) {
            throw new NoSuchElementException();
        }

        // Get the current human and reset the variable
        Human human = this.human;
        this.human = null;

        // Return the human leaving the house
        return human;
    }

    /**
     * Check whether there is a human inside the house
     * 
     * @return true if there is a human inside the house, false otherwise.
     */
    public boolean hasHumanInside() {
        return this.human != null;
    }
}