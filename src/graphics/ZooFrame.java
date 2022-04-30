package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;


/**
 * this class is a child class of JFrame and implements the ActionListener interface. it allows us to create
 * a window containing several buttons (add animal, move animal, clear, food, info). each button performs
 * an action and opens a new window
 * @author Rudy Haddad
 * @see JFrame
 */
public class ZooFrame extends JFrame implements ActionListener
{
    /**
     * item exit
     */
    private JMenuItem exit;

    /**
     * item background image
     */
    JMenuItem image;

    /**
     * item background green
     */
    JMenuItem green;

    /**
     * item background none
     */
    JMenuItem none;

    /**
     * item help
     */
    JMenuItem help;

    /**
     * frame
     */

    /**
     * label
     */
    private JLabel label;

    /**
     * zoo
     */
    private ZooPanel zoo;

    private BufferedImage img = null;



    /**
     *
     * @param args : main
     */
    public static void main(String[] args)
    {
        ZooFrame zooframe = new ZooFrame();
        zooframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        zooframe.setVisible(true);
    }

    /**
     * constructor of ZooFrame
     */
    public ZooFrame()

    {
        this.setName("Zoo Frame");
        JMenu file, background, Help;
        JMenuBar menuBar = new JMenuBar();

        file = new JMenu("File");
        background = new JMenu("Background");
        Help = new JMenu("Help");

        exit = new JMenuItem("Exit");
        image = new JMenuItem("Image");
        green = new JMenuItem("green");
        none = new JMenuItem("None");
        help = new JMenuItem("help");


        exit.addActionListener(this);
        image.addActionListener(this);
        green.addActionListener(this);
        none.addActionListener(this);
        help.addActionListener(this);


        menuBar.add(file);
        menuBar.add(background);
        menuBar.add(Help);

        file.add(exit);
        background.add(green);
        background.add(image);
        background.add(none);
        Help.add(help);





        label = new JLabel();
        this.add(label);



        this.setLayout(new BorderLayout());
        this.setSize(800,600);
        this.add(menuBar, BorderLayout.PAGE_START);

        zoo = new ZooPanel();
        zoo.setOpaque(false);
        this.add(zoo);


    }

    /**
     *
     * @param e : e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == exit) {
            System.out.println("Bye, have a great day !");
            System.exit(1);
        }

        if (e.getSource() == image)
        {
            try {
            this.remove(label);
            this.getContentPane().setBackground(null);
            img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "savanna.png"));
            label = new JLabel();
            label.setBounds(0, 0, 800, 600);
            Image backimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(backimg);
            label.setIcon(imageIcon);
            this.getContentPane().add(label);
        }
catch (IOException a) { System.out.println("Cannot load image");
            System.out.println(a.toString());}
        }

        if(e.getSource() == green)
        {
            this.remove(label);
            this.getContentPane().setBackground(Color.green);
        }

        if(e.getSource() == none)
        {
            this.remove(label);
            this.getContentPane().setBackground(null);
        }

        if(e.getSource() == help)
        {
            JOptionPane.showMessageDialog(null, "Home Work 2\nGUI", "Message", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}