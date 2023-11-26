package app;

import app.HouseFacade;

public class Main {

    public static void main(String[] args) {
        /**
         * The power of the facade created allows the abstraction of the components.
         * This theater is now usable using easy commands that would've taken many.
         * Both this file and HouseFacade.java are part of the exercize,
         * other files were given.
         */

        // Create the theater
        HouseFacade homeTheater = new HouseFacade();

        // Watch a movie
        homeTheater.WatchMovie("Pokémon - Destiny Deoxys");
        homeTheater.StopWatchingMovie();

        // Listen to music
        homeTheater.ListenMusic("The Brown Brothers - Immortal");
        homeTheater.StopListeningMusic();

        // Listen to the radio
        homeTheater.ListenToRadio(103.2);
        homeTheater.StopListeningToRadio();
    }
}
