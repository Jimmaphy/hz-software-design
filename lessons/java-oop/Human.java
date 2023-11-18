/** A representation of a human being. */
public class Human {

    // Create the age and name properties of the person
    private int age;
    private String name;

    /**
     * Create an instance of the Human class.
     * 
     * @param age  the current age of the human in years.
     * @param name the name of the human.
     */
    public Human(int age, String name) {
        // Set the properties
        this.age = age;
        this.name = name;
    }

    /**
     * An alternative instantiation of an anonymous Human.
     * 
     * @param age the current age of the human in years.
     */
    public Human(int age) {
        // Set the properties
        this.age = age;
        this.name = "Anonymous";
    }

    /**
     * Get the information of the person as string.
     * This includes both the name and the age.
     * 
     * @return the information of the passenger formated: "[name] ([age])"
     */
    public String announce() {
        return this.name + " (" + this.age + ")";
    }
}