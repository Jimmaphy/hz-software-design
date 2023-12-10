package com.hz;

import java.awt.geom.NoninvertibleTransformException;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Your code here

        /**
         * The BooleanReaderAdapter turns the ConsoleReader into one for boolean values.
         * It's not really an adapter, it's more of a proxy,
         * which would be the prefered solution.
         * But since there is no interface to adapt to,
         * this is the only solution I can come up with,
         * considering the limitation of not being able to change the given classes.
         * 
         * It's only an adapter since it still returns a string instead of a boolean,
         * and it extending the ConsoleReader class.
         * Though it could have been a stand-alone class...
         * It is adapted to the logic of the client, not necessary a target interface.
         * The logic of the client is the target interface in this case.
         * 
         * One could try to adapt the String class,
         * though that would better be done using an extension method.
         * If you really wanted a pattern, a proxy would still be beter.
         */
        class BooleanReaderAdapter extends ConsoleReader {

            /** The instance of ConsoleReader to be adapted through the function */
            private ConsoleReader reader;

            /** A collection containing the string that are consideren positive */
            private ArrayList<String> positiveStrings;

            /**
             * Create a new instance of the BooleanReader.
             * The instance of the service is created and the positive strings are stored.
             */
            public BooleanReaderAdapter() {
                this.reader = new ConsoleReader();
                this.positiveStrings = new ArrayList<String>(Arrays.asList(
                    "true", "yes", "oh yeah", "great", "sure", "love to", "of course", "always",
                    "never done otherwise", "yep"
                ));
            }

            /**
             * The new version of the readLine function checks whether values are positive.
             * String that are possitive include:
             * "true", "yes", "oh yeah", "great", "sure", "love to", "of course", "always",
             * "never done otherwise", "yep"
             * 
             * @return "Yep" if considered positive, the input value otherwise.
             */
            @Override
            public String readLine() {
                String input = this.reader.readLine();
                return this.positiveStrings.contains(input.toLowerCase()) ? "Yep" : input;
            }
        }

        // ConsoleReader reader = new ConsoleReader();
        ConsoleReader reader = new BooleanReaderAdapter();
        ConsoleWriter writer = new ConsoleWriter();

        // ask questions
        String q1 = "Do you like eating vegetables?";

        String good = "You healthy person!";
        String bad = "Maybe you should try to eat some carrots";

        // ask question to user
        writer.write(q1);

        // read response
        Boolean ans1 = reader.readLine().equals("Yep");

        // give reaction
        if (ans1) {
            writer.write(good);
        } else {
            writer.write(bad);
        }

        // allow user to read our reaction
        reader.readLine();
    }
}
