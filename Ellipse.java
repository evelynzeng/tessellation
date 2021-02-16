import java.awt.*;
import java.awt.geom.*;


/**
 * An ellipse that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kšlling and David J. Barnes
 * @version 2019.09.18 - Updated by Galesi / Tan
 */

public class Ellipse
{
    private int height, width;
    private int xPosition;
    private int yPosition;
    private Color color;
    private boolean isVisible;

    /**
     * Create a new ellipse.
     * 
     * @param centerX the x coordinate of the center of the ellipse.
     * @param centerY the y coordinate of the center of the ellipse.
     * @param width the width of the ellipse in pixels.
     * @param height the height of the ellipse in pixels.
     * @param color the color of the ellipse. 
     * 
     */
    public Ellipse(int centerX, int centerY, int width, int height, Color color)
    {
        this.width = width;
        this.height = height;
        this.xPosition = centerX - width / 2;
        this.yPosition = centerY - height / 2;
        this.color = color;
        this.makeVisible();
    }

    /**
     * Make this ellipse visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Make this ellipse invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * Move the ellipse 20 pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the ellipse 20 pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the ellipse 20 pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the ellipse 20 pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the ellipse horizontally by 'distance' pixels.
     * 
     * @param distance the distance in pixels to move.
     * 
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the ellipse vertically by 'distance' pixels.
     * 
     * @param distance the distance in pixels to move.
     * 
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the circle horizontally by 'distance' pixels.
     * 
     * @param distance the distance in pixels to slowly move.
     * 
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the circle vertically by 'distance' pixels.
     * 
     * @param distance the distance in pixels to slowly move.
     * 
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     * 
     * @param newWidth the new width of the ellipse.
     * 
     */
    public void changeWidth(int newWidth)
    {
        erase();
        width = newWidth;
        draw();
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     * 
     * @param newHeight the new height of the ellipse.
     * 
     */
    public void changeHeight(int newHeight)
    {
        erase();
        height = newHeight;
        draw();
    }

    /**
     * Change the color. 
     * 
     * @param newColor the new java.awt.Color.
     * 
     */
    public void changeColor(Color newColor)
    {
        color = newColor;
        draw();
    }

    /**
     * Draw the ellipse with current specifications on screen.
     */
    public void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Ellipse2D.Double(xPosition, yPosition, 
                    width, height));
            canvas.wait(10);
        }
    }

    /**
     * Erase the ellipse on screen.
     */
    public void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }

    public Shape rotate(double angle)
    {
        Ellipse2D.Double x = new Ellipse2D.Double(2 * xPosition, yPosition, 
                width, height);
        return AffineTransform.getRotateInstance(angle)
        .createTransformedShape(x);

    }

    /**
     * Draw the ellipse with current specifications on screen.
     */
    public void drawRotated(Shape s)
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, s);

            canvas.wait(10);
        }
    }
}

