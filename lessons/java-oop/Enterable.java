import java.util.NoSuchElementException;

/** Interface definiton for an object that can be entered by humans. */
public interface Enterable {
    
    /**
     * Humans should be able to enter the object.
     * 
     * @param human the person trying to enter.
     * @throws Exception if a human tries to enter an single-person object that is occupied.
     */
    void enter(Human human) throws Exception;

    /**
     * When leaving, the human present is returned to the code.
     * 
     * @return the human that left the object.
     * @throws NoSuchElementException whenever there is no human to leave the object.
     */
    Human leave() throws NoSuchElementException;
}