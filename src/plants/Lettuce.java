package plants;

import graphics.ZooPanel;
import utilities.MessageUtility;

/** class that creates lettuce objects
 * @author baroh
 */
public class Lettuce extends Plant
{

    /**
     * constructor of lettuce class
     * @param pan : panel of zoopanel
     */
    public Lettuce(ZooPanel pan)
    {
        super(pan);
        //this.loadImages("lettuce.png");
    }

    /**
     * no comment
     */
    public Lettuce() {
        MessageUtility.logConstractor("Lettuce", "Lettuce");
    }
}