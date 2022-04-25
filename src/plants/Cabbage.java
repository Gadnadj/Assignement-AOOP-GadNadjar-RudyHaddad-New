package plants;
import graphics.ZooPanel;
import utilities.MessageUtility;

import java.awt.*;

/**
 * @author baroh
 *
 */
public class Cabbage extends Plant {
    /**
     *
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