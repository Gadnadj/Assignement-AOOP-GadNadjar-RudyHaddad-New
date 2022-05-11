/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import diet.IDiet;
import food.EFoodType;
import graphics.ZooPanel;
import diet.Herbivore;

/**
 * the utilities of this class is the creation new animal elephant. all function elephant can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Rudy Haddad
 * @see animals.Animal
 **/
public class Elephant extends Animal
{
    private double trunkLength;
    private final static IDiet diet = new Herbivore();
    static int elephantCount = 1;



    /**
     * @param size     : size of the animal
     * @param horSpeed : horizontal speed of the animal
     * @param verSpeed : vertical speed of the animal
     * @param color    : color of the animal
     * @param name     : name of the animal
     * @param pan      : panel of zoopanel
     */
    public Elephant(String name, int size, int horSpeed, int verSpeed, String color, ZooPanel pan)
    {
        super(size, horSpeed, verSpeed, color, pan);
        this.setWeight(this.getSize() * 10);
        this.setName(name + elephantCount);
        this.setX(50);
        this.setY(90);
        this.loadImages("elf");
        this.setDiet(diet);
        this.setPan(pan);
        elephantCount++;
    }


    /**
     * number of elephant in the zoo
     */
    public static void setElephantCount() {elephantCount = 1;}


    /**
     * @return EFoodType : return the type of food of the animal
     */
    @Override
    public EFoodType getFoodtype() {return EFoodType.MEAT;}


    /**
     * @return String : representation of elephant
     */
    public String toString()
    {
        return "[!]" + this.getName() + " : " + "total distance :" + "[" + this.gettotalDistance() + "]" + ", weight : " + "[" + this.getWeight() + "]";
    }
}