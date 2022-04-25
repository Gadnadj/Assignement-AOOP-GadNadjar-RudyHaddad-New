package plants;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.ILocatable;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;

/**
 * this class blablabla
 */
public abstract class Plant implements IEdible, ILocatable, IDrawable
{
    private double height;
    private Point location;
    private double weight;

    private String col;

    private ZooPanel pan;

    private BufferedImage img = null;

    /**
     * contructor
     */
            public Plant(ZooPanel pan) {
                Random rand = new Random();
                this.height = 25;
                this.weight = 25;
                this.location = new Point((int) (pan.getWidth() / 2 - this.height / 2), (int) (pan.getHeight() / 2 - this.weight / 2 - 36));
                MessageUtility.logConstractor("Plant", "Plant");
                this.col = "Natural";
                this.pan = pan;
            }
            public Plant()
            {
                Random rand = new Random();
                int x = rand.nextInt(30);
                int y = rand.nextInt(12);
                this.location = new Point(x, y);
                this.height = rand.nextInt(30);
                this.weight = rand.nextInt(12);
                MessageUtility.logConstractor("Plant", "Plant");
            }

    /*
     * (non-Javadoc)
     *
     * @see food.IFood#getFoodtype()
     */
    @Override
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
        return EFoodType.VEGETABLE;
    }

    /**
     * @return double
     */
    public double getHeight() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
        return this.height;
    }

    /*
     * (non-Javadoc)
     *
     * @see mobility.ILocatable#getLocation()
     */
    @Override
    public Point getLocation() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
        return this.location;
    }

    /**
     * @return double
     */
    public double getWeight() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
        return weight;
    }

    /**
     * @param height : height of the plant
     *
     * @return boolean
     */
    public boolean setHeight(double height) {

        boolean isSuccess = (height >= 0);
        if (isSuccess) {
            this.height = height;
        } else {
            this.height = 0;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
        return isSuccess;
    }

    /*
     * (non-Javadoc)
     *
     * @see mobility.ILocatable#setLocation(mobility.Point)
     */
    @Override
    public boolean setLocation(Point newLocation)
    {
        boolean isSuccess = Point.checkBoundaries(newLocation);
        if (isSuccess == true)
        {
            this.location = newLocation;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
        return isSuccess;
    }

    /**
     * @param weight : weight of the plant
     *
     * @return boolean
     */
    public boolean setWeight(double weight) {
        boolean isSuccess = (weight >= 0);
        if (isSuccess) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);

        return isSuccess;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + "] ";
    }




    public void loadImages(String nm) {
        try { img = ImageIO.read(new File(nm)); }
        catch (IOException e) { System.out.println("Cannot load image");
            System.out.println(e.toString());}
    }

    public void drawObject (Graphics g)
    {
        g.drawImage(img, getLocation().getX(), getLocation().getY(), (int) this.height, (int) this.height,pan);
    }

    @Override
    public String getColor() {
        return null;
    }
}