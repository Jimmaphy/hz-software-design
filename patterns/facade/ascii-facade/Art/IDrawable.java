package Art;

/** An interface that can be used to draw things to the console. */
public interface IDrawable {
    /**
     * Resize the object to a different size.
     * 
     * @param newWidth the new width of the object.
     * @param newHeight the new height of the object.
     */
    public void Resize(int newWidth, int newHeight);

    /**
     * Reposition the object.
     * 
     * @param newX the new top-left x coordinate of the object (horizontal).
     * @param newY the new top-left y coordinate of the object (vertical).
     */
    public void Move(int newX, int newY);

    /**
     * Change the character used to draw the object.
     * 
     * @param newCharacter the new character to draw the object with.
     */
    public void ChangeCharacter(char newCharacter);

    /** Draw the object to the screen. */
    public void Draw();
}
