package graphics;

import animals.Animal;
import animals.Lion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAnimalDialog extends JDialog implements ActionListener
{


    JComboBox comboBox;
    JComboBox comboBox2;
    JComboBox comboBox3;
    JComboBox comboBox4;
    JComboBox comboBox5;
    Object name;
    Object size;
    Object hSpeed;
    Object vSpeed;
    Object color;
    Animal arrAnimals[];


    public AddAnimalDialog()
    {
        this.setName("Add Animal");
        this.setLayout(new FlowLayout());
        this.setSize(1000,400);



        String[] animals ={"Lion", "Bear", "Elephant", "Giraffe", "Turtle"};
        String[] size = {"51", "52", "53", "54", "55","56", "57", "58", "59", "60"};
        String[] hSpeed = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] vSpeed = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] color = {"Red", "Blue", "Natural"};

         comboBox = new JComboBox(animals);
         comboBox2 = new JComboBox(size);
         comboBox3 = new JComboBox(hSpeed);
         comboBox4 = new JComboBox(vSpeed);
         comboBox5 = new JComboBox(color);

         comboBox.addActionListener(this);
        comboBox2.addActionListener(this);
        comboBox3.addActionListener(this);
        comboBox4.addActionListener(this);
        comboBox4.addActionListener(this);
        this.add(comboBox);
        this.add(comboBox2);
        this.add(comboBox3);
        this.add(comboBox4);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == comboBox)
        {
            name = comboBox.getSelectedItem();
        }

        if(e.getSource() == comboBox2)
        {
            size = comboBox2.getSelectedItem();
        }

        if(e.getSource() == comboBox3)
        {
            hSpeed = comboBox3.getSelectedItem();
        }

        if(e.getSource() == comboBox4)
        {
            vSpeed = comboBox4.getSelectedItem();
        }

        if(e.getSource() == comboBox5)
        {
            color = comboBox5.getSelectedItem();
        }
    }

}
