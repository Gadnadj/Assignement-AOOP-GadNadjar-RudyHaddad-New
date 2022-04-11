/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import diet.Carnivore;
import food.EFoodType;
import food.IEdible;
import mobility.Point;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import utilities.MessageUtility;
import diet.IDiet;


/**
 * the utilities of this class is the creation of a new animal Lion. all function lion can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Gad Nadjar
 * @see animals.Animal
 *
 **/
public class Lion extends Roar{

    private int scarCount;
    private static Point location = new Point(20,0);
    private final static IDiet diet = new Carnivore();


    /**
     * @param name : name of the animal
     *
     */
    public Lion(String name)
    {
        super(name, location);
        this.setName(name);
        MessageUtility.logConstractor("Lion", name);
        this.scarCount = 0;
        this.setWeight(408.2);
        this.setDiet(diet);
    }

    public Lion(int size, int horSpeed, int verSpeed, Color color)
    {
        super(location, size, horSpeed, verSpeed, color);
    }

    /**
     *
     * @return String
     */
    public String toString()
    {
        return "[!]" + this.getName() + " : " + "total distance :" + "[" + this.gettotalDistance() + "]" + ", weight : " + "[" + this.getWeight() + "]";
    }



    /**
     *
     * @return int : number of scars of the lion
     */
    public int getscarCount(){return scarCount;}


    /** @param scarCount : 0 or 1
     *  @return boolean : true if the placement worked
     */
    public boolean setScarCount(int scarCount)
    {
        this.scarCount = scarCount;
        return true;
    }


    /**
     *
     * @return EFoodType : return the type of food of the animal
     */
    @Override
    public EFoodType getFoodtype()
    {
        MessageUtility.logGetter(this.getName(), "getFoodType", EFoodType.NOTFOOD);
        return EFoodType.NOTFOOD;
    }


    /**
     * @param obj : edibility of animal
     *
     * @return boolean : true if the object is edible
     */
    @Override
    public boolean eat(IEdible obj)
    {
        if (!this.getDiet().canEat(obj.getFoodtype()))
        {
            MessageUtility.logBooleanFunction(this.getName(), "eat", obj, false);
            return false;
        }
        else
        {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            int temp = getscarCount() + randomNum;
            setScarCount(temp);
            MessageUtility.logBooleanFunction(this.getName(), "eat", obj, true);
            // probleme double impression de getWeight a check une fois finis !!!!!!!!!!
            this.setWeight(getWeight() + this.getDiet().eat(this, obj));
            super.makeSound();
            return true;
        }
    }





}