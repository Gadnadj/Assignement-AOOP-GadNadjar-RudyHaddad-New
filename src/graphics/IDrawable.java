package graphics;
import java.awt.*;

/**
 * interface
 */
public interface IDrawable
{
    String PICTURE_PATH = "Pictures/";


    /**
     * @param nm : string of the image
     */
    void loadImages(String nm);


    /**
     * @param g : graphics
     */
    void drawObject (Graphics g);


    /**
     * @return String : color of the animal
     */
    String getColor();
}