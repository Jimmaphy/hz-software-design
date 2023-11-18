public class Client {
    /** 
     * The client is perfoming actions where an ITarget is required, 
     * but a different class is used 
     */

    public static void main(String[] args) {
        /** Performs the action of ITarget using the adapter */

        // Create an new instance of the adapter and give it an adaptee
        Adaptee adaptee = new Adaptee();
        ITarget target = new Adapter(adaptee);

        // Thanks to the adapter, we can now use request instead of message.
        target.request();
    }
}