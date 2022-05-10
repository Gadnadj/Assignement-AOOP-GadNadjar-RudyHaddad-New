package graphics;

import java.awt.*;

/**
 * interface
 */
public interface IDrawable
{
    /**
     * Picture_Path
     */
    public final static String PICTURE_PATH = "Pictures/";
    
    /**
     *
     * @param nm : string of the image
     */
    public void loadImages(String nm);

    /**
     *
     * @param g : graphics
     */
    public void drawObject (Graphics g);

    /**
     *
     * @return String : color of the animal
     */
    public String getColor();
}