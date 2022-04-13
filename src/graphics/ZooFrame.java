package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ZooFrame extends JFrame implements ActionListener
{


    public static void main(String[] args)
    {
        ZooFrame zooframe = new ZooFrame();
    }




    JMenuItem exit, image, green, none, help;
    JFrame frame;
    BufferedImage img = null;
    JLabel label;
    ZooPanel zoo;


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






    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == exit)
        {
            System.out.println("Bye, have a great day !");
            System.exit(1);
        }

        if(e.getSource() == image)
        {
            label.setBackground(Color.WHITE);
            ImageIcon zoo = new ImageIcon("savanna.png");
            label.setIcon(zoo);
        }

        if(e.getSource() == green)
        {
            label.setIcon(null);
            label.setBackground(Color.GREEN);
            label.setOpaque(true);
            //frame.getContentPane().setBackground(Color.GREEN);
        }

        if(e.getSource() == none)
        {
            label.setIcon(null);
            label.setBackground(null);
            label.setOpaque(true);
            // frame.getContentPane().setBackground(null);
        }

        if(e.getSource() == help)
        {
            JOptionPane.showMessageDialog(null, "Home Work 2\nGUI", "Message", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}