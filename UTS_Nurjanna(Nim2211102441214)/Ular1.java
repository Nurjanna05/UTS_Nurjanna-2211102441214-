import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ular1 extends Actor
{
    private int length;
    private Ular1 nextNode;
    public void act() 
    {
        if(0==length--&&Ular2.getAlive())getWorld().removeObject(this);
    }
    public Ular1(int pLength, int rotation, Ular1 next)
    {
        length = pLength;
        setRotation(rotation);
        nextNode = next;
    }
    public void increase()
    {
        length += Ular2.getScale();
        if(nextNode!=null)nextNode.increase();
    }
}
