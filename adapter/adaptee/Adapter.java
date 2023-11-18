class Adapter implements ITarget {
    /**
     * The class that confirms to the requested interface,
     * but uses an instance of another object to perform the tasks.
     */

    // Create a property that holds the adaptee
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        /**
         * Create an instance of the adapter class.
         * @param adaptee the instance of the adaptee class.
         */

        // Set the value
        this.adaptee = adaptee;
    }

    public void request() {
        /** Perform the request and print a message to the screen. */
        this.adaptee.message();
    }
}