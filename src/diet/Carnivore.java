/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package diet;
import food.EFoodType;
import food.IEdible;
import animals.*;

/** this class is for type object Carnivore. If the animal has carnivore, so he can only eat meat food that mean another
 * animals be to check because any animals can eat lion.
 *  @see animals.Animal
 *  @author Gad Nadjar
 */

public  class Carnivore implements IDiet
{
    /**
     *  @param food : type of food
     *  @return boolean : true if the food is edible
     */
    public boolean canEat(EFoodType food)
    {
        return food == EFoodType.MEAT;
    }



    /**
     * @param animal : any type of animal
     *  @param food : type of food (if the food is edible)
     *  @return double : how much weight did the animal gain after eating
     */
    public double eat(Animal animal, IEdible food)
    {
        if(canEat(food.getFoodtype()))
            return (animal.getWeight() * 0.10);
        else
            return 0;
    }


    /**
     * @return String : representation of carnivore
     */
    public String toString()
    {
        return "[" + "Carnivore" + "]";
    }
}
