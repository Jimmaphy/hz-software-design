package Art;

public class Rectangle extends Ascii {
    /**
     * Create a rectangle.
     * 
     * @param character the character you want the rectangle printed as.
     * @param width the width of the rectangle in number of rows.
     * @param height the height of the rectangle in number of columns.
     * @param x the top-left x coordinate (horizontal).
     * @param y the top-left y coordinate (vertical).
     */
    public Rectangle(char character, int width, int height, int x, int y) {
        super(character, width, height, x, y);
    }

    /** Draw the art to the screen. */
    @Override
    public void Draw() {
        for (int rowNumber = 0; rowNumber < this.height; rowNumber++) {
            String startPosition = String.format("%c[%d;%df", 0x1B, rowNumber + this.y, this.x);
            System.out.print(startPosition);

            for (int columnNumber = 0; columnNumber < this.width; columnNumber++) {
                System.out.print(this.character);
            }

            System.out.println("");
        }
    }
}
