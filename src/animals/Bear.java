/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import diet.Carnivore;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;
import diet.IDiet;
import diet.Omnivore;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    private final static IDiet diet = new Omnivore();

    static int bearCount = 1;


    /**
     *  @param name : name of the animal
     */
    public Bear(String name) {
        super(name);
        this.setName(name);
        MessageUtility.logConstractor("Bear", name);
        this.setWeight(this.getSize() * 0.8);
        this.furColor = String.valueOf(setFurColor("gray"));
        this.setDiet(diet);
    }

    /**
     * @param name : name of the animal
     * @param size : size of the animal
     * @param horSpeed : horizontal speed of the animal
     * @param verSpeed : vertical speed of the animal
     * @param color : color of the animal
     * @param pan : panel of zoopanel
     */
    public Bear(String name, int size, int horSpeed, int verSpeed, String color, ZooPanel pan)
    {
        super(size, horSpeed, verSpeed, color, pan);
        this.setWeight(this.getSize() * 1.5);
        this.setName(name + bearCount);
        this.setX(100);
        this.setY(5);
        this.furColor = String.valueOf(setFurColor("gray"));
        this.loadImages("bea");
        this.setDiet(diet);
        this.setPan(pan);
        bearCount++;
    }


    /**
     * @param name : name of the animal
     *  @param furColor : color of the bear fur
     */
    public Bear(String name, String furColor) {
        super(name);
        MessageUtility.logSetter(this.getName(), "setName", name, true);
        MessageUtility.logConstractor("Bear", name);
        this.setWeight(308.2);
        setFurColor(furColor);
        this.setDiet(diet);
    }



    public static boolean setBearCount()
    {
        bearCount = 1;
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
     *the cry a bear makes after eating
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
