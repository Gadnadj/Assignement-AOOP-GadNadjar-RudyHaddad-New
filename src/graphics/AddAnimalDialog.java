package graphics;
import animals.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * 
 * @param <counter> : number of animals
 */
public class AddAnimalDialog<counter> extends JDialog implements ActionListener
{
    
    /**
     * type of the animal
     */
    private String name = null;

    /**
     * size of the animal
     */
    private int size = 0;
    
    /**
     * horizontal speed
     */
    private int hSpeed = 0;

    /**
     * vertical speed
     */
    private int vSpeed = 0;

    /**
     * color of the animal
     */
    private String color = null;

    /**
     * number of animals
     */
    public static int animalcounter = 0;

    ZooPanel newPan;


    /**
     * This class is a child class of JDialog and implements the ActionListener interface.
     * She's allows us to create animals and add them to the information table
     * @author Gad Nadjar
     * @see JDialog
     */


    JLabel selectAnimal, selectSize, selectVerSpeed, selectHorSpeed, selectColor, Confirmation;
    /**
     * Combo box type of animal
     */
    JComboBox cselectAnimal;

    /**
     * Combo box size of animal
     */
    JComboBox cselectSize;

    /**
     * Combo box vertical speed
     */
    JComboBox cselectVerSpeed;

    /**
     * Combo box horizontal speed
     */
    JComboBox cselectHorSpeed;

    /**
     * Combo box color the animal
     */
    JComboBox cselectColor;


    private double distance;
    
    
    /**
     * confirmation button
     */
    JButton bConfirmation;

    /**
     * Constructor of addanimaldialog
     */
    public AddAnimalDialog(ZooPanel pan) {

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

        newPan = pan;
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

    /**
     * #
     * @return Animal
     */
    public Animal addAnimal()
    {
        Animal animal = null;
        if (animalcounter < 10) {
            if (name.equals("Lion"))
            {
                Lion lion = new Lion(size, hSpeed, vSpeed, color, newPan);
                lion.setWeight(size * 0.8);
                ZooPanel.data.add(animalcounter, lion);
                ZooPanel.dataTable[animalcounter][0] = name;
                ZooPanel.dataTable[animalcounter][1] = color;
                ZooPanel.dataTable[animalcounter][2] = lion.getWeight();
                ZooPanel.dataTable[animalcounter][3] = hSpeed;
                ZooPanel.dataTable[animalcounter][4] = vSpeed;
                ZooPanel.dataTable[animalcounter][5] = lion.getEatCount();
                if(color.equals("NATURAL"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/lio_n_1.png");
                if(color.equals("BLUE"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/lio_b_1.png");
                if(color.equals("RED"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/lio_r_1.png");
            }

            if (name.equals("Bear"))
            {
                Bear bear = new Bear(size, hSpeed, vSpeed, color, newPan);
                bear.setWeight(size * 1.5);
                ZooPanel.data.add(animalcounter, bear);
                ZooPanel.dataTable[animalcounter][0] = name;
                ZooPanel.dataTable[animalcounter][1] = color;
                ZooPanel.dataTable[animalcounter][2] = bear.getWeight();
                ZooPanel.dataTable[animalcounter][3] = hSpeed;
                ZooPanel.dataTable[animalcounter][4] = vSpeed;
                ZooPanel.dataTable[animalcounter][5] = bear.getEatCount();
                if(color.equals("NATURAL"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/bea_n_1.png");
                if(color.equals("BLUE"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/bea_b_1.png");
                if(color.equals("RED"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/bea_r_1.png");

            }

            if (name.equals("Elephant"))
            {
                Elephant elephant = new Elephant(size, hSpeed, vSpeed, color, newPan);
                elephant.setWeight(size * 10);
                ZooPanel.data.add(animalcounter, elephant);
                ZooPanel.dataTable[animalcounter][0] = name;
                ZooPanel.dataTable[animalcounter][1] = color;
                ZooPanel.dataTable[animalcounter][2] = elephant.getWeight();
                ZooPanel.dataTable[animalcounter][3] = hSpeed;
                ZooPanel.dataTable[animalcounter][4] = vSpeed;
                ZooPanel.dataTable[animalcounter][5] = elephant.getEatCount();
                if(color.equals("NATURAL"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/elf_n_1.png");
                if(color.equals("BLUE"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/elf_b_1.png");
                if(color.equals("RED"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/elf_r_1.png");

            }

            if (name.equals("Giraffe"))
            {

                Giraffe giraffe = new Giraffe(size, hSpeed, vSpeed, color, newPan);
                giraffe.setWeight(size * 2.2);
                ZooPanel.data.add(animalcounter, giraffe);
                ZooPanel.dataTable[animalcounter][0] = name;
                ZooPanel.dataTable[animalcounter][1] = color;
                ZooPanel.dataTable[animalcounter][2] = giraffe.getWeight();
                ZooPanel.dataTable[animalcounter][3] = hSpeed;
                ZooPanel.dataTable[animalcounter][4] = vSpeed;
                ZooPanel.dataTable[animalcounter][5] = giraffe.getEatCount();
                if(color.equals("NATURAL"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/grf_n_1.png");
                if(color.equals("BLUE"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/grf_b_1.png");
                if(color.equals("RED"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/grf_r_1.png");

            }

            if (name.equals("Turtle"))
            {
                Turtle turtle = new Turtle(size, hSpeed, vSpeed, color, newPan);
                turtle.setWeight(size * 0.5);
                ZooPanel.data.add(animalcounter, turtle);
                ZooPanel.dataTable[animalcounter][0] = name;
                ZooPanel.dataTable[animalcounter][1] = color;
                ZooPanel.dataTable[animalcounter][2] = turtle.getWeight();
                ZooPanel.dataTable[animalcounter][3] = hSpeed;
                ZooPanel.dataTable[animalcounter][4] = vSpeed;
                ZooPanel.dataTable[animalcounter][5] = turtle.getEatCount();
                if(color.equals("NATURAL"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/trt_n_1.png");
                if(color.equals("BLUE"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/trt_b_1.png");
                if(color.equals("RED"))
                    ZooPanel.data.get(animalcounter).loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/trt_r_1.png");
            }
        }

    return null;
    }

    /**
     *
     * @return int
     */
    public int getSize1()
    {
        return this.size;
    }

    /**
     *
     * @return String
     */
    public String getName1()
    {
        return this.name;
    }

    /**
     *
     * @return int
     */
    public int gethSpeed1()
    {
        return this.hSpeed;
    }

    /**
     *
     * @return int
     */
    public int getvSpeed1()
    {
        return this.vSpeed;
    }

    /**
     *
     * @return String
     */
    public String getColor()
    {
        return color;
    }

    /**
     *
     * @param e : e
     */
    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == cselectAnimal) {
            name = (String) cselectAnimal.getSelectedItem();
        }

        if (e.getSource() == cselectSize) {
            size =  (int)cselectSize.getSelectedItem();
        }

        if (e.getSource() == cselectHorSpeed) {
            hSpeed = (int) cselectHorSpeed.getSelectedItem();
        }

        if (e.getSource() == cselectVerSpeed) {
            vSpeed = (int) cselectVerSpeed.getSelectedItem();
        }

        if (e.getSource() == cselectColor)
        {
            color = (String) cselectColor.getSelectedItem();
        }

        if (e.getSource() == bConfirmation)
        {
            if(name == null)
                name = "Lion";
            if(size == 0)
                size = 50;
            if(hSpeed == 0)
                hSpeed = 1;
            if(vSpeed == 0)
                vSpeed = 1;
            if(color == null)
                color = "NATURAL";
            addAnimal();
            animalcounter++;
            dispose();
            if(animalcounter>0)
                JOptionPane.showMessageDialog(null, "Animal Added", "Animal Added", JOptionPane.INFORMATION_MESSAGE);

        }
    }
}
