package plants;
import graphics.ZooPanel;
import utilities.MessageUtility;

import java.awt.*;

/**
 * class that creates cabbage objects
 * @author baroh
 *
 */
public class Cabbage extends Plant {
    /**
     *
     */


    /**
     * constructor of Cabbage
     * @param pan : panel of zoopanel
     */
    public Cabbage(ZooPanel pan) {
        super(pan);
        //this.loadImages("cabbage.png");
    }

    public Cabbage()
    {
        MessageUtility.logConstractor("Cabbage", "Cabbage");
    }


}