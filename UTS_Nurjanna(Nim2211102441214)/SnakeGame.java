import greenfoot.*;  
import java.util.Random;
public class SnakeGame extends World
{
    private static final int width = 40;
    private static final int height = 25;
    public SnakeGame()
    {    
        super(40, 25, 20, false);
        Greenfoot.setSpeed(38);
        prepare();
        setPaintOrder(Skor.class, Ular2.class, Ular1.class, Food.class);
    }
    public static int getMyWidth()
    {
        return width;
    }
    public static int getMyHeight()
    {
        return height;
    }

    Random r = new Random();
    private void prepare()
    {
        Ular2 ular2 = new Ular2();
        addObject(ular2,getMyHeight()/2,getMyHeight()/2);
        addObject(new Food(), r.nextInt(getMyHeight()), r.nextInt(getMyHeight()));
    }
}
