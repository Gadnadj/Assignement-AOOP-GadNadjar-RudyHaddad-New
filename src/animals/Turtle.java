/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import diet.IDiet;
import food.EFoodType;
import graphics.ZooPanel;
import diet.Herbivore;
/**
 * the utilities of this class is the creation of a new animal turtle. all function turtle can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Rudy Haddad
 * @see animals.Animal
 **/
public class Turtle extends Animal
{
    private int age;
    private final static IDiet diet = new Herbivore();
    static int turtleCount = 1;


    /**
     * @param size     : size of the animal
     * @param horSpeed : horizontal speed of the animal
     * @param verSpeed : vertical speed of the animal
     * @param color    : color of the animal
     * @param pan : panel of ZooPanel
     * @param name : name of the turtle
     */
    public Turtle(String name, int size, int horSpeed, int verSpeed, String color, ZooPanel pan)
    {
        super(size, horSpeed, verSpeed, color, pan);
        this.setWeight(this.getSize() * 0.5);
        this.setName(name + turtleCount);
        this.setX(80);
        this.setY(0);
        this.loadImages("trt");
        this.setDiet(diet);
        this.setPan(pan);
        turtleCount++;
    }


    /**
     * number of turtle in the zoo
     */
    public static void setTurtleCount(){turtleCount = 1;}


    /**
     * @return EFoodType : return the type of food of the animal
     */
    @Override
    public EFoodType getFoodtype() {return EFoodType.MEAT;}


    /**
     * @return String : Representation of turtle
     */
    public String toString() {
        return "[!]" + this.getName() + " : " + "total distance :" + "[" + this.gettotalDistance() + "]" + ", weight : " + "[" + this.getWeight() + "]";
    }
}