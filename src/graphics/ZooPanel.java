package graphics;



import animals.Animal;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;

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

    private Plant plant = null;

    /**
     * button exit
     */
    JButton exit;

    /**
     *
     */


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


    private JPanel panelControler;

    /**
     * constructor
     */
    //private static int counter = 0;

    private ZooFrame frame2;

    public ZooPanel()
    {

        panelControler = new JPanel(new FlowLayout());


        addAnimal = new JButton("Add Animal");
        moveAnimal = new JButton("Move Animal");
        clear = new JButton("Clear");
        food = new JButton("Food");
        info = new JButton("Info");
        exit = new JButton("exit");



        addAnimal.addActionListener(this);
        moveAnimal.addActionListener(this);
        clear.addActionListener(this);
        food.addActionListener(this);
        info.addActionListener(this);
        exit.addActionListener(this);


        panelControler.add(addAnimal);
        panelControler.add(moveAnimal);
        panelControler.add(clear);
        panelControler.add(food);
        panelControler.add(info);
        panelControler.add(exit);


        panelControler.setBackground(Color.PINK);
        this.setLayout(new BorderLayout());
        this.add(panelControler, BorderLayout.PAGE_END);
        manageZoo();














//        this.setSize(800, 600);
//        this.setBackground(Color.PINK);
//
//
//        addAnimal = new JButton("Add Animal");
//        addAnimal.addActionListener(this);
//        moveAnimal = new JButton("Move Animal");
//        moveAnimal.addActionListener(this);
//        clear = new JButton("Clear");
//        clear.addActionListener(this);
//        food = new JButton("Food");
//        food.addActionListener(this);
//        info = new JButton("Info");
//        info.addActionListener(this);
//        exit = new JButton("exit");
//        exit.addActionListener(this);
//        this.add(addAnimal);
//        this.add(moveAnimal);
//        this.add(clear);
//        this.add(food);
//        this.add(info);
//        this.add(exit);



    }


    @Override
    public void run() {

    }

    /**
     * @param e : e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addAnimal)
        {
            if (AddAnimalDialog.animalcounter < 10) {
                new AddAnimalDialog(this);
                manageZoo();
            } else
                JOptionPane.showMessageDialog(null, "There is no more places in the zoo", "Can't add animal", JOptionPane.ERROR_MESSAGE);
        }

        if (e.getSource() == moveAnimal) {
//            for (int i = 0; i < ZooPanel.data.size(); i++)
//                ZooPanel.data.get(i).setChanges(false);
            if (ZooPanel.data.size() == 0)
                JOptionPane.showMessageDialog(null, "There's no animals", "Error", JOptionPane.ERROR_MESSAGE);
            else
            {
                window2 = new NewWindow2(this);
//                manageZoo();
            }


        }

        if (e.getSource() == clear) {
            if (this.data.size() == 0) {
                JOptionPane.showMessageDialog(null, "There's no animals", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ZooPanel.data.clear();
//                for (int i = 0; i < data.size(); i++)
//                    this.data = new ArrayList<Animal>();
                for (int i = 0; i < dataTable.length; i++)
                    dataTable = new Object[10][6];
                AddAnimalDialog.animalcounter = 0;
                JOptionPane.showMessageDialog(null, "All animals deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
            }

        }

        if (e.getSource() == food) {
            String[] responses = {"Lettuce", "Cabbage", "Meat"};
            foods = JOptionPane.showOptionDialog(null,
                    "Please choose food",
                    "Food", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    responses,
                    0);
            System.out.println(foods);

            if(foods == 0)
            {
                this.plant = new Lettuce(this);
                this.plant.loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/lettuce.png");
            }
            if(foods == 1)
            {
                this.plant = new Cabbage(this);
                this.plant.loadImages("/Users/nadjar/IdeaProjects/Assignement-AOOP-GadNadjar-RudyHaddad-New/Pictures/cabbage.png");
            }

            if(foods == 2)
            {

            }

            repaint();
        }

        if (e.getSource() == info) {

            String[] column = {"Animal", "Color", "Weight", "Horizontal speed", "Vertical speed", "Eat Counter"};
            tableAnimal = new JTable(dataTable, column);
            NewWindow window = new NewWindow(tableAnimal);
        }

        if (e.getSource() == exit) {
            System.out.println("Bye, have a great day !");
            System.exit(1);
        }
        //String[]animals = {a.getName1(), a.getColors(), "a.gethSpeed1()", "a.gethSpeed1()", "AddAnimalDialog.counter"};
        //data[AddAnimalDialog.counter][0] = animals;
    }

    public boolean isChange(){
        for (Animal animal : ZooPanel.data)
            if(animal.getChanges())
            {
                animal.setChanges(false);
                return true;
            }
        return false;
    }

    public void manageZoo()
    {
        int counter2 = 0;
        if (isChange())
            repaint();

        for(Animal animal : ZooPanel.data)
        {
            //System.out.println(animal.calcDistance(plant.getLocation()));
            if (plant != null)
            {
                if (animal.calcDistance(plant.getLocation()) <= animal.getEatDistance() && (animal.getDiet().canEat(plant.getFoodtype())))
                {
                    animal.eat(plant);
                    animal.setEatCount();
                    plant = null;
                    ZooPanel.dataTable[counter2][5] = animal.getEatCount();
                    ZooPanel.dataTable[counter2][2] = animal.getWeight();
                }
            }
            counter2++;
        }
        for(int i = 0 ; i < ZooPanel.data.size() ; i++)
        {
            for(int j = 0 ; j < ZooPanel.data.size() ; j++)
            {
                if(ZooPanel.data.get(i).equals(ZooPanel.data.get(j)))
                    continue;
                else
                {
                    if(ZooPanel.data.get(i).getDiet().canEat(ZooPanel.data.get(j).getFoodtype()) && ZooPanel.data.get(i).getWeight()
                            > ZooPanel.data.get(j).getWeight() * 2 && ZooPanel.data.get(i).calcDistance(ZooPanel.data.get(j).getLocation()) < ZooPanel.data.get(j).getSize())
                    {
                        ZooPanel.data.get(i).eat(ZooPanel.data.get(j));
                        ZooPanel.data.remove(j);
                        AddAnimalDialog.animalcounter =- 1;
                        repaint();
                        for(int k = 0 ; k < ZooPanel.data.size() ; k++)
                        {
                            ZooPanel.dataTable[k][0] = ZooPanel.data.get(k).getClass().getSimpleName();
                            ZooPanel.dataTable[k][1] = ZooPanel.data.get(k).getColor();
                            ZooPanel.dataTable[k][2] = ZooPanel.data.get(k).getWeight();
                            ZooPanel.dataTable[k][3] = ZooPanel.data.get(k).getHorSpeed();
                            ZooPanel.dataTable[k][4] = ZooPanel.data.get(k).getVerSpeed();
                            ZooPanel.dataTable[k][5] = ZooPanel.data.get(k).getEatCount();
                        }

                        return;
                    }
                }
            }
        }

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (data.size() != 0)
        {
            for(int i = 0 ; i < data.size() ; i++)
            {
                ZooPanel.data.get(i).drawObject(g);
            }
        }
        if(plant!= null)
            plant.drawObject(g);
    }
}


