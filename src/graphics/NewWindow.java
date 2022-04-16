package graphics;

import javax.swing.*;

/**
 * this class creates a new frame, which includes a table containing all the animals and
 * their information (name, weight, horizontal speed, vertical speed, color, number of food eaten)
 * @author Rudy Haddad
 *
 */
public class NewWindow
{
    JFrame frame;
    JLabel label;

    /**
     *
     * @param a : JTable
     */
    NewWindow(JTable a){
        label = new JLabel();
        frame = new JFrame();
        label.setBounds(0,0,150,50);
        frame.add(label);
        a.setBounds(30,40,200,300);
        JScrollPane sp = new JScrollPane(a);
        frame.add(sp);

        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        //frame.setLayout(null);
        frame.setVisible(true);

    }
}