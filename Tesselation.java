import java.awt.*;
/**
 * Write a description of class Tesselation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tesselation
{
    // instance variables - replace the example below with your own
    private int row;
    private int col;
    private Tile[][] tile;


    /**
     * Constructor for objects of class Tesselation
     */
    public Tesselation(int r, int c)
    {
        // initialise instance variables
        row =r;
        col =c;
        tile = new Tile [row][col];
        

        for (int i =0; i<tile.length; i++)
        {
            for (int j = 0; j<tile[0].length; j++)
            {
                tile[i][j] = new Tile(-20 + i*80, -20 + j*80);
            }
        }

    }

    public void changeColorInRow(Color c)
    {

        for (int i =0; i<tile.length; i++)
        {
            for (int j = 0; j<tile[0].length; j++)
            {
                tile[j][i].changeColor(c);

                tile[j][i].draw();
            }
        }
    }

    public void setRandomColor()
    {
        for (int i =0; i<tile.length; i++)
        {
            for (int j = 0; j<tile[0].length; j++)
            {
                tile[j][i].changeColor(new Color ((int) (Math.random() * 255),(int) (Math.random() * 255), (int) (Math.random() * 255)) );

                tile[j][i].draw();
            }
        }
    }

    public void setDiagonal(Color e, Color z)
    {
        for (int i =0; i<tile.length; i++)
        {
            for (int j = 0; j<tile[0].length; j++)
            {
                if ((i+j)%2 == 0)
                {
                    tile[j][i].changeColor(e);
                }
                else 
                {
                    tile[j][i].changeColor(z);
                }
            }
        }

    }
    public void eraseRightToLeft()
    {
        for (int j = tile[0].length -1; j >=0; j--)
        {
            for (int i = tile.length -1; i>= 0; i--)
            {
                tile[j][i].erase();
                tile[j][i] = null;
            }
        }
    }

    public void eraseRandom()
    {
        int counter =0;
        while (counter<tile.length*tile[0].length)
        {
            int row = (int) (Math.random()*tile.length);
            int col = (int) (Math.random()*tile[0].length);
            if (tile[row][col] !=null)
            {
                tile[row][col].erase();
                counter++;
                tile[row][col]=null;
            }
            
        }
        
    }
    
    public void animateRow(int rowNum)
    {
        int counter = 0;
        while (counter<tile[rowNum].length)
        {
            for (int col=0; col<tile[rowNum].length; col++)
            {
                tile[col][rowNum].animate();
                counter++;
            }
        }
    }


}
