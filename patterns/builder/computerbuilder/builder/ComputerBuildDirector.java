package builder;

import computer.*;

/**
 * The ComputerBuildDirector class is responsible for building different types of computers using specific builders.
 */
public class ComputerBuildDirector {
    /**
     * Builds a MacBook computer.
     *
     * @return the built MacBook computer
     */
    public Computer BuildMacBook() {
        LaptopBuilder builder = new LaptopBuilder();
        builder.pickCase(new Case("MacBook Pro"));
        builder.addMotherboard(new Motherboard("Apple Logic Board"));
        builder.addProcessor(new Processor("Apple M3"));
        builder.addMemory(new Memory("Apple Magic Memory"));
        builder.addStorage(new Storage("Apple Magic SSD"));

        try { return builder.build(); }
        catch(Exception exception) { System.out.println("Error building MacBook"); }
        return null;
    }

    /**
     * Builds a computer.
     *
     * @return the built computer
     */
    public Computer BuildComputer() {
        DesktopBuilder builder = new DesktopBuilder();
        builder.pickCase(new Case("Asus SuperCase"));
        builder.addMotherboard(new Motherboard("Asus Gaming Pro Deluxe"));
        builder.addProcessor(new Processor("Intel Core i9-12345S"));
        builder.addMemory(new Memory("MSI Pro Memory"));
        builder.addGraphics(new Graphics("NVIDIA SuperPower Graphics"));
        builder.addStorage(new Storage("Western Digital Big SSD"));

        try { return builder.build(); }
        catch(Exception exception) { System.out.println("Error building Computer"); }
        return null;
    }
}
