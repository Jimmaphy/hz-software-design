import Art.Rectangle;
import Art.Triangle;

/**
 * Facade class to simplify the interaction with all ASCII arts subclasses.
 * This way, we have a simple interface to talk with;
 * and we only have the functions we need.
 */
public class AsciiFacade {

    /**
     * Clear the screen of the console.
     * This function is not included in the original, but necessary to make our life easy.
     * So we include it in the facade.
     */
    public static void ClearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    /**
     * Draw a rectangle. This function creates an instance of the rectangle class
     * and draws it to the screen.
     * 
     * @param character the character you want the rectangle printed as.
     * @param width the width of the rectangle in number of rows.
     * @param height the height of the rectangle in number of columns.
     * @param x the top-left x coordinate (horizontal).
     * @param y the top-left y coordinate (vertical).
     */
    public static void DrawRectangle(char character, int width, int height, int x, int y) {
        Rectangle rectangle = new Rectangle(character, width, height, x, y);
        rectangle.Draw();
    }

    /**
     * Draw a triangle. This function creates an instance of the triangle class
     * and draws it to the screen.
     * 
     * @param character the character you want the rectangle printed as.
     * @param base the length of the base of the triangle, in number of columns.
     * @param x the top-left x coordinate (horizontal).
     * @param y the top-left y coordinate (vertical).
     */
    public static void DrawTriangle(char character, int base, int x, int y) {
        Triangle triangle = new Triangle(character, base, x, y);
        triangle.Draw();
    }
}
