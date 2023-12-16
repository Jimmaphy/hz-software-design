package builder;

import computer.*;

/**
 * The ComputerBuilder interface defines the methods for building a computer.
 */
public interface ComputerBuilder {
    /**
     * Sets the computer case for the computer.
     * The computer case is responsible for housing all the components of the computer.
     *
     * @param computerCase the computer case to set
     */
    void pickCase(Case computerCase);

    /**
     * Adds a motherboard to the computer.
     * The motherboard connects all the other components together.
     *
     * @param motherboard the motherboard to add
     */
    void addMotherboard(Motherboard motherboard);

    /**
     * Adds a processor to the computer.
     * The processor is the brain of the computer, performing the calculations.
     *
     * @param processor the processor to add
     */
    void addProcessor(Processor processor);

    /**
     * Adds memory to the computer.
     * The memory is the short-term memory of the computer.
     *
     * @param memory the memory to add to the computer
     */
    void addMemory(Memory memory);

    /**
     * Adds a graphics card to the computer.
     * A graphics card is a component of the computer that handles the processing and rendering of visual data.
     *
     * @param graphics the graphics card to add to the computer
     */
    void addGraphics(Graphics graphics);

    /**
     * Adds a storage device to the computer being built.
     * The storage provides long-term memory to the computer.
     *
     * @param storage the storage device to add to the computer
     */
    void addStorage(Storage storage);

    /**
     * Resets the computer builder to its initial state.
     * This method clears all the components that have been added to the computer builder.
     * After calling this method, the builder is ready to build a new computer.
     */
    void startOver();

    /**
     * Builds a computer using the provided components.
     *
     * @return the built Computer object
     * @throws Exception if there was an error during the build process
     */
    Computer build() throws Exception;
}
