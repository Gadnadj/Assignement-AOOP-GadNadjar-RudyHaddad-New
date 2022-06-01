package factory;

import animals.Animal;
/**
 * Abstract Factory class
 * @author Gad Nadjar, Rudy Haddad
 */


public interface AbstractZooFactory
{
     /**
      * @param animal : type of animal
      * @param sz : size of the animal
      * @param hor : horizontal speed of the animal
      * @param ver : vertical speed of the animal
      * @param c : color of the animal
      * @return Animal
      */
     Animal produceAnimal(String animal, int sz, int hor, int ver, String c);
}
