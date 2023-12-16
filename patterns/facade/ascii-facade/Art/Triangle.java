package Art;

public class Triangle extends Ascii {
    /**
     * Create a triangle.
     * 
     * @param character the character you want the rectangle printed as.
     * @param base the length of the base of the triangle, in number of columns.
     * @param x the top-left x coordinate (horizontal).
     * @param y the top-left y coordinate (vertical).
     */
    public Triangle(char character, int base, int x, int y) {
        super(character, base, base, x, y);
    }

    /** Draw the art to the screen. */
    @Override
    public void Draw() {
        for (int rowNumber = 0; rowNumber < this.height; rowNumber++) {
            String startPosition = String.format("%c[%d;%df", 0x1B, rowNumber + this.y, this.x + rowNumber);
            System.out.print(startPosition);

            for (int columnNumber = 0; columnNumber < this.width - rowNumber * 2; columnNumber++) {
                System.out.print(this.character);
            }

            System.out.println("");
        }
    }
}
