package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


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
    private JFrame frame;

    /**
     * label
     */
    private JLabel label;

    /**
     * zoo
     */
    private ZooPanel zoo;


    /**
     *
     * @param args : main
     */
    public static void main(String[] args)
    {
        ZooFrame zooframe = new ZooFrame();
        zooframe.zoo.manageZoo();
    }

    /**
     * constructor
     */
    public ZooFrame()
    {
        frame = new JFrame("Zoo Frame");
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

        JButton greenButton = new JButton("green");

        exit.addActionListener(this);
        image.addActionListener(this);
        green.addActionListener(this);
        none.addActionListener(this);
        help.addActionListener(this);

        file.add(exit);
        background.add(green);
        background.add(image);
        background.add(none);
        Help.add(help);

        menuBar.add(file);
        menuBar.add(background);
        menuBar.add(Help);

        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        zoo = new ZooPanel();
        frame.add(zoo, BorderLayout.SOUTH);
        label = new JLabel();
        frame.add(label);

    }

    /**
     *
     * @param e : e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.out.println("Bye, have a great day !");
            System.exit(1);
        }

        if (e.getSource() == image)
        {
            try {
                frame.getContentPane().add(new FrameBackGround("savanna.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if(e.getSource() == green)
        {
           //frame.getContentPane().setBackground(Color.GREEN);
        }

        if(e.getSource() == none)
        {
            frame.getContentPane().setBackground(null);
        }

        if(e.getSource() == help)
        {
            JOptionPane.showMessageDialog(null, "Home Work 2\nGUI", "Message", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}