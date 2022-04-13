package graphics;

import animals.Animal;

import javax.swing.*;

public class NewWindow
{
    JFrame frame;
    JLabel label;
    Animal arrAnimals[] = new Animal[10];


    NewWindow()
    {
        label = new JLabel();
        frame = new JFrame();
        label.setBounds(0,0,150,50);
        frame.add(label);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setVisible(true);

    }

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