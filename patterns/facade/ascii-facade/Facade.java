import Art.Ascii;
import Art.Rectangle;
import Art.Triangle;

public class Facade {
    public static void main(String[] args) {
        /**
         * Sometimes, interfaces are difficult and complicated.
         * You need to take a lot of steps to get the desired result.
         * By using the Facade pattern, we can easily abstract complicated messes;
         * into something that is actually fun to use.
         * We can turn code that looks like this:
         * 
         * clearConsole();
         * 
         * Ascii art = new Rectangle('X', 4, 4, 4, 4);
         * Ascii otherArt = new Triangle('O', 4, 4, 8, 5);
         * 
         * art.Draw();
         * otherArt.Draw();
         */

        
        // Into code that looks like this
        AsciiFacade.ClearScreen();
        AsciiFacade.DrawRectangle('X', 4, 4, 4, 4);
        AsciiFacade.DrawTriangle('O', 8, 8, 5);
    }
}