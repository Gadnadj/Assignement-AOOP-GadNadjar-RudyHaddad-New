package factory;

import javax.swing.JOptionPane;

import animals.Animal;
import animals.Elephant;
import animals.Giraffe;
import animals.Turtle;
import graphics.ZooPanel;

/**
 *
 * @author Haim Nahmani
 */
public class FactoryHerbivore implements AbstractZooFactory{
    /**
     * produceAnimal by his Factory(HerbivoreFactory)
     */
    @Override
    public Animal produceAnimal(String animal, int sz, int hor, int ver,String c, ZooPanel pan) {
        if(animal.equals("Turtle"))
            return new Turtle(animal, sz, hor, ver, c, pan);
        else if(animal.equals("Elephant"))
            return new Elephant(animal, sz, hor, ver, c, pan);
        else if(animal.equals("Giraffe"))
            return new Giraffe(animal, sz, hor, ver, c, pan);
        else
        {
            JOptionPane.showMessageDialog(null, "Herbivore Factory Can Create Only : Turtle, Elephant, Giraffe");
            return null;
        }
    }

}