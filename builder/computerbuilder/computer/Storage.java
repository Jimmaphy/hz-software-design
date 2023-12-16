package computer;

/**
 * The Storage class represents a computer case.
 */
public class Storage {

    /**
     * The name of the computer case.
     */
    private final String name;

    /**
     * Constructs a new Storage object with the given name.
     *
     * @param name the name of the computer case
     */
    public Storage(String name) {
        this.name = name;
    }

    /**
     * Returns the string representation of the Storage object.
     *
     * @return the name of the storage
     */
    @Override
    public String toString() {
        return this.name;
    }
}