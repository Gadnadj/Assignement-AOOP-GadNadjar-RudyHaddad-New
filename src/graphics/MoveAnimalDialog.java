package graphics;


import mobility.Point;
import plants.Plant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class is a child class of JFrame and implements the ActionListener interface. It creates a new frame,
 * and allows us to modify the x and y coordinates of each animal in the table
 * @author Gad Nadjar
 * @see JFrame
 */
public class MoveAnimalDialog extends JFrame implements ActionListener
{
    /**
     * frame
     */
    JFrame frame;

    /**
     * label of the coordinate x
     */
    JLabel select_X;

    /**
     * label of the coordinate y
     */
    JLabel select_Y;

    /**
     * label of the button confirmation
     */
    JLabel Confirmation;

    /**
     * label of all animal
     */
    JLabel allAnimal;

    /**
     * combo box of the coordinate x
     */
    JComboBox cSelect_X;

    /**
     * combo box of the coordinate y
     */
    JComboBox cSelect_Y;

    /**
     * combo box of the animal
     */
    JComboBox cAllAnimal;

    /**
     * button confirmation
     */
    JButton bConfirmation;

    /**
     * number of animal
     */
    private int counter = 0;

    /**
     * plant
     */
    private Plant plant = null;

    /**
     * Zoopan of zoopanel
     */
    private ZooPanel ZooPan;


    /**
     * Construct of MoveAnimalDialog
     * @param pan : panel of zoopanel
     */
    public MoveAnimalDialog(ZooPanel pan)
    {
        frame = new JFrame();
        frame.setTitle("Move Animal");
        frame.setSize(new Dimension(600, 100));
        frame.setLayout(new GridLayout(2, 6));
        frame.setVisible(true);
        allAnimal = new JLabel("Animal");
        select_X = new JLabel("Coordinate X");
        select_Y = new JLabel("Coordinate y");
        Confirmation = new JLabel("Confirmation");

        this.ZooPan = pan;

        cSelect_X = new JComboBox();
        cSelect_Y = new JComboBox();
        bConfirmation = new JButton("Confirm");
        cAllAnimal = new JComboBox();


        frame.add(allAnimal);
        frame.add(select_X);
        frame.add(select_Y);
        frame.add(Confirmation);
        frame.add(cAllAnimal);
        frame.add(cSelect_X);
        frame.add(cSelect_Y);
        frame.add(bConfirmation);


        for (int i = 0; i <= 800; i++) {
            cSelect_X.addItem(i);
        }
        cSelect_X.setSelectedIndex(-1);

        for (int i = 0 ; i <= 600; i++) {
            cSelect_Y.addItem(i);
        }
        cSelect_Y.setSelectedIndex(-1);

        for(int i = 0 ; i < ZooPanel.data.size(); i++)
        {
            cAllAnimal.addItem(ZooPanel.data.get(i).getName());
        }
        cAllAnimal.setSelectedIndex(-1);

        cAllAnimal.addActionListener(this);
        cSelect_X.addActionListener(this);
        cSelect_Y.addActionListener(this);
        bConfirmation.addActionListener(this);
    }

    /**
     *
     * @param e : e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == cAllAnimal)
        {
            counter = cAllAnimal.getSelectedIndex();
        }

        if (e.getSource() == cSelect_X)
        {
            if(ZooPanel.data.get(counter).gettX() != cSelect_X.getSelectedIndex())
                ZooPanel.data.get(counter).setChanges(true);
            ZooPanel.data.get(counter).setX(cSelect_X.getSelectedIndex());

        }

        if(e.getSource() == cSelect_Y)
        {
            if(ZooPanel.data.get(counter).gettY() != cSelect_Y.getSelectedIndex())
                ZooPanel.data.get(counter).setChanges(true);
            ZooPanel.data.get(counter).setY(cSelect_Y.getSelectedIndex());
        }

        if(e.getSource() == bConfirmation)
        {
            if(cAllAnimal.getSelectedIndex() == -1 || cSelect_X.getSelectedIndex() == -1 || cSelect_Y.getSelectedIndex() == -1)
                JOptionPane.showMessageDialog(null, "Selected All Characters", "Selected All Characters", JOptionPane.ERROR_MESSAGE);
            else
            {
                JOptionPane.showMessageDialog(null, "Coordinate Changed", "Coordinate", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                ZooPan.manageZoo();
            }
        }
    }
}
