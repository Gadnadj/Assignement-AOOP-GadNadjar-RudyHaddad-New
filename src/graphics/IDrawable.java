package graphics;

import java.awt.*;

/**
 * interface
 */
public interface IDrawable
{
    /**
     *
     */
    public final static String PICTURE_PATH = "…";

    /**
     *
     * @param nm : nm
     */

    /**
     *
     * @param nm : nm
     */
    public void loadImages(String nm);

    /**
     *
     * @param g : g
     */
    public void drawObject (Graphics g);

    /**
     *
     * @return String
     */
    public String getColor();
}