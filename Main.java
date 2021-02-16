import java.awt.Color;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args)
    {
        Tesselation t = new Tesselation (10,10);
        t.eraseRightToLeft();
        t = new Tesselation (10,10);
        t.animateRow(1);
         t.eraseRandom();
        t = new Tesselation (10,10);
        t.setDiagonal(Color.gray, Color.pink);
        t.changeColorInRow(Color.red);
        t.setRandomColor();
       

        //Tile b = new Tile(100,100);   
        //b.changeColor(Color.blue);
        //b.erase();

    }
}
