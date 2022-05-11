/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import diet.IDiet;
import diet.Omnivore;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;
import diet.Herbivore;

import java.awt.*;

/**
 * the utilities of this class is the creation of a new animal turtle. all function turtle can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Rudy Haddad
 * @see animals.Animal
 *
 **/
public class Turtle extends Chew {
    private int age;
    private final static IDiet diet = new Herbivore();

    static int turtleCount = 1;


    /**
     * @param name : name of the animal
     */
    public Turtle(String name) {
        super(name);
        this.setName(name);
        MessageUtility.logConstractor("Turtle", name);
        this.setWeight(1);
        setAge(1);
        this.setDiet(diet);
    }

    /**
     * @param size     : size of the animal
     * @param horSpeed : horizontal speed of the animal
     * @param verSpeed : vertical speed of the animal
     * @param color    : color of the animal
     */
    public Turtle(String name, int size, int horSpeed, int verSpeed, String color, ZooPanel pan) {
        super(size, horSpeed, verSpeed, color, pan);
        this.setWeight(this.getSize() * 0.5);
        this.setName(name + turtleCount);
        this.setX(80);
        this.setY(0);
        this.loadImages("trt");
        setAge(1);
        this.setDiet(diet);
        turtleCount++;
    }


    /**
     * @param name : name of the animal
     * @param age  : age of the turtle
     */
    public Turtle(String name, int age) {
        super(name);
        MessageUtility.logSetter(this.getName(), "setName", name, true);
        MessageUtility.logConstractor("Turtle", name);
        this.setWeight(1);
        if (age < 0 || age > 500) {
            MessageUtility.logSetter(this.getName(), "setAge", age, false);
            this.age = 1;
            MessageUtility.logSetter(this.getName(), "setAge", this.age, true);

        } else {
            this.age = age;
            MessageUtility.logSetter(this.getName(), "setAge", age, true);
        }
        this.setDiet(diet);
    }


    public static boolean setTurtleCount()
    {
        turtleCount = 1;
        return true;
    }

    /**
     * @return String :
     */
    public String toString() {
        return "[!]" + this.getName() + " : " + "total distance :" + "[" + this.gettotalDistance() + "]" + ", weight : " + "[" + this.getWeight() + "]";
    }


    /**
     * @param age : age of the aninal
     * @return boolean : true if the placement worked
     */
    public boolean setAge(int age) {
        if (age < 0 || age > 500) {
            this.age = 1;
            MessageUtility.logSetter(this.getName(), "setAge", age, false);
            return false;
        } else {
            this.age = age;
            MessageUtility.logSetter(this.getName(), "setAge", age, true);
            return true;
        }
    }


    /**
     *
     */
    public void chew() {
        System.out.println("Retracts its head in then eats quietly");
    }

    /**
     * @return EFoodType : return the type of food of the animal
     */
    @Override
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getName(), "getFoodType", EFoodType.MEAT);

        return EFoodType.MEAT;
    }


    /**
     * @param obj : edibility of animal
     * @return boolean : true if the object is edible
     */
    @Override
    public boolean eat(IEdible obj) {
        {
            if (!this.getDiet().canEat(obj.getFoodtype())) {
                MessageUtility.logBooleanFunction(this.getName(), "eat", obj, false);
                return false;
            } else {
                MessageUtility.logBooleanFunction(this.getName(), "eat", obj, true);
                this.setWeight(getWeight() + this.getDiet().eat(this, obj));
                super.makeSound();
                return true;
            }
        }
    }


}