/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import diet.Carnivore;
import food.EFoodType;
import graphics.ZooPanel;
import diet.IDiet;


/**
 * the utilities of this class is the creation of a new animal Lion. all function lion can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Gad Nadjar
 * @see animals.Animal
 **/
public class Lion extends Animal
{

    private final static IDiet diet = new Carnivore();
    private static int lionCount = 1;


    /**
     * @param size : size of the animal
     * @param horSpeed : horizontal speed of the animal
     * @param verSpeed : vertical speed of the animal
     * @param color : color of the animal
     * @param name  : name of the animal
     * @param pan  : panel of zoopanel
     */
    public Lion(String name, int size, int horSpeed, int verSpeed, String color, ZooPanel pan)
    {
        super(size, horSpeed, verSpeed, color, pan);
        this.setName(name + lionCount);
        this.setX(50);
        this.setY(0);
        this.loadImages("lio");
        this.setWeight(this.getSize() * 0.8);
        this.setDiet(diet);
        this.setPan(pan);
        lionCount++;
    }


    /**
     * number of lion in the zoo
     */
    public static void setLionCount() {lionCount = 1;}


    /**
     * @return EFoodType : return the type of food of the animal
     */
    @Override
    public EFoodType getFoodtype() {return EFoodType.NOTFOOD;}


    /**
     * @return String : representation of the lion
     */
    public String toString()
    {
        return "[!]" + this.getName() + " : " + "total distance :" + "[" + this.gettotalDistance() + "]" + ", weight : " + "[" + this.getWeight() + "]";
    }
}