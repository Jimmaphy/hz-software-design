/** The starting class of the lecture. */
public class Main {

    /**
     * The start function within the application.
     * 
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Creation of objects
        Human teacher = new Teacher(42, "Andries");
        Human student = new Student(25, "Jimmy");
        Enterable apv = new House();
        Enterable line58 = new Bus();

        // Casting of objects
        String msg = ((Student) student).complain();
        System.out.println(msg);

        // Using the house
        apv.enter(teacher);
        apv.leave();

        // Using the bus
        line58.enter(teacher);
        line58.enter(student);
        ((Bus) line58).report();
    }
}