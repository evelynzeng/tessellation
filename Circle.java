import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael lling and David J. Barnes
 * @version 2019.09.18 - Updated by Galesi / Tan
 */

public class Circle
{
    private int diameter,radius;
    private int xPosition;
    private int yPosition;
    private int centerX,centerY;
    private Color color;
    private boolean isVisible;

    /**
     * Create a new circle.
     * 
     * @param centerX the x coordinate of the center of the circle.
     * @param centerY the y coordinate of the center of the circle.
     * @param radius the radius of the circle.
     * 
     */
    public Circle(int centerX, int centerY, int radius)
    {
        this.diameter = 2 * radius;
        this.xPosition = centerX - radius;
        this.yPosition = centerY - radius;
        this.centerX = centerX;
        this.centerY = centerY;
        this.isVisible = true;
        this.radius = radius;
        this.makeVisible();
        color = Color.black;
        draw();
    }

    /** 
     * @param centerX the x coordinate of the center of the circle.
     * @param centerY the y coordinate of the center of the circle.
     * 
     */
    public void setCenter(int x, int y)
    {
        this.xPosition = x - radius;
        this.yPosition = y - radius;
        this.centerX = x;
        this.centerY = y;
        draw();
    }

    /**
     * Gets the current radius of the circle
     */
    public int getRadius()
    {
        return radius;
    }

    /**
     * @param radius the new radius of the circle.
     * 
     */
    public void setRadius(int r)
    {
        radius = r;
        xPosition = centerX - radius;
        yPosition = centerY - radius;
        diameter = 2 * radius;
        draw();
    }

    /**
     * Gets the current x value for the center of the circle
     */
    public int getCenterX()
    {
        return centerX;
    }

    /**
     * Gets the current y value for the center of the circle
     */
    public int getCenterY()
    {
        return centerY;
    }

    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Make this circle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * Move the circle 20 pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the circle 20 pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the circle 20 pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the circle 20 pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the circle horizontally by 'distance' pixels.
     * 
     * @param distance the distance in pixels you want the object moved horizontally.
     * 
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        centerX += distance;
        draw();
    }

    /**
     * Move the circle vertically by 'distance' pixels.
     * 
     * @param distance the distance in pixels you want the object moved vertically. Remember negative is up!
     * 
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        centerY += distance;
        draw();
    }

    /**
     * Slowly move the circle horizontally by 'distance' pixels.
     * 
     * @param distance the distance in pixels you want the object moved horizontally.
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
     * @param distance the distance in pixels you want the object moved vertically. Remember negative is up!
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
     * Change the color. 
     * 
     * @param newColor the new java.awt.Color.
     * 
     */
    public void changeColor(Color newColor)
    {
        this.color = newColor;
        draw();
    }

    /**
     * Draw the circle with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Ellipse2D.Double(xPosition, yPosition, 
                    diameter, diameter));
            canvas.wait(10);
        }
    }

    /**
     * Erase the circle on screen.
     */
    public void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
