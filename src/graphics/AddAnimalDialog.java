package graphics;
import animals.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** class that creates a frame, containing all the information on the creation of animals
 * @param <counter> : number of animals
 *  class that creates a frame, containing all the information on the creation of animals
 * @author Gad Nadjar
 * @see JDialog
 */
public class AddAnimalDialog<counter> extends JDialog implements ActionListener
{
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

    /**
     * constructor that creates a Dialog and displays a page that allows us to select the animals to add to the table
     * @param pan : panel of ZooPanel
     */
    public AddAnimalDialog(ZooPanel pan)
    {
        this.setTitle("Add Animal");
        this.setSize(new Dimension(600, 100));
        this.setLayout(new GridLayout(2, 6));
        this.setVisible(true);
        String[] animals = {"Lion", "Bear", "Elephant", "Giraffe", "Turtle"};
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
     * this class create animals
     */
    public void addAnimal()
    {
        if (animalcounter < 10)
        {
            if (name.equals("Lion"))
                ZooPanel.data.add(new Lion(name, size, hSpeed, vSpeed, color, newPan));

            if (name.equals("Bear"))
                ZooPanel.data.add(new Bear(name, size, hSpeed, vSpeed, color, newPan));

            if (name.equals("Elephant"))
                ZooPanel.data.add(new Elephant(name, size, hSpeed, vSpeed, color, newPan));

            if (name.equals("Giraffe"))
                ZooPanel.data.add(new Giraffe(name, size, hSpeed, vSpeed, color, newPan));

            if (name.equals("Turtle"))
                ZooPanel.data.add(new Turtle(name, size, hSpeed, vSpeed, color, newPan));
        }
    }


    /**
     * @param e : e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == cselectAnimal)
            name = (String) cselectAnimal.getSelectedItem();

        if (e.getSource() == cselectSize)
            size =  (int)cselectSize.getSelectedItem();

        if (e.getSource() == cselectHorSpeed)
            hSpeed = (int) cselectHorSpeed.getSelectedItem();

        if (e.getSource() == cselectVerSpeed)
            vSpeed = (int) cselectVerSpeed.getSelectedItem();

        if (e.getSource() == cselectColor)
            color = (String) cselectColor.getSelectedItem();

        if (e.getSource() == bConfirmation)
        {
            if(name == null || size == 0 || hSpeed == 0 || vSpeed == 0 || color == null)
                JOptionPane.showMessageDialog(null, "Select All Characters", "Selected All Characters", JOptionPane.ERROR_MESSAGE);
            else
            {
                addAnimal();
                ZooPanel.data.get(animalcounter).start();
                animalcounter++;
                dispose();
                if (animalcounter > 0)
                    JOptionPane.showMessageDialog(null, "Animal Added", "Animal Added", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
