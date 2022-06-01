package factory;

import animals.Animal;
/**
 *
 * @author Gad Nadjar, Rudy Haddad
 */
public interface AbstractZooFactory {
    public Animal produceAnimal(String animal, int sz, int hor, int ver, String c);


}
