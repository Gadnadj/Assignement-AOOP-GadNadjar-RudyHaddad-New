package factory;

import javax.swing.JOptionPane;

import animals.Animal;
import animals.Elephant;
import animals.Giraffe;
import animals.Turtle;
/**
 * Herbivore Factory class
 * @author Gad Nadjar, Rudy Haddad
 */
public class FactoryHerbivore implements AbstractZooFactory{
    /**
     * produceAnimal by his Factory(HerbivoreFactory)
     */
    @Override
    public Animal produceAnimal(String animal, int sz, int hor, int ver,String c) {
        switch (animal) {
            case "Turtle":
                return new Turtle(sz, 0, 0, hor, ver, c);
            case "Elephant":
                return new Elephant(sz, 0, 0, hor, ver, c);
            case "Giraffe":
                return new Giraffe(sz, 0, 0, hor, ver, c);
            default:
                JOptionPane.showMessageDialog(null, "Herbivore Factory Can Create Only : Turtle, Elephant, Giraffe");
                return null;
        }
    }

}
