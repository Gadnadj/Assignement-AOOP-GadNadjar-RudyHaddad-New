package graphics;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/** class that creates a frame, containing all the information on the creation of animals
 * @author Gad Nadjar
 * @see JDialog
 */
public class AddAnimalDialog extends JDialog implements ItemListener, ActionListener {
    private String name = null;
    private int size = 0;
    private int hSpeed = 0;
    private int vSpeed = 0;
    private String color = null;
    public static int animalcounter = 0;
    ZooPanel newPan;
    JLabel selectAnimal, selectSize, selectVerSpeed, selectHorSpeed, selectColor, Confirmation;
    JComboBox cselectAnimal;
    JComboBox cselectSize;
    JComboBox cselectVerSpeed;
    JComboBox cselectHorSpeed;
    JComboBox cselectColor;
    JButton bConfirmation;
    private int choosenfactory;
    String[] animals;
    String[] colors;

    /**
     * Create the dialog
     * @param title : title of the dialog
     * @param Factory : type of the factory
     */

    public AddAnimalDialog(String title, int Factory)
    {
        this.choosenfactory = Factory;
        this.setTitle("Add Animal");
        this.setSize(new Dimension(600, 100));
        this.setLayout(new GridLayout(2, 6));
        this.setVisible(true);
        animals = new String[]{"Lion", "Bear", "Elephant", "Giraffe", "Turtle"};
        colors = new String[]{"Red", "Blue", "Natural"};

        selectAnimal = new JLabel("Select Animal");
        selectSize = new JLabel("Select Size");
        selectVerSpeed = new JLabel("VerSpeed");
        selectHorSpeed = new JLabel("HorSpeed");
        selectColor = new JLabel("Color");
        Confirmation = new JLabel("Confirmation");

        cselectAnimal = new JComboBox(animals);
        cselectAnimal.setSelectedIndex(-1);
        cselectSize = new JComboBox();
        cselectHorSpeed = new JComboBox();
        cselectVerSpeed = new JComboBox();
        cselectColor = new JComboBox(colors);
        cselectColor.setSelectedIndex(-1);

        bConfirmation = new JButton("Add");

        add(selectAnimal);
        add(selectSize);
        add(selectVerSpeed);
        add(selectHorSpeed);
        add(selectColor);
        add(Confirmation);
        add(cselectAnimal);
        add(cselectSize);
        add(cselectVerSpeed);
        add(cselectHorSpeed);
        add(cselectColor);
        add(bConfirmation);


        for (int i = 50; i <= 300; i++)
            cselectSize.addItem(i);
        cselectSize.setSelectedIndex(-1);


        for (int i = 1; i <= 10; i++)
            cselectHorSpeed.addItem(i);
        cselectHorSpeed.setSelectedIndex(-1);


        for (int i = 1; i <= 10; i++)
            cselectVerSpeed.addItem(i);
        cselectVerSpeed.setSelectedIndex(-1);

        cselectAnimal.addActionListener(this);
        cselectSize.addActionListener(this);
        cselectHorSpeed.addActionListener(this);
        cselectVerSpeed.addActionListener(this);
        cselectColor.addActionListener(this);
        bConfirmation.addActionListener(this);
    }


    /**
     * @param e the event to be processed
     */
    @Override
    public void itemStateChanged(ItemEvent e)
    {

    }


    /**
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cselectAnimal)
            name = (String) cselectAnimal.getSelectedItem();

        if (e.getSource() == cselectSize)
            size = (int) cselectSize.getSelectedItem();

        if (e.getSource() == cselectHorSpeed)
            hSpeed = (int) cselectHorSpeed.getSelectedItem();

        if (e.getSource() == cselectVerSpeed)
            vSpeed = (int) cselectVerSpeed.getSelectedItem();

        if (e.getSource() == cselectColor)
            color = (String) cselectColor.getSelectedItem();

        if (e.getSource() == bConfirmation)
        {
            ZooPanel.getInstance().addAnimal(name, size, hSpeed, vSpeed, color, choosenfactory);
            setVisible(false);
        }
    }
}
