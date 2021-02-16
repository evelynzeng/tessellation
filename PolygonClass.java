import java.awt.*;

/**
 * A polygon that can be manipulated and that draws itself on a canvas.
 * 
 * @version 2020.02.05 - Updated by Galesi / Tan
 */

public class PolygonClass
{
    boolean isVisible;
    int[][] points;
    int[] xValues;
    int[] yValues;
    int numSides;
    Color color;

    /**
     * Create a new polygon at a specified position.
     * 
     * @param points a 2D array of x and y values for each point on the polygon. 
     * For example, {{x1, y1}, {x2, y2}, {x3, y3}}
     * 
     * @param color a java.awt.Color value for the polygon.
     * 
     */
    public PolygonClass(int[][] points, Color color)
    {
        this.xValues = new int[points.length];
        this.yValues = new int[points.length];
        for (int i = 0; i < points.length; i++)
        {
            xValues[i] = points[i][0];
            yValues[i] = points[i][1];
        }
        this.numSides = xValues.length;
        this.color = color;
        isVisible = true;
        this.draw();
    }

    /**
     * Make this polygon visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Make this polygon invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * Move the polygon 20 pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the polygon 20 pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the polygon 20 pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the polygon 20 pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the polygon horizontally by 'distance' pixels.
     * 
     * @param distance the distance translated, in pixels.
     * 
     */
    public void moveHorizontal(int distance)
    {
        erase();
        for (int i = 0; i < xValues.length; i++)
        {
            xValues[i] += distance;
        }
        draw();
    }

    /**
     * Move the polygon vertically by 'distance' pixels.
     * 
     * @param distance the distance translated, in pixels.
     * 
     */
    public void moveVertical(int distance)
    {

        for (int i = 0; i < yValues.length; i++)
        {
            erase();
            yValues[i] += distance;
        }

        draw();
    }

    /**
     * Slowly move the polygon horizontally by 'distance' pixels.
     * 
     * @param distance the distance translated, in pixels.
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
            for (int j = 0; j < xValues.length; j++)
            {
                xValues[j] += delta;
            }
            draw();
        }
    }

    /**
     * Slowly move the polygon vertically by 'distance' pixels.
     * 
     * @param distance the distance translated, in pixels.
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
            for (int j = 0; j < yValues.length; j++)
            {
                yValues[j] += delta;
            }
            draw();
        }
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     * 
     * @param newColor the new color of the ellipse. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     * 
     */
    public void changeColor(Color newColor)
    {
        color = newColor;
        draw();
    }


    /**
     * Draw the polygon with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Polygon(xValues, yValues, numSides));
            
        }
    }

    /**
     * Erase the polygon on screen.
     */
    public void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}