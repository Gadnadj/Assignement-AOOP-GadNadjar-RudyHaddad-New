/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import food.EFoodType;
import graphics.ZooPanel;
import diet.IDiet;
import diet.Omnivore;

/**
 * the utilities of this class is the creation a new animal bear. all function bear can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Gad Nadjar
 *
 **/
public class Bear extends Animal
{
    private final static IDiet diet = new Omnivore();
    static int bearCount = 1;


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
        this.loadImages("bea");
        this.setDiet(diet);
        this.setPan(pan);
        bearCount++;
    }


    /**
     * number of bear in the zoo
     */
    public static void setBearCount() {bearCount = 1;}


    /**
     *
     * @return EFoodType : return the type of food of the animal
     */
    @Override
    public EFoodType getFoodtype() {return EFoodType.MEAT;}


    /**
     * @return String : representation of bear
     */
    public String toString()
    {
        return "[!]" + this.getName() + " : " + "total distance :" + "[" + this.gettotalDistance() + "]" + ", weight : " + "[" + this.getWeight() + "]";
    }
}
