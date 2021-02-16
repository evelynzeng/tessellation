import java.awt.Color;
/**
 * Write a description of class Tile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tile
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private Color color;
    private PolygonClass outline;
    private Circle eye;
    private PolygonClass beak;
    private Color beakColor;

    /**
     * Constructor for objects of class Tile
     */
    public Tile(int x, int y)
    {
        // initialise instance variables
        color = Color.yellow;
        beakColor = Color.orange;
        this.x=x;
        this.y=y;
        draw();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void draw()
    {
        int[][] bodyPts = {{x, y},{x+30, y+20},{x+10, y+40},{x+20, y+50},
                {x, y+60}, {x, y+80}, {x+20,y+64}, {x+40, y+60}, {x+60, y+61}, {x+80, y+80}, {x+80,y+60},
                {x+100, y+50}, {x+90, y+40}, {x+110, y+20},{x+80, y},{x+60, y-19} ,
                {x+40, y-20},{x+20,y-17} };

        outline = new PolygonClass(bodyPts, color);
        eye = new Circle(x+50, y+10, 7);
        int[][] beakPts = {{x+80, y}, {x+70, y+20}, {x+65, y+30}, {x+70, y+40}, {x+80, y+60},
                {x+80,y+60},{x+100, y+50}, {x+90, y+40}, {x+110, y+20},{x+80, y}};
        beak = new PolygonClass(beakPts, beakColor);

    }

    public void changeColor(Color a)
    {
        outline.changeColor(a);
        color = a;
        draw();
    }

    public void erase()
    {
        eye.makeInvisible();
        beak.makeInvisible();
        outline.makeInvisible();
    }

    public void animate()
    {
        eye.makeInvisible(); 
        eye.changeColor(Color.red);
        Canvas.wait(300);
        eye.makeVisible();
      
    }

}
