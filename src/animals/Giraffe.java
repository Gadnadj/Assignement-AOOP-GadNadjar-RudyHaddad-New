/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import diet.IDiet;
import food.EFoodType;
import graphics.ZooPanel;
import diet.Herbivore;

/**
 * the utilities of this class is the creation of a new animal Giraffe. all function bear can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Rudy Haddad
 * @see animals.Animal
 *
 **/
public class Giraffe extends Animal
{
    private final static IDiet diet = new Herbivore();
    static int giraffeCount = 1;


    /**
     * @param size : size of the animal
     * @param horSpeed : horizontal speed of the animal
     * @param verSpeed : vertical speed of the animal
     * @param color : color of the animal
     * @param name : name of the animal
     * @param pan : panel
     */
    public Giraffe(String name, int size, int horSpeed, int verSpeed, String color, ZooPanel pan)
    {
        super(size, horSpeed, verSpeed, color, pan);
        this.setWeight(this.getSize() * 2.2);
        this.setName(name + giraffeCount);
        this.setX(50);
        this.setY(0);
        this.loadImages("grf");
        this.setDiet(diet);
        this.setPan(pan);
        giraffeCount++;
    }


    /**
     * number of giraffe in the zoo
     */
    public static void setGiraffeCount() {giraffeCount = 1;}


    /**
     * @return EFoodType : return the type of food of the animal
     */
    @Override
    public EFoodType getFoodtype() {return EFoodType.MEAT;}


    /**
     * @return String : representation of giraffe
     */
    public String toString()
    {
        return "[!]" + this.getName() + " : " + "total distance :" + "[" + this.gettotalDistance() + "]" + ", weight : " + "[" + this.getWeight() + "]";
    }
}