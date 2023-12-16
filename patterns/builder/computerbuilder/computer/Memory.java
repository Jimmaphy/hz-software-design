package computer;

/**
 * The Memory class represents a computer case.
 */
public class Memory {

    /**
     * The name of the computer case.
     */
    private final String name;

    /**
     * Constructs a new Memory object with the given name.
     *
     * @param name the name of the computer case
     */
    public Memory(String name) {
        this.name = name;
    }

    /**
     * Returns the string representation of the Memory object.
     *
     * @return the name of the memory
     */
    @Override
    public String toString() {
        return this.name;
    }
}