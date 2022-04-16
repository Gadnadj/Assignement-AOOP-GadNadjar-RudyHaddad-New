package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * this class is a child class of JPanel. it allows us to put a wallpaper on our frame
 * @author Rudy Haddad
 * @see JPanel
 */
public class FrameBackGround extends JPanel
{
    /**
     * background savanna
     */
        private Image backgroundImage;

    /**
     *
     * @param fileName : name of the file
     * @throws IOException : exception
     */
    public FrameBackGround(String fileName) throws IOException
        {
            backgroundImage = ImageIO.read(new File(fileName));
        }

    /**
     *
     * @param g : g
     */
    public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this);
        }
}

