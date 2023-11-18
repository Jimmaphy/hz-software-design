/** Representation of student, which is also a human. */
public class Student extends Human {

    /**
     * Create an instance of the student.
     * 
     * @param age  the current age of the human in years.
     * @param name the name of the human.
     */
    public Student(int age, String name) {
        // Call the constructor of the super class, Human
        super(age, name);
    }

    /**
     * Return a complaint from the student.
     * 
     * @return a complaint formatted as sentence.
     */
    public String complain() {
        return "It's always the same, every day I have to do...";
    }
}