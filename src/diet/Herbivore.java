/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

/** this class is for type object Herbivore. if the animal has herbivore so he can only eat Vegetable food.
 *
 *  @version 27.03.2022
 *  @see animals.Animal
 *  @author Rudy haddad
 *
 */

public class Herbivore implements IDiet
{

    /**
     *  @param food : type of food
     *  @return boolean : true if the food is edible
     */
    public boolean canEat(EFoodType food)
    {
        return food == EFoodType.VEGETABLE;
    }


    /**
     *
     * @return String :
     */
    public String toString()
    {
        return "[" + "Herbivore" + "]";
    }


    /**
     * @param animal : any type of animal
     *  @param food : type of food (if the food is edible)
     *
     *  @return double : how much weight did the animal gain after eating
     */
    public double eat(Animal animal, IEdible food)
    {
        if(canEat(food.getFoodtype()))
        {
            return (animal.getWeight() * 0.07);
        }
        else
            return 0;

    }
}