/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package diet;
import food.EFoodType;
import food.IEdible;
import animals.Animal;

/** it is an interface on the animal describing what it can eat and what it eats
 *  @version 27.03.2022
 *  @see animals.Animal
 *  @author Rudy haddad
 *
 */

public interface IDiet
{

    /**
     * @param food : type of the food
     *
     *  @return boolean : if the food is edible
     */
    boolean canEat(EFoodType food);


    /**
     *  @param animal : any type of animal
     *  @param food : type of food (if the food is edible)
     *
     *  @return double : how much weight did the animal gain after eating
     */
    double eat(Animal animal, IEdible food);
}