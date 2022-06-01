package graphics;

import java.util.ArrayList;

import food.EFoodType;
import animals.Animal;
/**
 * class represent memento pattern
 * @author Gad Nadjar, Rudy Haddad
 */
public class MementoZoo
{
    private ArrayList<Animal> animals;
    private EFoodType food;

    /**
     * save a list of animals and food and allow us to restore them if the futur after a save
     * @param an : list of animal
     * @param food : which type of food
     * @throws CloneNotSupportedException
     */
    public MementoZoo(ArrayList<Animal> an, EFoodType food) throws CloneNotSupportedException
    {
        animals = new ArrayList<Animal>();
        for(Animal animal : an)
        {
            Animal new_animal = (Animal)animal.clone();
            animals.add(new_animal);

        }
        this.food = food;
    }



    /**
     * @return food
     */
    public EFoodType getFood()
    {
        return food;
    }


    /**
     * @return the list of animals
     */
    public ArrayList<Animal> getList()
    {
        return animals;
    }
}
