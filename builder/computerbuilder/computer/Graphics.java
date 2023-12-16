package computer;

/**
 * The Graphics class represents a computer case.
 */
public class Graphics {

    /**
     * The name of the computer case.
     */
    private final String name;

    /**
     * Constructs a new Graphics object with the given name.
     *
     * @param name the name of the computer case
     */
    public Graphics(String name) {
        this.name = name;
    }

    /**
     * Returns the string representation of the Graphics object.
     *
     * @return the name of the graphics
     */
    @Override
    public String toString() {
        return this.name;
    }
}