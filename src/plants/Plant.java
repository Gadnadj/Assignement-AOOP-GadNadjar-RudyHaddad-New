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
import javax.imageio.ImageIO;

/**
 * this class creates instance of plant
 */
public abstract class Plant implements IEdible, ILocatable, IDrawable {
    private double height;
    private Point location;
    private double weight;
    private String col;
    private ZooPanel pan;
    private BufferedImage img = null;

    /**
     * Constructor of plant
     *
     * @param pan : panel of zoopanel
     */
    public Plant(ZooPanel pan) {
        this.height = 25;
        this.weight = 25;
        this.location = new Point((int) (pan.getWidth() / 2 - this.height / 2), (int) (pan.getHeight() / 2 - this.weight / 2));
        this.col = "Natural";
        this.pan = pan;
    }


    /**
     * Constructor of plant
     */
    public Plant() {
        Random rand = new Random();
        int x = rand.nextInt(30);
        int y = rand.nextInt(12);
        this.location = new Point(x, y);
        this.height = rand.nextInt(30);
        this.weight = rand.nextInt(12);
    }


    /**
     * @return EFoodType : type of food
     */
    @Override
    public EFoodType getFoodtype() {
        return EFoodType.VEGETABLE;
    }


    /**
     * @return double : weight of the plant
     */
    public double getHeight() {
        return this.height;
    }


    /**
     * @return point : location
     */
    @Override
    public Point getLocation() {
        return this.location;
    }


    /**
     * @return double : weight of the plant
     */
    public double getWeight() {
        return weight;
    }


    /**
     * @param height : height of the plant
     * @return boolean
     */
    public boolean setHeight(double height) {
        boolean isSuccess = (height >= 0);
        if (isSuccess)
            this.height = height;
        else
            this.height = 0;
        return isSuccess;
    }


    /**
     * @param newLocation : the new point of the animal
     * @return boolean
     */
    @Override
    public boolean setLocation(Point newLocation) {
        boolean isSuccess = Point.checkBoundaries(newLocation);
        if (isSuccess)
            this.location = newLocation;
        return isSuccess;
    }


    /**
     * @param weight : weight of the plant
     * @return boolean
     */
    public boolean setWeight(double weight) {
        boolean isSuccess = (weight >= 0);
        if (isSuccess)
            this.weight = weight;
        else
            this.weight = 0;
        return isSuccess;
    }


    /**
     * @return String : representation of Plant
     */
    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + "] ";
    }


    /**
     * @param nm : string of the image
     */
    public void loadImages(String nm) {
        try {
            img = ImageIO.read(new File(nm));
        } catch (IOException e) {
            System.out.println("Cannot load image");
            System.out.println(e.toString());
        }
    }

    /**
     * @param g : graphics
     */
    public void drawObject(Graphics g) {g.drawImage(img, getLocation().getX(), getLocation().getY(), (int) this.height, (int) this.height, pan);}


    /**
     * @return String : color of the plant
     */
    @Override
    public String getColor(){return null;}
}