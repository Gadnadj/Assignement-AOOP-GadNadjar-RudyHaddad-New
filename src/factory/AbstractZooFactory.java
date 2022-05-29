package factory;

import animals.Animal;
import graphics.ZooPanel;

public interface AbstractZooFactory
{
    public Animal produceAnimal(String animal, int sz, int hor, int ver,String c, ZooPanel pan);
}