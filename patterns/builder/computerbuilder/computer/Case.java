package computer;

/**
 * The Case class represents a computer case.
 */
public class Case {

    /**
     * The name of the computer case.
     */
    private final String name;

    /**
     * Constructs a new Case object with the given name.
     *
     * @param name the name of the computer case
     */
    public Case(String name) {
        this.name = name;
    }

    /**
     * Returns the string representation of the Case object.
     *
     * @return the name of the computer case
     */
    @Override
    public String toString() {
        return this.name;
    }
}