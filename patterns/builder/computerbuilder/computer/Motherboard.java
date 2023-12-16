package computer;

/**
 * The Motherboard class represents a computer case.
 */
public class Motherboard {

    /**
     * The name of the computer case.
     */
    private final String name;

    /**
     * Constructs a new Motherboard object with the given name.
     *
     * @param name the name of the computer case
     */
    public Motherboard(String name) {
        this.name = name;
    }

    /**
     * Returns the string representation of the Motherboard object.
     *
     * @return the name of the motherboard
     */
    @Override
    public String toString() {
        return this.name;
    }
}