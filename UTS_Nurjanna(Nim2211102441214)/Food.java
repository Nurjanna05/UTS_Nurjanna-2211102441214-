import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
public class Food extends Actor
{
    Random r = new Random();
    public void act()
    {
        while(getOneIntersectingObject(Ular1.class)!=null)setLocation(r.nextInt(SnakeGame.getMyWidth()), r.nextInt(SnakeGame.getMyHeight()));
    }
}
