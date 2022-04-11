/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Mobile;
import food.IEdible;
import diet.IDiet;
import mobility.Point;
import food.EFoodType;
import utilities.MessageUtility;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * the usefulness of this class is to create instances of animals that will belong to the zoo,
 * the class will allow them to perform actions on different breeds of animals such as moving them, feeding them etc...
 * @version 26.03.2022
 * @author Rudy Haddad
 * @see mobility.Mobile
 *
 */
public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior {
    private String name;
    private double weight;
    private IDiet diet;


    private final int EAT_DISTANCE = 5;
    private int size;
    private Color col;
    private int horSpeed;
    private int verSpeed;
    private boolean coordChanged;
    private Thread thread;
    private int x_dir;
    private int y_dir;
    private int eatCount;
    private ZooPanel pan;
    private BufferedImage img1, img2;



    /**
     *
     * @param name : name of the animal
     * @param location : location of the animal
     */
    public Animal(String name, Point location) {
        super(location);
        MessageUtility.logConstractor("Animal", name);
        this.name = name;
    }

   public Animal(Point location, int size, int horSpeed, int verSpeed, Color color)
   {
       super(location);
       this.horSpeed = horSpeed;
       this.verSpeed = verSpeed;
       this.col = color;
   }


    /**
     *
     * @return EFoodType
     */
    public abstract EFoodType getFoodtype();


    /**
     *
     * @param edible : edible
     *
     * @return boolean
     */
    public abstract boolean eat(IEdible edible);

    /**
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @param Name : name of the animal
     * @return boolean
     */
    public boolean setName(String Name) {
        this.name = Name;
        MessageUtility.logSetter(this.getName(), "setName", name, true);

        return true;
    }

    /**
     *
     * @param diet : diet
     * @return boolean
     */
    public boolean setDiet(IDiet diet) {
        this.diet = diet;
        MessageUtility.logSetter(this.name, "setDiet", diet, true);
        return true;
    }


    /**
     *
     * @return IDiet
     */
    public IDiet getDiet() {
        return this.diet;
    }


    /**
     *
     * @return double
     */
    public double getWeight() {
        MessageUtility.logGetter(this.getName(), "getWeight", this.weight);
        return this.weight;
    }


    /**
     *
     * @param weight : weight of the animal
     * @return boolean
     */
    public boolean setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
            MessageUtility.logSetter(this.name, "setWeight", this.weight, true);
            return true;

        } else {
            return false;
        }

    }

    /**
     *
     */
    public abstract void makeSound();

    /**
     *
     * @param point : coordinate
     * @return double
     */
    public double move(Point point)
    {
        double temp = super.move(point);
        this.setWeight(this.weight - (temp * this.weight * 0.00025));
        return temp;
    }


    @Override
    public String getAnimalName() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void eatInc() {

    }

    @Override
    public int getEatCount() {
        return 0;
    }

    @Override
    public boolean getChanges() {
        return false;
    }

    @Override
    public void setChanges(boolean state) {

    }

    @Override
    public void loadImages(String nm) {

    }

    @Override
    public void drawObject(Graphics g) {

    }

    @Override
    public String getColor() {
        return null;
    }



}