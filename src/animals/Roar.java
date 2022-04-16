/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;


/**this class give type of sound for animal use it.
 *
 * @version: 27.03.2022
 * @see animals.Animal
 * @author rudy Haddad
 */

import mobility.Point;
import utilities.MessageUtility;

import java.awt.*;

/**this class give type of sound for animal use it.
 *
 * @version: 27.03.2022
 * @see animals.Animal
 * @author rudy Haddad
 */

/**
 * class Roar
 */
public abstract class Roar extends Animal
{

    /**
     *
     * @param name : name of the animal
     * @param location : location of the animal
     */
    public Roar(String name, Point location)
    {
        super(name, location);
    }

    /**
     *
     * @param location : location of the animal
     * @param size : size of the animal
     * @param horSpeed : horizontal speed of the animal
     * @param verSpeed : vertical speed of the animal
     * @param color : color of the animal
     */
    public Roar(Point location, int size, int horSpeed, int verSpeed, String color){super(location, size, horSpeed, verSpeed, color);}

    public void makeSound()
    {
        if(this instanceof Lion)
            MessageUtility.logSound(getName(), "Roars, then stretches and shakes its mane");
        if(this instanceof Bear)
            MessageUtility.logSound(getName(),"Stands on its hind legs, roars and scratches its belly");
    }

}