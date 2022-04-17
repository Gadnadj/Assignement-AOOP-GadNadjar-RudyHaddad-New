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
    public static int counter = 0;


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
    
    
    /**
     * confirmation button
     */
    JButton bConfirmation;

    /**
     * Constructor of addanimaldialog
     */
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

    /**
     * #
     * @return Animal
     */
    public Animal addAnimal()
    {
        Animal animal = null;
        if (counter < 10) {
            if (name.equals("Lion"))
            {
                Lion lion = new Lion(size, hSpeed, vSpeed, color);
                lion.setWeight(size * 0.8);
                ZooPanel.data.add(counter, lion);
                ZooPanel.dataTable[counter][0] = name;
                ZooPanel.dataTable[counter][1] = color;
                ZooPanel.dataTable[counter][2] = lion.getWeight();
                ZooPanel.dataTable[counter][3] = hSpeed;
                ZooPanel.dataTable[counter][4] = vSpeed;
                ZooPanel.dataTable[counter][5] = lion.getEatCount();

            }

            if (name.equals("Bear"))
            {
                Bear bear = new Bear(size, hSpeed, vSpeed, color);
                bear.setWeight(size * 1.5);
                ZooPanel.data.add(counter, bear);
                ZooPanel.dataTable[counter][0] = name;
                ZooPanel.dataTable[counter][1] = color;
                ZooPanel.dataTable[counter][2] = bear.getWeight();
                ZooPanel.dataTable[counter][3] = hSpeed;
                ZooPanel.dataTable[counter][4] = vSpeed;
                ZooPanel.dataTable[counter][5] = bear.getEatCount();

            }

            if (name.equals("Elephant"))
            {
                Elephant elephant = new Elephant(size, hSpeed, vSpeed, color);
                elephant.setWeight(size * 10);
                ZooPanel.data.add(counter, elephant);
                ZooPanel.dataTable[counter][0] = name;
                ZooPanel.dataTable[counter][1] = color;
                ZooPanel.dataTable[counter][2] = elephant.getWeight();
                ZooPanel.dataTable[counter][3] = hSpeed;
                ZooPanel.dataTable[counter][4] = vSpeed;
                ZooPanel.dataTable[counter][5] = elephant.getEatCount();

            }

            if (name.equals("Giraffe"))
            {

                Giraffe giraffe = new Giraffe(size, hSpeed, vSpeed, color);
                giraffe.setWeight(size * 2.2);
                ZooPanel.data.add(counter, giraffe);
                ZooPanel.dataTable[counter][0] = name;
                ZooPanel.dataTable[counter][1] = color;
                ZooPanel.dataTable[counter][2] = giraffe.getWeight();
                ZooPanel.dataTable[counter][3] = hSpeed;
                ZooPanel.dataTable[counter][4] = vSpeed;
                ZooPanel.dataTable[counter][5] = giraffe.getEatCount();

            }

            if (name.equals("Turtle"))
            {
                Turtle turtle = new Turtle(size, hSpeed, vSpeed, color);
                turtle.setWeight(size * 0.5);
                ZooPanel.data.add(counter, turtle);
                ZooPanel.dataTable[counter][0] = name;
                ZooPanel.dataTable[counter][1] = color;
                ZooPanel.dataTable[counter][2] = turtle.getWeight();
                ZooPanel.dataTable[counter][3] = hSpeed;
                ZooPanel.dataTable[counter][4] = vSpeed;
                ZooPanel.dataTable[counter][5] = turtle.getEatCount();
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
            counter++;
            dispose();
            if(counter>0)
                JOptionPane.showMessageDialog(null, "Animal Added", "Animal Added", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
