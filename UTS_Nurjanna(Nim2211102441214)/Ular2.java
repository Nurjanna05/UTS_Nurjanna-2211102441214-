import greenfoot.*;  
import java.util.Random;
public class Ular2 extends Actor
{
    private boolean ai;
    static private boolean alive;
    private int direction = 0;
    private int length = 3;
    private static final int scale = 3;
    Random r = new Random();
    private Ular1 nextNode = null;
    private Ular1 temp;
    private boolean temp1 = false;
    public void act()
    {
        if(alive)
        {
            if(ai)
            {
                /*if(getOneObjectAtOffset((int)Math.cos(direction*90), (int)Math.sin(direction*90), Ular1.class)!=null)
                {
                    
                }
                else
                {
                    turnTowards(getOneObject(Food.class).getX(), getOneObject(Food.class).getY());
                }*/
            }
            else
            {
                if(Greenfoot.isKeyDown("right")&&direction!=2)direction = 0;
                else if(Greenfoot.isKeyDown("down")&&direction!=3)direction = 1;
                else if(Greenfoot.isKeyDown("left")&&direction!=0)direction = 2;
                else if(Greenfoot.isKeyDown("up")&&direction!=1)direction = 3;
            }
            setRotation(direction*90);
            nextNode = new Ular1(length-1, direction*90, nextNode);
            getWorld().addObject(nextNode, getX(), getY());
            move(1);
            if(getOneIntersectingObject(Food.class)!=null)foundFood();
            if(getOneIntersectingObject(Ular1.class)!=null||isAtEdge())death();
        }
        else
        {
            if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("right")){}
            else temp1 = true;
            if((Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("right"))&&temp1)Greenfoot.setWorld(new SnakeGame());
        }
    }
    private void foundFood()
    {
        length += scale;
        nextNode.increase();
        getWorld().removeObject(getOneIntersectingObject(Food.class));
        getWorld().addObject(new Food(), r.nextInt(SnakeGame.getMyWidth()), r.nextInt(SnakeGame.getMyHeight()));
    }
    public boolean isAtEdge()
    {
        if(getX()<0||getX()>= SnakeGame.getMyWidth()||getY()<0||getY()>=SnakeGame.getMyHeight())return true;
        return false;
    }
    public void death()
    {
        Skor skor = new Skor("Score: ");
        getWorld().addObject(skor, SnakeGame.getMyWidth() / 2, SnakeGame.getMyHeight() / 2);
        skor.setValue(length + 1);
        alive = false;
        //Greenfoot.stop();
    }
    public static int getScale()
    {
        return scale;
    }
    public static boolean getAlive(){
        return alive;
    }
    public Ular2()
    {
        ai = false;
        alive = true;
    }
    public Ular2(boolean aiControlled)
    {
        if(ai)ai = true;
        else ai = false;
        alive = true;
    }
}
