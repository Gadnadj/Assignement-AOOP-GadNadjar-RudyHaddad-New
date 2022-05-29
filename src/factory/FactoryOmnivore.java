package factory;

import javax.swing.JOptionPane;

import animals.Animal;
import animals.Bear;
import graphics.ZooPanel;

/**
 *
 * @author Haim Nahmani
 */
public class FactoryOmnivore implements AbstractZooFactory{
    /**
     * produceAnimal by his Factory(OmnivoreFactory)
     */
    @Override
    public Animal produceAnimal(String animal, int sz, int hor, int ver,String c, ZooPanel pan) {
        if(animal.equals("Bear"))
            return new Bear(animal, sz, hor, ver, c, pan);
        else
        {
            JOptionPane.showMessageDialog(null, "Omnivore Factory Can Create Only : Bear");
            return null;
        }
    }

}