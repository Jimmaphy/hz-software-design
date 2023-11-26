package app;

import app.Amplifier;
import app.CdPlayer;
import app.DvdPlayer;
import app.PopcornPopper;
import app.Projector;
import app.Screen;
import app.TheaterLights;
import app.Tuner;

/** An easy interface to control your home theater setup. */
public class HouseFacade {

    private Amplifier Amplifier;
    private Tuner Tuner;
    private DvdPlayer DvdPlayer;
    private CdPlayer CdPlayer;
    private Projector Projector;
    private TheaterLights TheaterLights;
    private Screen Screen;
    private PopcornPopper PopcornPopper;

    /**
     * Create an instance of the facade by creating a default home theater setup.
     * This uses Top-O-Line products for all the entertainment one could want.
     */
    public HouseFacade() {
        // Create the default theater setup
        this.Amplifier = new Amplifier("Top-O-Line Amplifier");
        this.Tuner = new Tuner("Top-O-Line AM/FM Tuner", this.Amplifier);
        this.DvdPlayer = new DvdPlayer("Top-O-Line DVD Player", this.Amplifier);
        this.CdPlayer = new CdPlayer("Top-O-Line CD Player", this.Amplifier);
        this.Projector = new Projector("Top-O-Line Projector", this.DvdPlayer);
        this.TheaterLights = new TheaterLights("Theater Ceiling Lights");
        this.Screen = new Screen("Theater Screen");
        this.PopcornPopper = new PopcornPopper("Popcorn Popper");
    }

    /**
     * Create a custom instance of the facade with your own gear.
     * 
     * @param amp       the amplifier.
     * @param tuner     the tuner.
     * @param dvd       the dvd player.
     * @param cd        the cd player.
     * @param projector the projector.
     * @param lights    the lights.
     * @param screen    the screen.
     * @param popper    the popcorn popper.
     */
    public HouseFacade(
            Amplifier amp,
            Tuner tuner,
            DvdPlayer dvd,
            CdPlayer cd,
            Projector projector,
            TheaterLights lights,
            Screen screen,
            PopcornPopper popper) {

        // Register the user's devices for use
        this.Amplifier = amp;
        this.Tuner = tuner;
        this.DvdPlayer = dvd;
        this.CdPlayer = cd;
        this.Projector = projector;
        this.TheaterLights = lights;
        this.Screen = screen;
        this.PopcornPopper = popper;
    }

    /**
     * Prepare the theater to watch a movie.
     * This function prepares:
     * - Popcorn
     * - Screen
     * - Projector
     * - Amplifier
     * - DvdPlayer
     * - Lights
     * 
     * @param movie the movie to play.
     */
    public void WatchMovie(String movie) {
        // Prepare the popcorn
        this.PopcornPopper.on();
        this.PopcornPopper.pop();

        // Prepare the room
        this.TheaterLights.dim(10);
        this.Screen.down();
        this.Projector.on();
        this.Amplifier.on();
        this.DvdPlayer.on();

        // Set the settings
        this.Projector.wideScreenMode();
        this.Amplifier.setDvd(this.DvdPlayer);
        this.Amplifier.setSurroundSound();
        this.DvdPlayer.setSurroundAudio();
        this.Amplifier.setVolume(5);

        // Play the movie
        this.DvdPlayer.play(movie);
    }

    /**
     * Return the room to it's base state after a movie.
     * This functions cleans:
     * - Popcorn
     * - Screen
     * - Projector
     * - Amplifier
     * - DvdPlayer
     * - Lights
     */
    public void StopWatchingMovie() {
        // Stop the movie
        this.DvdPlayer.stop();
        this.DvdPlayer.eject();

        // Reverse the room
        this.TheaterLights.on();
        this.Screen.up();

        // Turn off devices
        this.PopcornPopper.off();
        this.Projector.off();
        this.Amplifier.off();
        this.DvdPlayer.off();
    }

    /**
     * Prepare the theater to listen to some grooves.
     * This function prepares:
     * - Lights
     * - Amplifier
     * - CdPlayer
     * 
     * @param cd the cd to listen to.
     */
    public void ListenMusic(String cd) {
        // Prepare the room
        this.TheaterLights.on();
        this.Amplifier.on();
        this.CdPlayer.on();

        // Set the correct settings
        this.Amplifier.setCd(this.CdPlayer);
        this.Amplifier.setVolume(5);
        this.Amplifier.setStereoSound();

        // Play the cd
        this.CdPlayer.play(cd);
    }

    /**
     * Return the room to its former glory after banging to some tunes.
     * This functions resets:
     * - Amplifier
     * - CdPlayer
     */
    public void StopListeningMusic() {
        // Turn every off
        this.Amplifier.off();
        this.CdPlayer.eject();
        this.CdPlayer.off();
    }

    /**
     * Prepare the room for some easy radio listening.
     * This function prepares:
     * - Tuner
     * - Amplifier
     * 
     * @param frequency the frequency you wanna listen to.
     */
    public void ListenToRadio(double frequency) {
        // Turn on the devices
        this.Tuner.on();
        this.Amplifier.on();

        // Set the right settings
        this.Tuner.setFrequency(frequency);
        this.Amplifier.setVolume(5);
        this.Amplifier.setTuner(this.Tuner);
    }

    /**
     * Reset the room after some calm and relaxing radio vibes.
     * This function resets:
     * - Tuner
     * - Amplifier
     */
    public void StopListeningToRadio() {
        // Turn the devices off
        this.Tuner.off();
        this.Amplifier.off();
    }
}