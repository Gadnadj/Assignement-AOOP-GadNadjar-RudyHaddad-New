package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is a child class of JFrame and implements the ActionListener interface. it allows us to create
 * a window containing several buttons (add animal, move animal, clear, food, info). each button performs
 * an action and opens a new window
 * @author Rudy Haddad
 * @see JFrame
 */
public class ZooFrame extends JFrame implements ActionListener
{

    private JMenuItem exit;
    private JMenuItem image;
    private JMenuItem green;
    private JMenuItem none;
    private JMenuItem help;
    private JLabel label;
    private ZooPanel zoo;

    /**
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
        green = new JMenuItem("Green");
        none = new JMenuItem("None");
        help = new JMenuItem("Help");

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
        background.addSeparator();
        background.add(image);
        background.addSeparator();
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
     * @param e : e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == exit)
        {
            System.out.println("Bye, have a great day !");
            System.exit(1);
        }

        if (e.getSource() == image)
            zoo.setBackgr(2);

        if(e.getSource() == green)
        {
            zoo.setBackgr(1);
            this.getContentPane().setBackground(Color.green);
        }

        if(e.getSource() == none)
        {
            zoo.setBackgr(0);
            this.getContentPane().setBackground(null);
        }

        if(e.getSource() == help)
            JOptionPane.showMessageDialog(null, "Home Work 3\n@Thread", "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}