/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;


/**this class give type of sound for animal use it.
 *
 * @version: 27.03.2022
 * @see animals.Animal
 * @author rudy Haddad
 */

import graphics.ZooPanel;
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
     */
    public Roar(String name)
    {
        super(name);
    }

    /**
     *
     * @param size : size of the animal
     * @param horSpeed : horizontal speed of the animal
     * @param verSpeed : vertical speed of the animal
     * @param color : color of the animal
     * @param pan  : panel of zoopanel
     */
    public Roar(int size, int horSpeed, int verSpeed, String color, ZooPanel pan){super(size, horSpeed, verSpeed, color, pan);}

    public void makeSound()
    {
        if(this instanceof Lion)
            MessageUtility.logSound(getName(), "Roars, then stretches and shakes its mane");
        if(this instanceof Bear)
            MessageUtility.logSound(getName(),"Stands on its hind legs, roars and scratches its belly");
    }



}