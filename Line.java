import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael lling and David J. Barnes
 * @version 2019.09.18 - Updated by Galesi / Tan
 */

public class Line
{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;
    private boolean isVisible;

    /**
     * Create a new line.
     * 
     * @param x1 the first x coordinate of the end point of the line.
     * @param y1 the first y coordinate of the end point of the line.
     * @param x2 the second x coordinate of the end point of the line.
     * @param y2 the second y coordinate of the end point of the line.
     * 
     */
    public Line(int x1, int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.makeVisible();
        color = Color.black;
        draw();
    }

    public int getX1()
    {
        return x1;
    }

    public int getY1()
    {
        return y1;
    }
    
    public int getX2()
    {
        return x2;
    }

    public int getY2()
    {
        return y2;
    }


    /**
     * Make this line visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Make this line invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * Move the line 20 pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the line 20 pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the line 20 pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the line 20 pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the line horizontally by 'distance' pixels.
     * 
     * @param distance the distance in pixels you want the object moved horizontally.
     * 
     */
    public void moveHorizontal(int distance)
    {
        erase();
        x1 += distance;
        x2 += distance;
        
        draw();
    }

    /**
     * Move the line vertically by 'distance' pixels.
     * 
     * @param distance the distance in pixels you want the object moved vertically. Remember negative is up!
     * 
     */
    public void moveVertical(int distance)
    {
        erase();
        y1 += distance;
        y2 += distance;
        draw();
    }



    /**
     * Change the color. 
     * 
     * @param newColor the new color.
     * 
     */
    public void changeColor(Color newColor)
    {
        this.color = newColor;
        draw();
    }

    /**
     * Draw the line with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            Line2D.Double line = new Line2D.Double((double) x1, (double) y1, 
            (double) x2, (double) y2);
            canvas.draw(this, color, line);
            canvas.wait(5);
        }
    }

    /**
     * Erase the line on screen.
     */
    public void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
