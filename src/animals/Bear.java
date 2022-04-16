/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import diet.Carnivore;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;
import diet.IDiet;
import diet.Omnivore;

import java.awt.*;
import java.util.Objects;


/**
 * the utilities of this class is the creation a new animal bear. all function bear can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Gad Nadjar
 *
 **/
public class Bear extends Roar {
    private String furColor;
    private static final Point location = new Point(100, 5);
    private final static IDiet diet = new Omnivore();


    /**
     *  @param name : name of the animal
     */
    public Bear(String name) {
        super(name, location);
        this.setName(name);
        MessageUtility.logConstractor("Bear", name);
        this.setWeight(308.2);
        this.furColor = String.valueOf(setFurColor("gray"));
        this.setDiet(diet);
    }

    /**
     *
     * @param size : size of the animal
     * @param horSpeed : horizontal speed of the animal
     * @param verSpeed : vertical speed of the animal
     * @param color : color of the animal
     */
    public Bear(int size, int horSpeed, int verSpeed, String color)
    {
        super(location, size, horSpeed, verSpeed, color);
        this.setWeight(308.2);
        this.furColor = String.valueOf(setFurColor("gray"));
        this.setDiet(diet);
    }


    /**
     * @param name : name of the animal
     *  @param furColor : color of the bear fur
     */
    public Bear(String name, String furColor) {
        super(name, location);
        MessageUtility.logSetter(this.getName(), "setName", name, true);
        MessageUtility.logConstractor("Bear", name);
        this.setWeight(308.2);
        setFurColor(furColor);
        this.setDiet(diet);
    }

    /**
     *
     * @param x : coordinate x
     * @return boolean
     */
    public boolean settX(int x)
    {
        this.location.setX(x);
        return true;
    }

    /**
     *
     * @param y : coordinate y
     * @return boolean
     */
    public boolean settY(int y)
    {
        this.location.setY(y);
        return true;
    }

    /**
     *
     * @return String :
     */
    public String toString()
    {
        return "[!]" + this.getName() + " : " + "total distance :" + "[" + this.gettotalDistance() + "]" + ", weight : " + "[" + this.getWeight() + "]";
    }


    /**
     * @param furColor : color of the bear fur
     *
     * @return true if the placement worked
     */
    public boolean setFurColor(String furColor) {
        if (!Objects.equals(furColor, "gray") && !Objects.equals(furColor, "white") && !Objects.equals(furColor, "BLACK")) {
            MessageUtility.logSetter(this.getName(), "setFurColor", furColor, false);
            this.furColor = "gray";
            MessageUtility.logSetter(this.getName(), "setFurColor", this.furColor, true);

            return false;
        }
        else
        {
            this.furColor = furColor;
            MessageUtility.logSetter(this.getName(), "setFurColor", furColor, true);
            return true;
        }
    }


    /**
     *
     * @return String : color of the bear fur
     */
    public String getfurColor() {
        return this.furColor;
    }


    /**
     *
     */
    public void roar() {
        System.out.println("on its hind legs, roars and scratches its belly");
    }



    /**
     *
     * @return EFoodType : return the type of food of the animal
     */
    @Override
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getName(), "getFoodType", EFoodType.MEAT);
        return EFoodType.MEAT;
    }


    /**
     * @param obj : edibility of animal
     *
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
