package computer;

/**
 * The Processor class represents a computer case.
 */
public class Processor {

    /**
     * The name of the computer case.
     */
    private final String name;

    /**
     * Constructs a new Processor object with the given name.
     *
     * @param name the name of the computer case
     */
    public Processor(String name) {
        this.name = name;
    }

    /**
     * Returns the string representation of the Processor object.
     *
     * @return the name of the processor
     */
    @Override
    public String toString() {
        return this.name;
    }
}