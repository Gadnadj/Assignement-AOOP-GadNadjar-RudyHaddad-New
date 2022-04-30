package graphics;



import animals.*;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;
import privateutil.Meat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private MoveAnimalDialog window2;

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
     * plant
     */
    private Plant plant = null;

    /**
     * meat
     */
    private Meat meat = null;

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
    protected static Object[][] dataTable = new Object[11][6];

    /**
     * type of food
     */
    private int foods;


    /**
     * Panel
     */
    private JPanel panelControler;

    /**
     * Counter of animal eaten
     */
    int totalEatCount = 0;

    /**
     * Constructor of ZooPanel
     */
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
    }

    /**
     * Function Thread
     */
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
            if (ZooPanel.data.size() == 0)
                JOptionPane.showMessageDialog(null, "There's no animals", "Error", JOptionPane.ERROR_MESSAGE);
            else
            {
                window2 = new MoveAnimalDialog(this);
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
                    dataTable = new Object[11][6];
                AddAnimalDialog.animalcounter = 0;
                JOptionPane.showMessageDialog(null, "All animals deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
                Lion.setLionCount();
                Bear.setBearCount();
                Elephant.setElephantCount();
                Giraffe.setGiraffeCount();
                Turtle.setTurtleCount();
                repaint();
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
                this.meat = null;
                this.plant = new Lettuce(this);
                this.plant.loadImages("Pictures/lettuce.png");
            }
            if(foods == 1)
            {
                this.meat = null;

                this.plant = new Cabbage(this);
                this.plant.loadImages("Pictures/cabbage.png");
            }

            if(foods == 2)
            {
                this.plant = null;
                this.meat = new Meat(this);
                this.meat.loadImages("Pictures/meat.gif");
            }
            repaint();
        }

        if (e.getSource() == info) {

            String[] column = {"Animal", "Color", "Weight", "Horizontal speed", "Vertical speed", "Eat Counter"};
            tableAnimal = new JTable(dataTable, column);
            JTableCreation window = new JTableCreation(tableAnimal);
        }

        if (e.getSource() == exit) {
            System.out.println("Bye, have a great day !");
            System.exit(1);
        }

    }


    /**
     *
     * @return true if the animal mooved0
     */
    public boolean isChange(){
        for (Animal animal : ZooPanel.data)
            if(animal.getChanges())
            {
                animal.setChanges(false);
                return true;
            }
        return false;
    }

    /**
     * Function Controler
     */
    public void manageZoo()
    {
        int counter2 = 0;
        if (isChange())
            repaint();
        totalEatCount = 0;
        for(Animal animal : ZooPanel.data)
        {
            if (plant != null)
            {
                if (animal.calcDistance(plant.getLocation()) <= animal.getEatDistance() && (animal.getDiet().canEat(plant.getFoodtype())))
                {
                    animal.eat(plant);
                    animal.setEatCount();
                    plant = null;
                    totalEatCount += 1;
                    ZooPanel.dataTable[counter2][5] = animal.getEatCount();
                    ZooPanel.dataTable[counter2][2] = animal.getWeight();
                    ZooPanel.dataTable[10][0] = "Total";
                    ZooPanel.dataTable[10][5] = totalEatCount;
                    JOptionPane.showMessageDialog(null, "Eaten Plant", "Eat Plant", JOptionPane.INFORMATION_MESSAGE);
                    repaint();
                }
            }


            if(meat != null)
            {
                if(animal.calcDistance(meat.getLocation()) <= animal.getEatDistance() && (animal.getDiet().canEat(meat.getFoodtype())))
                {
                    animal.eat(meat);
                    animal.setEatCount();
                    meat = null;
                    for(int l = 0 ; l < ZooPanel.data.size() ; l++)
                        totalEatCount += ZooPanel.data.get(l).getEatCount();
                    ZooPanel.dataTable[counter2][5] = animal.getEatCount();
                    ZooPanel.dataTable[counter2][2] = animal.getWeight();
                    ZooPanel.dataTable[10][0] = "Total";
                    ZooPanel.dataTable[10][5] = totalEatCount;
                    JOptionPane.showMessageDialog(null, "Eaten Meat", "Eat Meat", JOptionPane.INFORMATION_MESSAGE);
                    repaint();
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
                        JOptionPane.showMessageDialog(null, "Eaten Animal", "Eat Animal", JOptionPane.INFORMATION_MESSAGE);

                        ZooPanel.data.get(i).eat(ZooPanel.data.get(j));
                        ZooPanel.data.remove(j);
                        AddAnimalDialog.animalcounter -= 1;
                        if(i == ZooPanel.data.size())
                            i--;
                        ZooPanel.dataTable[i][5] = ZooPanel.data.get(i).setEatCount();
                        repaint();
                        //totalEatCount += 1;
                        for(int l = 0 ; l < ZooPanel.data.size() ; l++)
                            totalEatCount += ZooPanel.data.get(l).getEatCount();
//                        for (int l = 0; l < dataTable.length; l++)
                            dataTable = new Object[11][6];
                        for(int k = 0 ; k < ZooPanel.data.size() ; k++)
                        {
                            ZooPanel.dataTable[k][0] = ZooPanel.data.get(k).getName();
                            ZooPanel.dataTable[k][1] = ZooPanel.data.get(k).getColor();
                            ZooPanel.dataTable[k][2] = ZooPanel.data.get(k).getWeight();
                            ZooPanel.dataTable[k][3] = ZooPanel.data.get(k).getHorSpeed();
                            ZooPanel.dataTable[k][4] = ZooPanel.data.get(k).getVerSpeed();
                            ZooPanel.dataTable[k][5] = ZooPanel.data.get(k).getEatCount();
                        }
                        ZooPanel.dataTable[10][0] = "Total";
                        ZooPanel.dataTable[10][5] = totalEatCount;
                        return;
                    }
                }
            }
        }

    }

    /**
     *
     * @param g the <code>Graphics</code> object to protect
     */
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
        if(meat != null)
            meat.drawObject(g);
    }
}


