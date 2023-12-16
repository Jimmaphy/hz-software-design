package builder;

import computer.*;

/**
 * The DesktopBuilder class is an implementation of the ComputerBuilder interface
 * and is responsible for building desktop computers.
 */
public class DesktopBuilder implements ComputerBuilder {
    /**
     * The computer case is responsible for housing all the components of the computer,
     * ensuring they are protected and providing proper airflow for cooling.
     * It is an instance of the {@link Case} class.
     */
    private Case computerCase;

    /**
     * The Motherboard class represents a motherboard of a computer.
     * The motherboard is a key component that connects all other components
     * of the computer, such as the processor, memory, storage, and graphics card.
     * It is an instance of the {@link Motherboard} class.
     */
    private Motherboard motherboard;

    /**
     * The Processor class represents a processor of a computer.
     * It is a component of the computer that performs arithmetic,
     * logical, control, and input/output (I/O) operations.
     * It is an instance of the {@link Processor} class.
     */
    private Processor processor;

    /**
     * The Graphics class represents a graphics card of a computer.
     * It is a component of the computer that handles the processing and rendering of visual data.
     * It is an instance of the {@link Graphics} class.
     */
    private Graphics graphics;

    /**
     * The Memory class represents the memory component of a computer.
     * It stores data that the computer needs to access quickly.
     * The memory is an instance of the {@link Memory} class.
     */
    private Memory memory;

    /**
     * The Storage class is responsible for managing the storage of the computer.
     * It can be used to store and retrieve data.
     * It is an instance of the {@link Storage} class.
     */
    private Storage storage;

    /** {@inheritDoc} */
    @Override
    public void pickCase(Case computerCase) {
        this.computerCase = computerCase;
    }

    /** {@inheritDoc} */
    @Override
    public void addMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    /** {@inheritDoc} */
    @Override
    public void addProcessor(Processor processor) {
        this.processor = processor;
    }

    /** {@inheritDoc} */
    @Override
    public void addMemory(Memory memory) {
        this.memory = memory;
    }

    /** {@inheritDoc} */
    @Override
    public void addGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    /** {@inheritDoc} */
    @Override
    public void addStorage(Storage storage) {
        this.storage = storage;
    }

    /** {@inheritDoc} */
    @Override
    public void startOver() {
        this.computerCase = null;
        this.motherboard = null;
        this.processor = null;
        this.graphics = null;
        this.memory = null;
        this.storage = null;
    }

    /** {@inheritDoc} */
    @Override
    public Computer build() throws Exception {
        if (this.computerCase == null && this.motherboard == null && this.processor == null && this.memory == null) {
            throw new Exception("A computer needs at least a case, motherboard, processor and memory");
        }

        return new Computer(
                ComputerType.Desktop, this.computerCase, this.motherboard,
                this.processor, this.graphics, this.memory, this.storage
        );
    }
}
