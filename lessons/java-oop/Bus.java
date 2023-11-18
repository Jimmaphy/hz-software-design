import java.util.ArrayList;
import java.util.NoSuchElementException;

/** Representation of a bus, an enterable object that can hold multiple people. */
public class Bus implements Enterable {
    
    // Create a list that holds the people
    private ArrayList<Human> seats;

    /**
     * Create an instance of the bus.
     * The bus is initialized with an empty ArrayList of seats.
     */
    public Bus() {
        this.seats = new ArrayList<>();
    }

    /**
     * Let a person enter the bus.
     * The person is put on a seat.
     * 
     * @param passenger the person entering the bus.
     */
    public void enter(Human passenger) {
        this.seats.add(passenger);
    }

    /**
     * Let the person that first entered out of the bus.
     * 
     * @return The first passenger on the bus.
     * @throws NoSuchElementException when there are no passengers on the bus.
     */
    public Human leave() throws NoSuchElementException {
        return this.seats.removeFirst();
    }

    /**
     * Give a report on the people on the bus.
     * When passengers are present, their names will be shown.
     * When passengers are not, this will be said.
     * The answer is printed to the console immidiately.
     */
    public void report() {
        // Check wheter there are passenger on the bus, if not, say so
        if (this.seats.size() == 0) {
            System.out.println("There are no passengers on the bus.");
        } 
        
        // Get the name of all passengers and print them to the console
        else {
            System.out.println("On the bus are: ");

            for (Human passenger : this.seats) {
                System.out.println(passenger.announce());
            }
        }
    }
}