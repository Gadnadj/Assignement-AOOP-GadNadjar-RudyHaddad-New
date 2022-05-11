/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package animals;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Mobile;
import food.IEdible;
import diet.IDiet;
import mobility.Point;
import food.EFoodType;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * the usefulness of this class is to create instances of animals that will belong to the zoo,
 * the class will allow them to perform actions on different breeds of animals such as moving them, feeding them etc...
 * @version 26.03.2022
 * @author Rudy Haddad
 * @see mobility.Mobile
 *
 */
public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior, Runnable {
    private String name;
    private double weight;
    private IDiet diet;




    private final int EAT_DISTANCE = 10;
    protected int size;
    private String col;
    private int horSpeed;
    private int verSpeed;
    private boolean coordChanged = true;

    private int x_dir;
    private int y_dir;
    private int eatCount = 0;
    private ZooPanel pan;
    private BufferedImage img1 = null;

    private BufferedImage img2 = null;

    protected Thread thread;

    protected boolean threadSuspended;

    protected int cor_x1, cor_x2, cor_x3, cor_x4, cor_x5, cor_x6;
    protected int cor_y1, cor_y2, cor_y3, cor_y4, cor_y5, cor_y6;

    protected int cor_w, cor_h;



    /**
     * @param name     : name of the animal
     //* @param location : location of the animal
     */
    public Animal(String name) {
        super();
        MessageUtility.logConstractor("Animal", name);
        this.name = name;
    }

    /**
     *
     //* @param location : location of the animal
     * @param size : size of the animal
     * @param horSpeed : horizontal speed of the animal
     * @param verSpeed : vertical speed of the animal
     * @param color : color of the animal
     * @param pan : panel of ZooPanel
     */
    public Animal(int size, int horSpeed, int verSpeed, String color, ZooPanel pan) {
        super();
        this.size = size;
        this.horSpeed = horSpeed;
        this.verSpeed = verSpeed;
        this.col = color;
        this.pan = pan;
        this.x_dir = 1;
        this.y_dir = 1;
        cor_x1=cor_x3=cor_x5=cor_x6=0;
        cor_y1=cor_y3=cor_y5=cor_y6=0;
        cor_x2=cor_y2=cor_x4=cor_y4=-1;
        cor_w = cor_h = size;
        coordChanged = false;
        thread = new Thread(this);

    }

    /**
     *
     * @param x : coordinate x
     * @return boolean
     */
    public boolean settX(int x)
    {
        this.setX(x);
        return true;
    }

    /**
     *
     * @return int : coordinate x of the animal
     */
    public int gettX()
    {
        return this.getLocation().getX();
    }

    /**
     *
     * @return int : coordinate y of the animal
     */
    public int gettY()
    {
        return this.getLocation().getY();
    }


    /**
     *
     * @param y : coordinate y
     * @return boolean
     */
    public boolean settY(int y)
    {
        this.setY(y);
        return true;
    }



    /**
     * @return EFoodType
     */
    public abstract EFoodType getFoodtype();


    /**
     * @param edible : if the type of food is edible
     * @return boolean
     */
    public abstract boolean eat(IEdible edible);

    /**
     * @return String : name of the animal
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param Name : name of the animal
     * @return boolean
     */
    public boolean setName(String Name) {
        this.name = Name;
        MessageUtility.logSetter(this.getName(), "setName", name, true);

        return true;
    }

    /**
     * @param diet : diet
     * @return boolean
     */
    public boolean setDiet(IDiet diet) {
        this.diet = diet;
        MessageUtility.logSetter(this.name, "setDiet", diet, true);
        return true;
    }


    /**
     * @return IDiet : if is edible
     */
    public IDiet getDiet() {
        return this.diet;
    }


    /**
     * @return double : weight of the animal
     */
    public double getWeight() {
        MessageUtility.logGetter(this.getName(), "getWeight", this.weight);
        return this.weight;
    }

    /**
     *
     * @param pan : panel of zoopanel
     * @return true if the placement is done
     */
    public boolean setPan(ZooPanel pan)
    {
        this.pan = pan;
        return true;
    }


    /**
     * @param weight : weight of the animal
     * @return boolean
     */
    public boolean setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
            MessageUtility.logSetter(this.name, "setWeight", this.weight, true);
            return true;

        } else {
            return false;
        }

    }

    /**
     * sound of the animal when he eats
     */
    public abstract void makeSound();


    public double move (Point p) {
        double d = super.move(p);
        if (d != 0)
        {
            double temp = getWeight();
            setWeight(temp - (d * temp * 0.00025));
            setChanges(true);
            if (getLocation().getX() <= p.getX())
                this.x_dir = 1;
            else
                this.x_dir = -1;
            if(getLocation().getY() <= p.getY())
                this.y_dir = 1;
            else this.y_dir = -1;
        }
        return d;
    }
    /**
     *
     * @return String
     */
    @Override
    public String getAnimalName() {
        return null;
    }

    /**
     *
     * @return String
     */
    @Override
    public int getSize()
    {
        return this.size;
    }


    @Override
    public void eatInc()
    {
        eatCount++;
    }

    /**
     *
     * @return int : x direction
     */
    public int getx_dir_()
    {
        return this.x_dir;
    }

    /**
     *
     * @return int : y direction
     */
    public int gety_dir_()
    {
        return this.y_dir;
    }

    /**
     *
     * @return BufferedImage : left image
     */
    public BufferedImage getImg1()
    {
        return this.img1;
    }

    /**
     *
     * @return BufferedImage : right image
     */
    public BufferedImage getImg2()
    {
        return this.img2;
    }

    /**
     *
     * @return ZooPanel : panel of ZooPanel
     */
    public ZooPanel getPan()
    {
        return this.pan;
    }


    /**
     *
     * @return true
     */
    @Override
    public boolean getChanges()
    {
        return this.coordChanged;
    }

    /**
     *
     * @param state : state
     */
    @Override
    public void setChanges(boolean state)
    {
        this.coordChanged = state;
    }

    /**
     *
     * @param nm : nm
     */
    @Override
    public void loadImages(String nm)
    {
        switch(getColor())
        {
            case "RED": {
                try {
                    img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_r_1.png"));
                    img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_r_2.png"));


                } catch (IOException e) {
                    System.out.println("Cannot load picture - loadImages / Red");
                }
                break;
            }

            case "BLUE": {
                try {
                    img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_b_1.png"));
                    img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_b_2.png"));


                } catch (IOException e) {
                    System.out.println("Cannot load picture - loadImages / Blue");
                }
                break;
            }

            case "NATURAL": {
                try {
                    img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_n_1.png"));
                    img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_n_2.png"));


                } catch (IOException e) {
                    System.out.println("Cannot load picture - loadImages / Natural");
                }
                break;
            }

        }
    }

    /**
     *
     * @param g : g
     */
    @Override
    public void drawObject(Graphics g) {
        if (this.getX_dir() == 1) // giraffe goes to the right side
            g.drawImage(this.getImg1(), this.getLocation().getX() - this.getSize() / 2, this.getLocation().getY() - this.getSize() / 10, this.getSize() / 2, this.getSize(), this.getPan());
        else // giraffe goes to the left side
            g.drawImage(this.getImg2(), this.getLocation().getX(), this.getLocation().getY() - this.getSize() / 10, this.getSize() / 2, this.getSize(), this.getPan());
    }

    /**
     *
     * @return String
     */
    @Override
    public String getColor() {

        return this.col;
    }

    /**
     *
     * @param color : color of the animal
     * @return boolean
     */
    public boolean setColor(String color)
    {
        this.col = color;
        return true;
    }


    /**
     *
     * @return int : horizontal speed
     */
    public int getHorSpeed()
    {
        return this.horSpeed;
    }

    /**
     *
     * @return int : vertical speed
     */
    public int getVerSpeed()
    {
        return this.verSpeed;
    }

    /**
     *
     * @return int : counter of animal eaten
     */
    @Override
    public int getEatCount()
    {
        return eatCount;
    }

    public boolean setX_dir(int x_dir)
    {
        this.x_dir = x_dir;
        return true;
    }

    /**
     *
     * @return int : x direction
     */
    public int getX_dir()
    {
        return this.x_dir;
    }

    /**
     *
     * @param y_dir : y direction
     * @return true if the placement is done
     */
    public boolean setY_dir(int y_dir)
    {
        this.y_dir = y_dir;
        return true;
    }

    /**
     *
     * @return int : y direction
     */
    public int getY_dir()
    {
        return this.y_dir;
    }

    public boolean setEatCount()
    {
        this.eatCount += 1;
        return true;
    }

    /**
     *
     * @return int : eat distance
     */
    public int getEatDistance()
    {
        return this.EAT_DISTANCE;
    }

    @Override
    public void setSuspended()
    {
        threadSuspended = true;
    }

    @Override
    synchronized public void setResumed()
    {
        threadSuspended = false;
        notify();
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(50);

                synchronized(this) {
                    while (threadSuspended)
                        wait();
                }
            }
            catch (InterruptedException e)
            {
                System.out.println(getName()+ " dead...");
                return;
            }

            if(this.getDiet().canEat(pan.checkFood()))
            {
                double oldSpead = Math.sqrt(horSpeed*horSpeed+verSpeed*verSpeed);
                double newHorSpeed = oldSpead*(location.getX() - pan.getWidth()/2)/
                        (Math.sqrt(Math.pow(location.getX() - pan.getWidth()/2,2)+
                                Math.pow(location.getY() - pan.getHeight()/2,2)));
                double newVerSpeed = oldSpead*(location.getY() - pan.getHeight()/2)/
                        (Math.sqrt(Math.pow(location.getX() - pan.getWidth()/2,2)+
                                Math.pow(location.getY() - pan.getHeight()/2,2)));
                int v = 1;
                if(newVerSpeed<0) { v=-1; newVerSpeed = -newVerSpeed; }
                if(newVerSpeed > 10)
                    newVerSpeed = 10;
                else if(newVerSpeed < 1) {
                    if(location.getY() != pan.getHeight()/2)
                        newVerSpeed = 1;
                    else
                        newVerSpeed = 0;
                }
                int h = 1;
                if(newHorSpeed<0) { h=-1; newHorSpeed = -newHorSpeed; }
                if(newHorSpeed > 10)
                    newHorSpeed = 10;
                else if(newHorSpeed < 1) {
                    if(location.getX() != pan.getWidth()/2)
                        newHorSpeed = 1;
                    else
                        newHorSpeed = 0;
                }
                location.setX((int)(location.getX() - newHorSpeed*h));
                location.setY((int)(location.getY() - newVerSpeed*v));
                if(location.getX()<pan.getWidth()/2)
                    x_dir = 1;
                else
                    x_dir = -1;
                if((Math.abs(location.getX()-pan.getWidth()/2)<EAT_DISTANCE) &&
                        (Math.abs(location.getY()-pan.getHeight()/2)<EAT_DISTANCE))
                {
                    pan.eatFood(this);
                }
            }
            else
            {
                location.setX(location.getX() + horSpeed*x_dir);
                location.setY(location.getY() + verSpeed*y_dir);
            }

            if(location.getX() > pan.getWidth()+cor_x1)
            {
                x_dir = -1;
                if(cor_x2!=-1)
                    location.setX(location.getX()+cor_x2);
            }
            else if(location.getX() < cor_x3)
            {
                x_dir = 1;
                if(cor_x4!=-1)
                    location.setX(cor_x4);
            }

            if(location.getY() > (pan.getHeight() + cor_y1))
            {
                y_dir = -1;
                if(cor_y2!=-1)
                    location.setY(location.getY()+cor_y2);
            }
            else if(location.getY() < cor_y3)
            {
                y_dir = 1;
                if(cor_y4!=-1)
                    location.setY(cor_y4);
            }

            setChanges(true);
        }
    }

    public void start()
    {
        this.thread.start();
    }

    public void interrupt()
    {
        this.thread.interrupt();
    }




}