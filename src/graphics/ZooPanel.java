package graphics;



import animals.*;
import food.EFoodType;
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
     * button sleep
     */
    private JButton sleep;

    /**
     * button wakeUp
     */
    private JButton wakeUp;

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

    private EFoodType Food;

    private Thread controller;

    private JScrollPane scrollPane;
    private boolean isTableVisible;


    public ZooPanel()
    {

        panelControler = new JPanel(new FlowLayout());

        Food = EFoodType.NOTFOOD;
        addAnimal = new JButton("Add Animal");
        sleep = new JButton("sleep");
        wakeUp = new JButton("Wake up");
        //moveAnimal = new JButton("Move Animal");
        clear = new JButton("Clear");
        food = new JButton("Food");
        info = new JButton("Info");
        exit = new JButton("exit");

        isTableVisible = false;

        addAnimal.addActionListener(this);
        //moveAnimal.addActionListener(this);
        sleep.addActionListener(this);
        wakeUp.addActionListener(this);
        clear.addActionListener(this);
        food.addActionListener(this);
        info.addActionListener(this);
        exit.addActionListener(this);


        panelControler.add(addAnimal);
        panelControler.add(sleep);
        panelControler.add(wakeUp);
        //panelControler.add(moveAnimal);
        panelControler.add(clear);
        panelControler.add(food);
        panelControler.add(info);
        panelControler.add(exit);



        panelControler.setBackground(Color.PINK);
        this.setLayout(new BorderLayout());
        this.add(panelControler, BorderLayout.PAGE_END);

        controller = new Thread(this);
        controller.start();



    }




    public void info()
    {
        if(isTableVisible == false)
        {
            int i=0;
            int sz = ZooPanel.data.size();

            String[] columnNames = {"Animal","Color","Weight","Hor. speed","Ver. speed","Eat counter"};
            String [][] data = new String[sz+1][columnNames.length];
            for(Animal an : ZooPanel.data)
            {
                data[i][0] = an.getName();
                data[i][1] = an.getColor();
                data[i][2] = new Integer((int)(an.getWeight())).toString();
                data[i][3] = new Integer(an.getHorSpeed()).toString();
                data[i][4] = new Integer(an.getVerSpeed()).toString();
                data[i][5] = new Integer(an.getEatCount()).toString();
                i++;
            }
            data[i][0] = "Total";
            data[i][5] = new Integer(totalEatCount).toString();

            JTable table = new JTable(data, columnNames);
            scrollPane = new JScrollPane(table);
            scrollPane.setSize(450,table.getRowHeight()*(sz+1)+24);
            add( scrollPane, BorderLayout.CENTER );
            isTableVisible = true;
        }
        else
        {
            isTableVisible = false;
        }
        scrollPane.setVisible(isTableVisible);
        repaint();
    }









    /**
     * Function Thread
     */
    @Override
    public void run() {
        while(true) {
            if(isChange())
                repaint();

            boolean prey_eaten = false;
            synchronized(this) {
                for(Animal predator : ZooPanel.data) {
                    for(Animal prey : ZooPanel.data) {
                        if(predator != prey && predator.getDiet().canEat(prey.getFoodtype()) && predator.getWeight()/prey.getWeight() >= 2 &&
                                (Math.abs(predator.getLocation().getX() - prey.getLocation().getX()) < prey.getSize()) &&
                                (Math.abs(predator.getLocation().getY() - prey.getLocation().getY()) < prey.getSize())) {
                            preyEating(predator,prey);
                            System.out.print("The "+predator+" cought up the "+prey+" ==> ");
                            prey.interrupt();
                            ZooPanel.data.remove(prey);
                            repaint();
                            //JOptionPane.showMessageDialog(frame, ""+prey+" killed by "+predator);
                            prey_eaten = true;
                            break;
                        }
                    }
                    if(prey_eaten)
                        break;
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    /**
     * @param e : e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == addAnimal)
        {
            if (AddAnimalDialog.animalcounter < 10)
            {
                new AddAnimalDialog(this);

            } else
                JOptionPane.showMessageDialog(null, "There is no more places in the zoo", "Can't add animal", JOptionPane.ERROR_MESSAGE);
        }

        if (e.getSource() == moveAnimal)
        {
            if (ZooPanel.data.size() == 0)
                JOptionPane.showMessageDialog(null, "There's no animals", "Error", JOptionPane.ERROR_MESSAGE);
            else
            {
                window2 = new MoveAnimalDialog(this);
            }


        }

        if (e.getSource() == clear)
        {
            synchronized (this) {
                if (this.data.size() == 0) {
                    JOptionPane.showMessageDialog(null, "There's no animals", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < ZooPanel.data.size(); i++) {
                        ZooPanel.data.get(i).interrupt();
                    }
                    ZooPanel.data.clear();
                    meat = null;
                    plant = null;
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
        }

        if (e.getSource() == food)
        {
            synchronized (this) {
                String[] responses = {"Lettuce", "Cabbage", "Meat"};
                foods = JOptionPane.showOptionDialog(null,
                        "Please choose food",
                        "Food", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        responses,
                        0);
                System.out.println(foods);

                if (foods == 0) {
                    this.meat = null;
                    this.plant = new Lettuce(this);
                    this.plant.loadImages("Pictures/lettuce.png");
                    Food = EFoodType.VEGETABLE;
                }
                if (foods == 1) {
                    this.meat = null;

                    this.plant = new Cabbage(this);
                    this.plant.loadImages("Pictures/cabbage.png");
                    Food = EFoodType.VEGETABLE;
                }

                if (foods == 2) {
                    this.plant = null;
                    this.meat = new Meat(this);
                    this.meat.loadImages("Pictures/meat.gif");
                    Food = EFoodType.MEAT;
                }
                repaint();
            }
        }

        if (e.getSource() == info)
        {
        info();
//            String[] column = {"Animal", "Color", "Weight", "Horizontal speed", "Vertical speed", "Eat Counter"};
//            tableAnimal = new JTable(dataTable, column);
//            JTableCreation window = new JTableCreation(tableAnimal);
        }

        if (e.getSource() == exit)
        {
            for(int i = 0 ; i < ZooPanel.data.size() ; i++)
            {
                ZooPanel.data.get(i).interrupt();
            }
            System.exit(1);
        }

        if (e.getSource() == sleep)
        {
            stop();
        }

        if (e.getSource() == wakeUp)
        {
            start();
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
     *
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        synchronized (this)
        {
        if (data.size() != 0)
        {
            for (int i = 0; i < data.size(); i++) {
                ZooPanel.data.get(i).drawObject(g);
            }
        }
        }
        if(plant!= null)
            plant.drawObject(g);
        if(meat != null)
            meat.drawObject(g);
    }

    synchronized public void start()
    {
        for(int i = 0 ; i < data.size() ; i++)
            data.get(i).setResumed();
    }

    synchronized public EFoodType checkFood()
    {
        return Food;
    }

    synchronized public void stop()
    {
        for(int i = 0 ; i < data.size() ; i++)
            data.get(i).setSuspended();
    }

    synchronized public void eatFood(Animal an)
    {
        if (Food != EFoodType.NOTFOOD)
        {
            if (Food == EFoodType.VEGETABLE)
                plant = null;
            if (Food == EFoodType.MEAT)
                meat = null;
            Food = EFoodType.NOTFOOD;
            an.eatInc();
            totalEatCount++;
        }

    }



    synchronized public void preyEating(Animal predator, Animal prey)
    {
        predator.eatInc();
        totalEatCount -= (prey.getEatCount() - 1);
    }
}


