package graphics;
import animals.*;
import food.EFoodType;
import food.IEdible;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;
import privateutil.Meat;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * this class is a child class of JPanel and implements the Runnable and ActionListener interfaces. it displays on
 * the frame all the buttons (add animal, sleep, wkkeup, clear, food, info) and opens
 * new windows after each button is activated
 * @author Gad Nadjar
 * @see JPanel
 */

public class ZooPanel extends JPanel implements Runnable, ActionListener
{
    private JButton addAnimal;
    private JButton sleep;
    private JButton wakeUp;
    private JButton clear;
    private JButton food;
    private JButton info;
    private Plant plant = null;
    private Meat meat = null;
    private JButton exit;
    protected static ArrayList<Animal> data = new ArrayList<>(10);
    protected static Object[][] dataTable = new Object[11][6];
    private int foods;
    private JPanel panelControler;
    int totalEatCount = 0;
    private EFoodType Food;
    private Thread controller;
    private JScrollPane scrollPane;
    private boolean isTableVisible;
    private BufferedImage img;
    boolean bgr;
    private IEdible food1;

    /**
     * Constructor of ZooPanel
     */
    public ZooPanel()
    {
        isTableVisible = false;
        controller = new Thread(this);
        controller.start();

        setBackground(new Color(255,255,255));

        panelControler = new JPanel(new GridLayout(1,7,0,0));
        panelControler.setBackground(new Color(255,51,153));

        Food = EFoodType.NOTFOOD;
        addAnimal = new JButton("Add Animal");
        sleep = new JButton("sleep");
        wakeUp = new JButton("Wake up");
        clear = new JButton("Clear");
        food = new JButton("Food");
        info = new JButton("Info");
        exit = new JButton("exit");

        addAnimal.addActionListener(this);
        sleep.addActionListener(this);
        wakeUp.addActionListener(this);
        clear.addActionListener(this);
        food.addActionListener(this);
        info.addActionListener(this);
        exit.addActionListener(this);

        panelControler.add(addAnimal);
        panelControler.add(sleep);
        panelControler.add(wakeUp);
        panelControler.add(clear);
        panelControler.add(food);
        panelControler.add(info);
        panelControler.add(exit);

        panelControler.setFocusable(true);
        setLayout(new BorderLayout());
        add("South", panelControler);

        img = null;
        bgr = false;

        try { img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "savanna.png")); }
        catch (IOException e) { System.out.println("Cannot load background"); }
    }


    /**
     * activation of thread
     */
    @Override
    public void run()
    {
        while(true)
        {
            if(isChange())
                repaint();
            boolean prey_eaten = false;
            synchronized(this) {
                for(Animal predator : ZooPanel.data)
                {
                    for(Animal prey : ZooPanel.data)
                    {
                        if(predator != prey && predator.getDiet().canEat(prey.getFoodtype()) && predator.getWeight()/prey.getWeight() >= 2 &&
                                (Math.abs(predator.getLocation().getX() - prey.getLocation().getX()) < prey.getSize()) &&
                                (Math.abs(predator.getLocation().getY() - prey.getLocation().getY()) < prey.getSize()))
                        {
                            preyEating(predator,prey);
                            prey.interrupt();
                            ZooPanel.data.remove(prey);
                            predator.eat(prey);
                            AddAnimalDialog.animalcounter--;
                            repaint();
                            prey_eaten = true;
                            break;
                        }
                    }
                    if(prey_eaten)
                        break;
                }
            }
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
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
                new AddAnimalDialog(this);
            else
                JOptionPane.showMessageDialog(null, "There is no more places in the zoo", "Can't add animal", JOptionPane.ERROR_MESSAGE);
        }

        if (e.getSource() == clear)
        {
            synchronized (this)
            {
                if (data.size() == 0)
                    JOptionPane.showMessageDialog(null, "There's no animals", "Error", JOptionPane.ERROR_MESSAGE);
                else
                {
                    for (int i = 0; i < ZooPanel.data.size(); i++)
                        ZooPanel.data.get(i).interrupt();
                    ZooPanel.data.clear();
                    meat = null;
                    plant = null;
                    for (int i = 0; i < dataTable.length; i++)
                        dataTable = new Object[11][6];
                    AddAnimalDialog.animalcounter = 0;
                    totalEatCount = 0;
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
                String[] responses = {"Lettuce", "Cabbage", "Meat"};
                foods = JOptionPane.showOptionDialog(null,
                        "Please choose food",
                        "Food", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        responses,
                        0);
                System.out.println(foods);

                if (foods == 0)
                {
                    this.meat = null;
                    this.plant = new Lettuce(this);
                    this.plant.loadImages(IDrawable.PICTURE_PATH + "lettuce.png");
                    Food = EFoodType.VEGETABLE;
                    food1 = plant;
                }

                if (foods == 1)
                {
                    this.meat = null;
                    this.plant = new Cabbage(this);
                    this.plant.loadImages(IDrawable.PICTURE_PATH + "cabbage.png");
                    Food = EFoodType.VEGETABLE;
                    food1 = plant;
                }

                if (foods == 2)
                {
                    this.plant = null;
                    this.meat = new Meat(this);
                    this.meat.loadImages(IDrawable.PICTURE_PATH + "meat.gif");
                    Food = EFoodType.MEAT;
                    food1 = meat;
                }
                repaint();
        }

        if (e.getSource() == info)
        {
            if(!isTableVisible)
            {
                int i=0;
                int size2 = ZooPanel.data.size();

                String[] columnNames = {"Animal","Color","Weight","Hor. speed","Ver. speed","Eat counter"};
                String [][] data = new String[size2+1][columnNames.length];
                for(Animal an : ZooPanel.data)
                {
                    data[i][0] = an.getName();
                    data[i][1] = an.getColor();
                    data[i][2] = Integer.toString((int) (an.getWeight()));
                    data[i][3] = Integer.toString(an.getHorSpeed());
                    data[i][4] = Integer.toString(an.getVerSpeed());
                    data[i][5] = Integer.toString(an.getEatCount());
                    i++;
                }
                data[i][0] = "Total";
                data[i][5] = Integer.toString(totalEatCount);

                JTable table = new JTable(data, columnNames);
                scrollPane = new JScrollPane(table);
                scrollPane.setSize(450,table.getRowHeight()*(size2+1)+24);
                add(scrollPane, BorderLayout.CENTER);
                isTableVisible = true;
            }
            else
                isTableVisible = false;
            scrollPane.setVisible(isTableVisible);
            repaint();
        }

        if (e.getSource() == exit)
        {
            for(int i = 0 ; i < ZooPanel.data.size() ; i++)
                ZooPanel.data.get(i).interrupt();
            System.exit(1);
        }

        if (e.getSource() == sleep)
            stop();

        if (e.getSource() == wakeUp)
            start();
    }


    /**
     * @return true if the animal mooved
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
     * set background of the frame
     * @param num
     */
    public void setBackgr(int num)
    {
        switch(num)
        {
            case 0:
                bgr = false;
                break;
            case 1:
                bgr = false;
                break;
            default:
                bgr = true;
        }
        repaint();
    }


    /**
     * @param g : g
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (bgr && (img != null))
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        synchronized (this)
        {
        if (data.size() != 0)
        {
            for (int i = 0; i < data.size(); i++)
                ZooPanel.data.get(i).drawObject(g);
        }
        }
        if(plant!= null)
            plant.drawObject(g);
        if(meat != null)
            meat.drawObject(g);
    }


    /**
     * start thread
     */
    synchronized public void start()
    {
        for(int i = 0 ; i < data.size() ; i++)
            data.get(i).setResumed();
    }


    /**
     * check which food is it
     * @return ERoodType : type of food
     */
    synchronized public EFoodType checkFood()
    {
        return Food;
    }


    /**
     * stop thread
     */
    synchronized public void stop()
    {
        for(int i = 0 ; i < data.size() ; i++)
            data.get(i).setSuspended();
    }


    /**
     *
     * @param animal : animal
     */
    synchronized public void eatFood(Animal animal)
    {
        if (Food != EFoodType.NOTFOOD)
        {
            if (Food == EFoodType.VEGETABLE)
                plant = null;
            if (Food == EFoodType.MEAT)
                meat = null;
            animal.setWeight(animal.getWeight() + animal.getDiet().eat(animal, food1));
            Food = EFoodType.NOTFOOD;
            animal.eatInc();
            totalEatCount++;
        }
    }


    /**
     * if the prey is eated, sub the number of animal eaten of the prey
     * @param predator
     * @param prey
     */
    synchronized public void preyEating(Animal predator, Animal prey)
    {
        predator.eatInc();
        totalEatCount -= (prey.getEatCount() - 1);
    }
}


