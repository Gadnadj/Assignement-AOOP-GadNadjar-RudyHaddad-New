/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import diet.IDiet;
import diet.Omnivore;
import food.EFoodType;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;
import diet.Herbivore;


/**
 * the utilities of this class is the creation of a new animal Giraffe. all function bear can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Rudy Haddad
 * @see animals.Animal
 *
 **/
public class Giraffe extends Chew
{
    private double neckLength;
    private static final Point location = new Point(50,0);
    private final static IDiet diet = new Herbivore();

    /**
     * the utilities of this class is the creation new animal Giraffe. all function giraffe can be use is here or
     * from supers classes.
     * @version 26.03.2022
     * @author Rudy Haddad
     * @see animals.Animal
     *
     **/


    /**
     *  @param name : name of the animal
     */
    public Giraffe(String name)
    {
        super(name, location);
        this.setName(name);
        MessageUtility.logConstractor("Elephant", name);
        this.setWeight(450);
        setNeckLength(1.5);
        this.setDiet(diet);

    }


    /**
     *  @param name : name of the animal
     *  @param neckLength : length of the giraffe neck
     */
    public Giraffe(String name, double neckLength)

    {
        super(name, location);
        MessageUtility.logSetter(this.getName(), "setName", name, true);
        MessageUtility.logConstractor("Giraffe", name);
        this.neckLength = neckLength;
        this.setWeight(450);
        if(neckLength < 1 || neckLength >2.5)
        {
            MessageUtility.logSetter(this.getName(),"setNeckLength", neckLength, false);
            this.neckLength = 1.5;
            MessageUtility.logSetter(this.getName(),"setNeckLength", this.neckLength, true);

        }
        else
        {
            this.neckLength = neckLength;
            MessageUtility.logSetter(this.getName(),"setNeckLength", neckLength, true);
        }
        this.setDiet(diet);

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
     * @param neckLength : length of the giraffe neck
     *
     * @return true if the placement worked
     */
    public boolean setNeckLength(double neckLength)
    {
        if(neckLength < 1 || neckLength >2.5)
        {
            this.neckLength = 1.5;
            MessageUtility.logSetter(this.getName(),"setNeckLength", neckLength, false);
            return false;
        }
        else
        {
            this.neckLength = neckLength;
            MessageUtility.logSetter(this.getName(),"setNeckLength", neckLength, true);
            return true;
        }


    }


    /**
     *
     */
    public void chew()
    {
        System.out.println("Bleats and Stomps its legs, then chews");
    }



    /**
     *
     * @return EFoodType : return the type of food of the animal
     */
    @Override
    public EFoodType getFoodtype()
    {
        MessageUtility.logGetter(this.getName(), "getFoodType", EFoodType.MEAT);

        return EFoodType.MEAT;
    }



    /**
     *  @param obj : edibility of animal
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