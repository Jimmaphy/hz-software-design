package Art;

/** The abstract Ascii class helps with creating ascii art. */
public abstract class Ascii implements IDrawable {
    /** The character to draw the art with. */
    protected char character;

    /** The width of the art in columns. */
    protected int width;

    /** The height of the art in rows. */
    protected int height;

    /** The top-left x coordinate of the object (horizontal). */
    protected int x;

    /** The top-left y coordinate of the object (vertical) */
    protected int y;

    /**
     * Create an instance of an Ascii object.
     * 
     * @param character the character you want the rectangle printed as.
     * @param width the width of the rectangle in number of rows.
     * @param height the height of the rectangle in number of columns.
     * @param x the top-left x coordinate (horizontal).
     * @param y the top-left y coordinate (vertical).
     */
    public Ascii(char character, int width, int height, int x, int y) {
        this.character  = character;
        this.width      = width;
        this.height     = height;
        this.x          = x;
        this.y          = y;
    }

    /**
     * Resize the art to a different size.
     * 
     * @param newWidth the new width of the art.
     * @param newHeight the new height of the art.
     */
    @Override
    public void Resize(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    /**
     * Reposition the art.
     * 
     * @param newX the new top-left x coordinate of the art (horizontal).
     * @param newY the new top-left y coordinate of the art (vertical).
     */
    @Override
    public void Move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     * Change the character used to draw the art.
     * 
     * @param newCharacter the new character to draw the art with.
     */
    @Override
    public void ChangeCharacter(char newCharacter) {
        this.character = newCharacter;
    }

    /** Draw the object to the screen. */
    @Override
    public abstract void Draw();
}
