package factory;

import javax.swing.JOptionPane;

import animals.Animal;
import animals.Lion;
import graphics.ZooPanel;

/**
 *
 * @author Haim Nahmani
 */
public class FactoryCarnivore implements AbstractZooFactory{
    /**
     * produceAnimal by his Factory(CarnivoreFactory)
     */
    @Override
    public Animal produceAnimal(String animal, int sz, int hor, int ver,String c, ZooPanel pan) {
        if(animal.equals("Lion"))
            return new Lion (animal, sz, hor, ver, c, pan);
        else
        {
            JOptionPane.showMessageDialog(null, "Carnivore Factory Can Create Only : Lion");
            return null;
        }
    }

}