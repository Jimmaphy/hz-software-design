/** Representation of teacher, which is also a human being. */
public class Teacher extends Human {

    /**
     * Insantiate a new teacher.
     * 
     * @param age  the current age of the human in years.
     * @param name the name of the human.
     */
    public Teacher(int age, String name) {
        // Call the constructor of the super class, Human
        super(age, name);
    }
}