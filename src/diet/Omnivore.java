package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * this class is for type object Omnivore. if the animal has herbivore and carnivore, so he can eat Vegetable
 * food and meat food. that mean omnivore can eat other animal except lion
 *
 * @author Rudy haddad
 * @version 27.03.2022
 * @see animals.Animal
 */
public class Omnivore implements IDiet
{
    private IDiet carnivore;
    private IDiet herbivore;


    public Omnivore()
    {
        this.carnivore = new Carnivore();
        this.herbivore = new Herbivore();
    }



    /**
     * @param food : type of food
     * @return boolean : true if the food is edible
     */
    @Override
    public boolean canEat(EFoodType food)
    {
        return this.carnivore.canEat(food) || this.herbivore.canEat(food);
    }



    /**
     * @param animal : any type of animal
     * @param food   : type of food (if the food is edible)
     * @return double : how much weight did the animal gain after eating
     */
    public double eat(Animal animal, IEdible food)
    {
        return calcWeight(animal, food);
    }


    /**
     * @param animal : animal
     * @param food   : sort of food
     * @return double
     */
    public static double calcWeight(Animal animal, IEdible food) {
        if (food.getFoodtype() == EFoodType.MEAT)
            return animal.getWeight() * 0.10;
        if (food.getFoodtype() == EFoodType.VEGETABLE)
            return animal.getWeight() * 0.07;
        else
            return 0;
    }


    /**
     * @return String : representation of omnivore
     */
    public String toString()
    {
        return "[" + "Omnivore" + "]";
    }
}

