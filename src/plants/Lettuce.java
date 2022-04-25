package plants;

import graphics.ZooPanel;
import utilities.MessageUtility;

/**
 * @author baroh
 *
 */
public class Lettuce extends Plant
{

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