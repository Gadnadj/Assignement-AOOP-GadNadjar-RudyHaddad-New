package graphics;
import animals.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;





/** class that creates a frame, containing all the information on the creation of animals
 * @param <counter> : number of animals
 *  class that creates a frame, containing all the information on the creation of animals
 * @author Gad Nadjar
 * @see JDialog
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




    /**
     * confirmation button
     */
    JButton bConfirmation;


    /**
     * constructor that creates a Dialog and displays a page that allows us to select the animals to add to the table
     * @param pan : panel of ZooPanel
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

        newPan = pan;
        //cselectAnimal.addItem(animals);

        for (int i = 50; i <= 300; i++) {
            cselectSize.addItem(i);
        }
        cselectSize.setSelectedIndex(-1);


        for (int i = 1; i <= 10; i++) {
            cselectHorSpeed.addItem(i);
        }
        cselectHorSpeed.setSelectedIndex(-1);


        for (int i = 1; i <= 10; i++) {
            cselectVerSpeed.addItem(i);
        }
        cselectVerSpeed.setSelectedIndex(-1);



        cselectAnimal.addActionListener(this);
        cselectSize.addActionListener(this);
        cselectHorSpeed.addActionListener(this);
        cselectVerSpeed.addActionListener(this);
        cselectColor.addActionListener(this);
        bConfirmation.addActionListener(this);



    }

    /**
     * this class create animals, posters in the JTable and in the zoo
     * @return Animal
     */
    public Animal addAnimal()
    {
        Animal animal = null;
        if (animalcounter < 10) {
            if (name.equals("Lion"))
            {
                ZooPanel.data.add(new Lion(name, size, hSpeed, vSpeed, color, newPan));
                ZooPanel.dataTable[animalcounter][0] = ZooPanel.data.get(animalcounter).getName();
                ZooPanel.dataTable[animalcounter][1] = color;
                ZooPanel.dataTable[animalcounter][2] = ZooPanel.data.get(animalcounter).getWeight();
                ZooPanel.dataTable[animalcounter][3] = hSpeed;
                ZooPanel.dataTable[animalcounter][4] = vSpeed;
                ZooPanel.dataTable[animalcounter][5] = ZooPanel.data.get(animalcounter).getEatCount();
                if(color.equals("NATURAL"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "lio_n_1.png");
                if(color.equals("BLUE"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "lio_b_1.png");
                if(color.equals("RED"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "lio_r_1.png");

            }

            if (name.equals("Bear"))
            {
                ZooPanel.data.add(new Bear(name, size, hSpeed, vSpeed, color, newPan));
                ZooPanel.dataTable[animalcounter][0] = ZooPanel.data.get(animalcounter).getName();
                ZooPanel.dataTable[animalcounter][1] = color;
                ZooPanel.dataTable[animalcounter][2] = ZooPanel.data.get(animalcounter).getWeight();
                ZooPanel.dataTable[animalcounter][3] = hSpeed;
                ZooPanel.dataTable[animalcounter][4] = vSpeed;
                ZooPanel.dataTable[animalcounter][5] = ZooPanel.data.get(animalcounter).getEatCount();
                if(color.equals("NATURAL"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "bea_n_1.png");
                if(color.equals("BLUE"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "bea_b_1.png");
                if(color.equals("RED"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "bea_r_1.png");

            }

            if (name.equals("Elephant"))
            {
                ZooPanel.data.add(new Elephant(name, size, hSpeed, vSpeed, color, newPan));
                ZooPanel.dataTable[animalcounter][0] = ZooPanel.data.get(animalcounter).getName();
                ZooPanel.dataTable[animalcounter][1] = color;
                ZooPanel.dataTable[animalcounter][2] = ZooPanel.data.get(animalcounter).getWeight();
                ZooPanel.dataTable[animalcounter][3] = hSpeed;
                ZooPanel.dataTable[animalcounter][4] = vSpeed;
                ZooPanel.dataTable[animalcounter][5] = ZooPanel.data.get(animalcounter).getEatCount();
                if(color.equals("NATURAL"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "elf_n_1.png");
                if(color.equals("BLUE"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "elf_b_1.png");
                if(color.equals("RED"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "elf_r_1.png");


            }

            if (name.equals("Giraffe"))
            {
                ZooPanel.data.add(new Giraffe(name, size, hSpeed, vSpeed, color, newPan));
                ZooPanel.dataTable[animalcounter][0] = ZooPanel.data.get(animalcounter).getName();
                ZooPanel.dataTable[animalcounter][1] = color;
                ZooPanel.dataTable[animalcounter][2] = ZooPanel.data.get(animalcounter).getWeight();
                ZooPanel.dataTable[animalcounter][3] = hSpeed;
                ZooPanel.dataTable[animalcounter][4] = vSpeed;
                ZooPanel.dataTable[animalcounter][5] = ZooPanel.data.get(animalcounter).getEatCount();
                if(color.equals("NATURAL"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "grf_n_1.png");
                if(color.equals("BLUE"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "grf_b_1.png");
                if(color.equals("RED"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "grf_r_1.png");

            }

            if (name.equals("Turtle"))
            {
                ZooPanel.data.add(new Turtle(name, size, hSpeed, vSpeed, color, newPan));
                ZooPanel.dataTable[animalcounter][0] = ZooPanel.data.get(animalcounter).getName();
                ZooPanel.dataTable[animalcounter][1] = color;
                ZooPanel.dataTable[animalcounter][2] = ZooPanel.data.get(animalcounter).getWeight();
                ZooPanel.dataTable[animalcounter][3] = hSpeed;
                ZooPanel.dataTable[animalcounter][4] = vSpeed;
                ZooPanel.dataTable[animalcounter][5] = ZooPanel.data.get(animalcounter).getEatCount();
                if(color.equals("NATURAL"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "trt_n_1.png");
                if(color.equals("BLUE"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "trt_b_1.png");
                if(color.equals("RED"))
                    ZooPanel.data.get(animalcounter).loadImages(IDrawable.PICTURE_PATH + "trt_r_1.png");
            }
        }

        return null;
    }

    /**
     *
     * @return int : size of the animal
     */
    public int getSize1()
    {
        return this.size;
    }

    /**
     *
     * @return String : name of the animal
     */
    public String getName1()
    {
        return this.name;
    }

    /**
     *
     * @return int : horizontal speed of the animal
     */
    public int gethSpeed1()
    {
        return this.hSpeed;
    }

    /**
     *
     * @return int : vertical speed of the animal
     */
    public int getvSpeed1()
    {
        return this.vSpeed;
    }

    /**
     *
     * @return String : color of the animal
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

            if(name == null || size == 0 || hSpeed == 0 || vSpeed == 0 || color == null)
                JOptionPane.showMessageDialog(null, "Selected All Characters", "Selected All Characters", JOptionPane.ERROR_MESSAGE);
            else
            {
                addAnimal();
                ZooPanel.dataTable[10][0] = "Total";
                this.newPan.manageZoo();
                animalcounter++;
                dispose();
                if (animalcounter > 0)
                    JOptionPane.showMessageDialog(null, "Animal Added", "Animal Added", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }
}
