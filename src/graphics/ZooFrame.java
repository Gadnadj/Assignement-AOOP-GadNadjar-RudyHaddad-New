package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * this class is a child class of JFrame and implements the ActionListener interface. it allows us to create
 * a window containing several buttons (add animal, move animal, clear, food, info). each button performs
 * an action and opens a new window
 * @author Gad Nadjar, Rudy Haddad
 * @see JFrame
 */
public class ZooFrame extends JFrame implements ActionListener
{
    private String[] names = {"Exit","Image","Green","None","Help"};
    private JMenu m1, m2, m3;
    JMenu file, background, Help;
    private JMenuItem exit;
    private JMenuItem image;
    private JMenuItem green;
    private JMenuItem none;
    private JMenuItem help;
    private JMenuBar mb;
    private ZooPanel zoo;
    private JLabel label;

    public static void main(String[]args)
    {
        ZooFrame aqua = new ZooFrame();
        aqua.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        aqua.setSize(800,600);
        aqua.setVisible(true);
    }

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

        this.add(ZooPanel.getInstance());}
    /**
     * @param e : e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == exit)
        {
            destroy();
        }

        if (e.getSource() == image)
            ZooPanel.getInstance().setBackgr(2);

        if(e.getSource() == green)
        {
            ZooPanel.getInstance().setBackgr(1);
            ZooPanel.getInstance().setBackground(Color.GREEN);
        }

        if(e.getSource() == none)
        {
            ZooPanel.getInstance().setBackgr(0);
            ZooPanel.getInstance().setBackground(null);
        }

        if(e.getSource() == help)
        {
            printHelp();
        }
    }

    public void destroy() {
        ZooPanel.getInstance().destroy();
    }

    public void printHelp() {
        JOptionPane.showMessageDialog(this, "Home Work 4\nGUI @ Designs Pattern");
    }

}
