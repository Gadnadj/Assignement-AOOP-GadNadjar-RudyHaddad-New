package graphics;
import animals.*;
import food.EFoodType;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import factory.AbstractZooFactory;
import factory.*;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * this class is a child class of JPanel and implements the Runnable and ActionListener interfaces. it displays on
 * the frame all the buttons (add animal, sleep, wkkeup, clear, food, info) and opens
 * new windows after each button is activated
 * @author Gad Nadjar
 * @see JPanel
 */
public class ZooPanel extends JPanel implements ActionListener
{
    private static final int MAX_ANIMAL_COUNTER  = 10;

    private JScrollPane scrollPane;
    private boolean isTableVisible;
    private Plant forFood = null;
    private EFoodType Food;
    private int totalEatCount;
    private BufferedImage img, img_m;
    private final String BACKGROUND_PATH = Animal.PICTURE_PATH+"savanna.jpg";
    private final String MEAT_PATH = Animal.PICTURE_PATH+"meat.gif";
    private ArrayList<Animal> animals;
    private boolean bgr;
    private Executor threadPool;
    private int factory=-1;
    private ZooObserver controller2;
    protected boolean duplicateFlag=false;
    private static ZooPanel instance = null;
    private ArrayList<MementoZoo> mementos;
    private JButton addAnimal;
    private JButton sleep;
    private JButton wakeUp;
    private JButton clear;
    private JButton food;
    private JButton info;
    private JButton Decorate;
    private JButton Duplicate;
    private JButton SaveState;
    private JButton RestoreState;
    private JButton exit;
    private JPanel panelControler;



    public ZooPanel()
    {
        threadPool = Executors.newFixedThreadPool (5);
        mementos=new ArrayList<MementoZoo>();
        Food = EFoodType.NOTFOOD;
        totalEatCount = 0;
        isTableVisible = false;
        controller2=new ZooObserver();
        animals = new ArrayList<Animal>();
        setBackground(new Color(255,255,255));
        panelControler = new JPanel(new GridLayout(2,7,0,0));
        panelControler.setBackground(new Color(255,51,153));
        Food = EFoodType.NOTFOOD;
        addAnimal = new JButton("Add Animal");
        sleep = new JButton("sleep");
        wakeUp = new JButton("Wake up");
        clear = new JButton("Clear");
        food = new JButton("Food");
        info = new JButton("Info");
        exit = new JButton("Exit");
        Decorate = new JButton("Decorate");
        Duplicate = new JButton("Duplicate");
        SaveState = new JButton("Save State");
        RestoreState = new JButton("Restore State");
        addAnimal.addActionListener(this);
        sleep.addActionListener(this);
        wakeUp.addActionListener(this);
        clear.addActionListener(this);
        food.addActionListener(this);
        info.addActionListener(this);
        exit.addActionListener(this);
        Decorate.addActionListener(this);
        Duplicate.addActionListener(this);
        SaveState.addActionListener(this);
        RestoreState.addActionListener(this);
        panelControler.add(addAnimal);
        panelControler.add(sleep);
        panelControler.add(wakeUp);
        panelControler.add(clear);
        panelControler.add(food);
        panelControler.add(info);
        panelControler.add(Decorate);
        panelControler.add(Duplicate);
        panelControler.add(SaveState);
        panelControler.add(RestoreState);
        panelControler.add(exit);
        panelControler.setFocusable(true);
        setLayout(new BorderLayout());
        add("South", panelControler);
        img = img_m = null;
        bgr = false;
        try { img = ImageIO.read(new File(BACKGROUND_PATH)); }
        catch (IOException e) { System.out.println("Cannot load background"); }
        try { img_m = ImageIO.read(new File(MEAT_PATH)); }
        catch (IOException e) { System.out.println("Cannot load meat"); }
        controller2.start();
    }



    public void addDialog()
    {
        if(animals.size()==MAX_ANIMAL_COUNTER)
        {
            JOptionPane.showMessageDialog(this, "You cannot add more than "+MAX_ANIMAL_COUNTER+" animals");
        }
        else
        {
            this.factory=selectFactory();
            AddAnimalDialog dial = new AddAnimalDialog("Add an animal to Zoo",factory);
            dial.setVisible(true);
        }
    }


    public void stop()
    {
        for(Animal an : animals)
            an.setSuspend();
    }


    public void start()
    {
        for(Animal an : animals)
            an.setResume();
    }


    /**
     * clear method to clear all animals and food
     */
    synchronized public void clear()
    {
        Iterator<Animal> iterator  = animals.iterator();
        while(iterator.hasNext())
        {
            Animal an = iterator.next();
            if(an.IsRunning())
            {
                an.interrupt();
                iterator.remove();
            }
        }
        Food = EFoodType.NOTFOOD;
        forFood = null;
        totalEatCount = 0;
        repaint();
    }


    /**
     * add food by choice
     */
    synchronized public void addFood()
    {
        if(Food == EFoodType.NOTFOOD){
            Object[] options = {"Meat", "Cabbage", "Lettuce"};
            int n = JOptionPane.showOptionDialog(null,
                    "Please choose food", "Food for animals",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[2]);
            switch(n) {
                case 0: // Meat
                    Food = EFoodType.MEAT;
                    break;
                case 1: // Cabbage
                    Food = EFoodType.VEGETABLE;
                    forFood = Cabbage.getInstance();
                    //forFood
                    break;
                default: // Lettuce
                    Food = EFoodType.VEGETABLE;
                    forFood = Lettuce.getInstance();

                    break;
            }
        }
        else {
            Food = EFoodType.NOTFOOD;
            forFood = null;
        }
        repaint();
    }


    /**
     * info table show info about animals on the zoo
     */
    public void info()
    {
        if(!isTableVisible)
        {
            int i=0;
            int sz = animals.size();

            String[] columnTitle = {"Animal","Color","Weight","Hor. speed","Ver. speed","Eat counter"};
            String [][] data = new String[sz+1][columnTitle.length];
            for(Animal an : animals)
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

            JTable table = new JTable(data, columnTitle);
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
     * secorate function to set a new color to exsit animal who color is natural
     */
    public void decorate()
    {
        boolean natural=false;
        for(int i=0; i<animals.size(); i++)
        {
            if(animals.get(i).getColor()=="Natural")
                natural=true;
        }
        if(natural)
        {
            DecorateDialog d = new DecorateDialog();
            d.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(this, "You do not have animals for decoration");
    }


    /**
     * open duplicate dialog
     */
    public void duplicate()
    {
        DuplicateDialog dd = new DuplicateDialog();
        dd.setVisible(true);
    }


    public void saveState()
    {
        MementoZoo zoomemento;
        try
        {
            zoomemento = new MementoZoo(animals,Food);
            if(mementos.size()<3)
            {
                mementos.add(zoomemento);
                JOptionPane.showMessageDialog(null,"The state has been saved");
            }
            else
                JOptionPane.showMessageDialog(null,"You can't save more then 3 states");
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
    }


    public void restoreState()
    {
        if(mementos.size()<1)
        {
            JOptionPane.showMessageDialog(null,"You have not saved state");
            return;
        }
        ArrayList<Animal> rAnimlas;
        String[] States = {"State 1", "State 2", "State 3", "Cancel"};
        int s = JOptionPane.showOptionDialog (null, "Please Choose state for restore", "Saved states", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, States, States[0]);
        switch(s) {
            case 0:
                if(mementos.size()>0)
                {
                    clear();
                    Food=mementos.get(0).getFood();
                    repaint();
                    rAnimlas = mementos.get(0).getList();
                    System.out.println(rAnimlas.size());
                    for(int i=0; i<rAnimlas.size(); i++)
                    {
                        addAnimal(rAnimlas.get(i).getName(),rAnimlas.get(i).getSize(),rAnimlas.get(i).getHorSpeed(),rAnimlas.get(i).getVerSpeed(),rAnimlas.get(i).getColor(),rAnimlas.get(i).getFactor());
                    }
                    mementos.remove(0);
                }
                else
                    JOptionPane.showMessageDialog(null,"There is no saved state here");

                break;
            case 1:
                if(mementos.size()>1)
                {
                    clear();
                    Food=mementos.get(1).getFood();
                    repaint();
                    rAnimlas = mementos.get(1).getList();
                    for(int i=0; i<rAnimlas.size(); i++)
                    {
                        addAnimal(rAnimlas.get(i).getName(),rAnimlas.get(i).getSize(),rAnimlas.get(i).getHorSpeed(),rAnimlas.get(i).getVerSpeed(),rAnimlas.get(i).getColor(),rAnimlas.get(i).getFactor());
                    }
                    mementos.remove(1);
                }
                else
                    JOptionPane.showMessageDialog(null,"There is no saved state here");
                break;
            case 2:
                if(mementos.size()>2)
                {
                    clear();
                    Food=mementos.get(2).getFood();
                    repaint();
                    rAnimlas = mementos.get(2).getList();
                    for(int i=0; i<rAnimlas.size(); i++)
                    {
                        addAnimal(rAnimlas.get(i).getName(),rAnimlas.get(i).getSize(),rAnimlas.get(i).getHorSpeed(),rAnimlas.get(i).getVerSpeed(),rAnimlas.get(i).getColor(),rAnimlas.get(i).getFactor());
                    }
                    mementos.remove(2);
                }
                else
                    JOptionPane.showMessageDialog(null,"There is no saved state here");

                break;
        }
    }


    public void destroy()
    {
        for(Animal an : animals)
            an.interrupt();
        controller2.interrupt();
        System.exit(0);
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
     * function to draw the right image.
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if(bgr && (img!=null))
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        if(Food == EFoodType.MEAT)
            g.drawImage(img_m, getWidth()/2-20, getHeight()/2-20, 40, 40, this);

        if((Food == EFoodType.VEGETABLE) && (forFood != null))
            forFood.drawObject(g);

        synchronized(this) {
            for(Animal an : animals)
                an.drawObject(g);
        }
    }


    synchronized public void eatFood(Animal an)
    {
        if(Food != EFoodType.NOTFOOD)
        {
            if(Food == EFoodType.VEGETABLE)
                forFood = null;
            Food = EFoodType.NOTFOOD;
            an.eatInc();
            totalEatCount++;
        }
        else
        {
            System.out.println("The "+an.getName()+" with "+an.getColor()+" color and size "+an.getSize()+" missed food.");
        }
    }


    synchronized public EFoodType checkFood(){return Food;}


    /**
     * checks if one animal can eat another
     * @param prey_eaten  :which animal is eaten
     */
    public void eatAnotherAnimal(boolean prey_eaten)
    {
        for(Animal predator : animals) {
            for(Animal prey : animals) {
                if(predator != prey && predator.getDiet().canEat(prey.getFoodtype()) && predator.getWeight()/prey.getWeight() >= 2 &&
                        (Math.abs(predator.getLocation().getX() - prey.getLocation().getX()) < prey.getSize()) &&
                        (Math.abs(predator.getLocation().getY() - prey.getLocation().getY()) < prey.getSize()) && !Objects.equals(prey.getName(), "Lion"))
                {
                    preyEating(predator,prey);
                    System.out.print("The "+predator+" cought up the "+prey+" ==> ");
                    prey.interrupt();
                    animals.remove(prey);
                    repaint();
                    prey_eaten = true;
                    break;
                }
            }
            if(prey_eaten)
                break;
        }
    }


    /**
     * add animal to the zoo
     * @param animal : animal
     * @param sz : size of the animal
     * @param hor : horizontal speed of the animal
     * @param ver : vertical speed of the animal
     * @param c : color of the animal
     * @param factor : type of the animal (Carnivore...)
     */
    public void addAnimal(String animal, int sz, int hor, int ver, String c,int factor)
    {
        Animal an = null;
        AbstractZooFactory zooFactory = null;
        if(factor==0)
            zooFactory = this.createAnimalFactory("HerbivoreFactory");
        else if(factor==1)
            zooFactory = this.createAnimalFactory("OmnivoreFactory");
        else if(factor==2)
            zooFactory = this.createAnimalFactory("CarnivoreFactory");

        if(zooFactory != null || duplicateFlag)
        {
            switch (animal) {
                case "Elephant" -> {
                    if (duplicateFlag)
                        zooFactory = this.createAnimalFactory("HerbivoreFactory");
                    factory = 0;
                    assert zooFactory != null;
                    an = zooFactory.produceAnimal("Elephant", sz, hor, ver, c);
                }
                case "Lion" -> {
                    if (duplicateFlag)
                        zooFactory = this.createAnimalFactory("CarnivoreFactory");
                    factory = 2;
                    assert zooFactory != null;
                    an = zooFactory.produceAnimal("Lion", sz, hor, ver, c);
                }
                case "Turtle" -> {
                    if (duplicateFlag)
                        zooFactory = this.createAnimalFactory("HerbivoreFactory");
                    factory = 0;
                    assert zooFactory != null;
                    an = zooFactory.produceAnimal("Turtle", sz, hor, ver, c);
                }
                case "Bear" -> {
                    if (duplicateFlag)
                        zooFactory = this.createAnimalFactory("OmnivoreFactory");
                    factory = 1;
                    assert zooFactory != null;
                    an = zooFactory.produceAnimal("Bear", sz, hor, ver, c);
                }
                default -> {
                    if (duplicateFlag)
                        zooFactory = this.createAnimalFactory("HerbivoreFactory");
                    factory = 0;
                    assert zooFactory != null;
                    an = zooFactory.produceAnimal("Giraffe", sz, hor, ver, c);
                }
            }
            if(an!=null)
            {
                an.setFactor(factory);
                animals.add(an);
                threadPool.execute(an);
                an.addObserver(controller2);
            }

            duplicateFlag=false;
        }
        factory=-1;
    }


    /**
     * select the factory
     * @return the result
     */
    private int selectFactory()
    {
        String[] FactoryType = {"Herbivore", "Omnivore", "Carnivore"};
        int dialogRes = JOptionPane.showOptionDialog (null, "Please Choose Animal Factory", "Animal Factory", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, FactoryType, FactoryType[0]);
        return dialogRes;
    }


    /**
     * create the animal by the factory type
     * @param type : type of the animal
     * @return AbstractFacory
     */
    private AbstractZooFactory createAnimalFactory (String type)
    {
        return switch (type) {
            case "HerbivoreFactory" -> new FactoryHerbivore();
            case "OmnivoreFactory" -> new FactoryOmnivore();
            case "CarnivoreFactory" -> new FactoryCarnivore();
            default -> null;
        };
    }


    synchronized public void preyEating(Animal predator, Animal prey)
    {
        predator.eatInc();
        totalEatCount -= (prey.getEatCount()-1);
    }


    /**
     * actionPerformed
     */
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == addAnimal)
            addDialog();
        if(e.getSource() == sleep)
            stop();
        if(e.getSource() == wakeUp)
            start();
        if(e.getSource() == clear)
            clear();
        if(e.getSource() == food)
            addFood();
        if(e.getSource() == info)
            info();
        if(e.getSource() == Decorate)
            decorate();
        if(e.getSource() == Duplicate)
            duplicate();
        if(e.getSource() == SaveState)
            saveState();
        if(e.getSource() == RestoreState)
            restoreState();
        if(e.getSource() == exit)
            destroy();
    }


    /**
     * check if animal has changed
     * @return true if changed
     */
    public boolean isChange() {
        boolean rc = false;
        for(Animal an : animals) {
            if(an.hasChanged()){
                rc = true;
                an.setTheChanged();
            }
        }
        return rc;
    }


    public ArrayList<Animal> getAnimals()
    {
        return animals;
    }


    /**
     * Singelton
     * @return instance of zoopanel
     */
    public static ZooPanel getInstance()
    {
        if(instance == null)
            synchronized(ZooPanel.class)
            {
                instance  = new ZooPanel();
            }
        return instance;
    }



}



