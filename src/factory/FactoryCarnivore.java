package factory;

import javax.swing.JOptionPane;

import animals.Animal;
import animals.Lion;
/**
 *
 * @author Gad Nadjar, Rudy Haddad
 */
public class FactoryCarnivore implements AbstractZooFactory{
    /**
     * produceAnimal by his Factory(CarnivoreFactory)
     */
    @Override
    public Animal produceAnimal(String animal, int sz, int hor, int ver,String c) {
        if(animal.equals("Lion"))
            return new Lion (sz,0,0,hor,ver,c);
        else
        {
            JOptionPane.showMessageDialog(null, "Carnivore Factory Can Create Only : Lion");
            return null;
        }
    }

}
