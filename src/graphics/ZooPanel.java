package graphics;



import animals.Animal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * this class is a child class of JPanel and implements the Runnable and ActionListener interfaces. it displays on
 * the frame all the buttons (add animal, move animal, clear, food, info) and opens
 * new windows after each button is activated
 * @author Gad Nadjar
 * @see JPanel
 */

public class ZooPanel extends JPanel implements Runnable, ActionListener {

    /**
     * Jtable of animal
     */
    private JTable tableAnimal;

    /**
     * instance of addAnimalDialog
     */
    private AddAnimalDialog a;

    /**
     * instance of NewWindow2
     */
    private NewWindow2 window2;

    /**
     * button addanimal
     */
    private JButton addAnimal;

    /**
     * button moveanimal
     */
    JButton moveAnimal;

    /**
     * button clear
     */
    JButton clear;

    /**
     * button food
     */
    JButton food;

    /**
     * button info
     */
    JButton info;

    /**
     * button exit
     */
    JButton exit;



    /**
     * array of animal
     */
    protected static ArrayList<Animal> data = new ArrayList<>(10);

    /**
     * Object array
     */
    protected static Object[][] dataTable = new Object[10][6];
    /**
     * type of food
     */
    private int foods;

    /**
     * constructor
     */
    public ZooPanel() {
        this.setBackground(Color.PINK);
        addAnimal = new JButton("Add Animal");
        addAnimal.addActionListener(this);
        moveAnimal = new JButton("Move Animal");
        moveAnimal.addActionListener(this);
        clear = new JButton("Clear");
        clear.addActionListener(this);
        food = new JButton("Food");
        food.addActionListener(this);
        info = new JButton("Info");
        info.addActionListener(this);
        exit = new JButton("exit");
        exit.addActionListener(this);
        this.add(addAnimal);
        this.add(moveAnimal);
        this.add(clear);
        this.add(food);
        this.add(info);
        this.add(exit);


    }


    @Override
    public void run() {

    }

    /**
     *
     * @param e : e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addAnimal) {
            if (AddAnimalDialog.counter < 10)
                a = new AddAnimalDialog();
            else
                JOptionPane.showMessageDialog(null, "There is no more places in the zoo", "Can't add animal", JOptionPane.ERROR_MESSAGE);
        }

        if (e.getSource() == moveAnimal) {

            if (ZooPanel.data.size() == 0)
                JOptionPane.showMessageDialog(null, "There's no animals", "Error", JOptionPane.ERROR_MESSAGE);
            else
                window2 = new NewWindow2();
        }

        if (e.getSource() == clear) {
            if (this.data.size() == 0) {
                JOptionPane.showMessageDialog(null, "There's no animals", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                for (int i = 0; i < data.size(); i++)
                    this.data = new ArrayList<Animal>();
                for (int i = 0; i < dataTable.length; i++)
                    dataTable = new Object[10][6];
                AddAnimalDialog.counter = 0;
                JOptionPane.showMessageDialog(null, "All animals deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
            }

        }

        if (e.getSource() == food)
        {
            String[] responses = {"Lettuce", "Cabbage", "Meat"};
            foods = JOptionPane.showOptionDialog(null,
                    "Please choose food",
                    "Food", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    responses,
                    0);
            System.out.println(responses[foods]);


        }
            if (e.getSource() == info) {

                String[] column = {"Animal", "Color", "Weight", "Horizontal speed", "Vertical speed", "Eat Counter"};
                tableAnimal = new JTable(dataTable, column);
                NewWindow window = new NewWindow(tableAnimal);

            }

            if (e.getSource() == exit)
            {
                System.out.println("Bye, have a great day !");
                System.exit(1);
            }
            //String[]animals = {a.getName1(), a.getColors(), "a.gethSpeed1()", "a.gethSpeed1()", "AddAnimalDialog.counter"};
            //data[AddAnimalDialog.counter][0] = animals;
        }

    }
