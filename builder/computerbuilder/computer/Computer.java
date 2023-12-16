package computer;

/**
 * The Computer class represents a computer with various components.
 */
public class Computer {
    /**
     * Represents the type of computer.
     * Instance of the {@link ComputerType} enumeration.
     */
    private final ComputerType computerType;

    /**
     * The computer case is responsible for housing all the components of the computer,
     * ensuring they are protected and providing proper airflow for cooling.
     * It is an instance of the {@link Case} class.
     */
    private final Case computerCase;

    /**
     * The Motherboard class represents a motherboard of a computer.
     * The motherboard is a key component that connects all other components
     * of the computer, such as the processor, memory, storage, and graphics card.
     * It is an instance of the {@link Motherboard} class.
     */
    private final Motherboard motherboard;

    /**
     * The Processor class represents a processor of a computer.
     * It is a component of the computer that performs arithmetic,
     * logical, control, and input/output (I/O) operations.
     * It is an instance of the {@link Processor} class.
     */
    private final Processor processor;

    /**
     * The Graphics class represents a graphics card of a computer.
     * It is a component of the computer that handles the processing and rendering of visual data.
     * It is an instance of the {@link Graphics} class.
     */
    private final Graphics graphics;

    /**
     * The Memory class represents the memory component of a computer.
     * It stores data that the computer needs to access quickly.
     * The memory is an instance of the {@link Memory} class.
     */
    private final Memory memory;

    /**
     * The Storage class is responsible for managing the storage of the computer.
     * It can be used to store and retrieve data.
     * It is an instance of the {@link Storage} class.
     */
    private final Storage storage;

    /**
     * Constructs a new Computer object with the given components.
     *
     * @param computerCase the computer case for the computer
     * @param motherboard the motherboard for the computer
     * @param processor the processor for the computer
     * @param graphics the graphics card for the computer
     * @param memory the memory for the computer
     * @param storage the storage device for the computer
     */
    public Computer(ComputerType type, Case computerCase, Motherboard motherboard, Processor processor,
                    Graphics graphics, Memory memory, Storage storage) {
        this.computerType = type;
        this.computerCase = computerCase;
        this.motherboard = motherboard;
        this.processor = processor;
        this.graphics = graphics;
        this.memory = memory;
        this.storage = storage;
    }

    /**
     * Returns the string representation of the Computer object.
     * Prints the computer as an object formatted like an object,
     * listing all the different components inside
     *
     * @return a string representation of the Computer object
     */
    @Override
    public String toString() {
        return this.computerType.toString() + " Computer {" +
            "\n  computerCase: " + this.computerCase +
            "\n  motherboard: " + this.motherboard +
            "\n  processor: " + this.processor +
            "\n  graphics: " + this.graphics  +
            "\n  memory: " + this.memory +
            "\n  storage: " + this.storage +
        "\n}";
    }
}