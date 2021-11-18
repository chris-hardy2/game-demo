import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Child here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Child extends Actor
{
    private static int framesSinceGrounded = 0;
    private static int stalledFrames = 0;
    private static int timeAmount;
    private static int timeDuration;
    /**
     * Act - do whatever the Child wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = getX();
        int y = getY();
        int gravityFactor = 5 + (int) Math.pow(framesSinceGrounded, 1.12);
        
        y = y + gravityFactor;
        
        if (!isTouching(Platform.class)) {
            setLocation(x, y);
            framesSinceGrounded++;
        } else {
            framesSinceGrounded = 0;
        }
        
        if (timeAmount != 0) {
            if (timeDuration != 0) {
                setLocation(x, y - timeAmount);
                timeDuration--;
            }
        }
        
        if (Greenfoot.isKeyDown("d")) {
             setLocation(x + 2, y);   
        }
        
        if (Greenfoot.isKeyDown("a")) {
            setLocation(x - 2, y);
        }
        
        if (Greenfoot.isKeyDown("space") && isTouching(Platform.class)) {
           moveOverTime(15, 15);
        }
    }
    
    public void moveOverTime(int moveAmount, int moveDuration) {
        timeAmount = moveAmount;
        timeDuration = moveDuration;
    }
}
