package graphics;

import animals.*;

import javax.swing.*;
import javax.swing.colorchooser.DefaultColorSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class AddAnimalDialog<counter> extends JDialog implements ActionListener
{
    JComboBox comboBox;
    JComboBox comboBox2;
    JComboBox comboBox3;
    JComboBox comboBox4;
    JComboBox comboBox5;
    private Object name;
    private Object size;
    private Object hSpeed;
    private Object vSpeed;
    private Object color;
    static Animal arrAnimals[] = new Animal[10];
    public static int counter = 0;
    String[][] animalss = new String[10][];



    JLabel selectAnimal, selectSize, selectVerSpeed, selectHorSpeed, selectColor, Confirmation;
    JComboBox cselectAnimal, cselectSize, cselectVerSpeed, cselectHorSpeed, cselectColor;
    JButton bConfirmation;


    JButton confirmationButton;

    JLabel labelSelectAnimal;

    public AddAnimalDialog() {

        this.setTitle("Add Animal");
        this.setSize(new Dimension(600, 100));
        this.setLayout(new GridLayout(2, 6));
        //this.pack();
        this.setVisible(true);

        String[] animals = {"Lion", "Bear", "Elephant", "Giraffe", "Turtle"};

        String[] horSpeed = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] verSpeed = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] colors = {"RED", "BLUE", "NATURAL"};

        selectAnimal = new JLabel("Select Animal");
        selectSize = new JLabel("Select Size");
        selectVerSpeed = new JLabel("VerSpeed");
        selectHorSpeed = new JLabel("HorSpeed");
        selectColor = new JLabel("Color");
        Confirmation = new JLabel("Confirmation");


        cselectAnimal = new JComboBox(animals);
        cselectSize = new JComboBox();
        cselectHorSpeed = new JComboBox();
        cselectVerSpeed = new JComboBox();
        cselectColor = new JComboBox(colors);
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


        //cselectAnimal.addItem(animals);

        for (int i = 50; i <= 300; i++) {
            cselectSize.addItem(i);
        }

        for (int i = 1; i <= 10; i++) {
            cselectHorSpeed.addItem(i);
        }

        for (int i = 1; i <= 10; i++) {
            cselectVerSpeed.addItem(i);
        }


        cselectAnimal.addActionListener(this);
        cselectSize.addActionListener(this);
        cselectHorSpeed.addActionListener(this);
        cselectVerSpeed.addActionListener(this);
        cselectColor.addActionListener(this);
        bConfirmation.addActionListener(this);

    }

    public Animal[] addAnimal() {
        if (counter < 10) {
            if (name.equals("Lion")) {
                String name1 = (String)name;
                int size1 = (int)size;
                int hSpeed1 = (int)hSpeed;
                int vSpeed1 = (int)vSpeed;
                String colors = (String)color;
                Color color1 = stringToColor(colors);
                arrAnimals[counter] = new Lion(size1, hSpeed1, vSpeed1, color1);
                counter++;
                return arrAnimals;
            }

            if (name.equals("Bear")) {
                String name1 = (String)name;
                int size1 = (int)size;
                int hSpeed1 = (int)hSpeed;
                int vSpeed1 = (int)vSpeed;
                String colors = (String)color;
                Color color1 = stringToColor(colors);
                arrAnimals[counter] = new Bear(size1, hSpeed1, vSpeed1, color1);
                counter++;
                return arrAnimals;
            }

            if (name.equals("Elephant")) {
                String name1 = (String)name;
                int size1 = (int)size;
                int hSpeed1 = (int)hSpeed;
                int vSpeed1 = (int)vSpeed;
                String colors = (String)color;
                Color color1 = stringToColor(colors);
                arrAnimals[counter] = new Elephant(size1, hSpeed1, vSpeed1, color1);
                counter++;
                return arrAnimals;
            }

            if (name.equals("Giraffe")) {
                String name1 = (String)name;
                int size1 = (int)size;
                int hSpeed1 = (int)hSpeed;
                int vSpeed1 = (int)vSpeed;
                String colors = (String)color;
                Color color1 = stringToColor(colors);
                arrAnimals[counter] = new Giraffe(size1, hSpeed1, vSpeed1, color1);
                counter++;
                return arrAnimals;
            }

            if (name.equals("Turtle")) {
                String name1 = (String)name;
                int size1 = (int)size;
                int hSpeed1 = (int)hSpeed;
                int vSpeed1 = (int)vSpeed;
                String colors = (String)color;
                Color color1 = stringToColor(colors);
                arrAnimals[counter] = new Turtle(size1, hSpeed1, vSpeed1, color1);
                counter++;
                return arrAnimals;
            }
            }

        return arrAnimals;
    }


    public Animal[] getAnimal()
    {
        return this.arrAnimals;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == cselectAnimal) {
            name =  cselectAnimal.getSelectedItem();
        }

        if (e.getSource() == cselectSize) {
            size =  cselectSize.getSelectedItem();
        }

        if (e.getSource() == cselectHorSpeed) {
            hSpeed =  cselectHorSpeed.getSelectedItem();
        }

        if (e.getSource() == cselectVerSpeed) {
            vSpeed =  cselectVerSpeed.getSelectedItem();
        }

        if (e.getSource() == cselectColor) {
            color = (String) cselectColor.getSelectedItem();

        }

        if (e.getSource() == bConfirmation) {
            addAnimal();
            String[] column = {"bla","bla","bla","bla","bla"};
            Animal animalsss[][] = new Animal[10][];
            for(int i = 0 ; i < arrAnimals.length ; i++)
            {
                animalsss[i][0] = arrAnimals[i];
            }
            JTable table = new JTable(animalsss, column);
            NewWindow window = new NewWindow(table);
            dispose();
            JOptionPane.showMessageDialog(null, "Animal Added", "Animal Added", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static Color stringToColor(final String value) {
        if (value.equals("RED") == false || value.equals("BLUE") == false) {
            return Color.WHITE;
        }
        try {
            // get color by hex or octal value
            return Color.decode(value);
        } catch (NumberFormatException nfe) {
            // if we can't decode lets try to get it by name
            try {
                // try to get a color by name using reflection
                final Field f = Color.class.getField(value);

                return (Color) f.get(null);
            } catch (Exception ce) {
                // if we can't get any color return black
                return Color.black;
            }
        }
    }

}
