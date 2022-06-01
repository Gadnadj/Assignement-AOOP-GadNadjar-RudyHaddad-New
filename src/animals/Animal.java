package animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import javax.imageio.ImageIO;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import graphics.ColoredAnimal;
import graphics.ColoredAnimalDecorator;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Point;
/**
 * the usefulness of this class is to create instances of animals that will belong to the zoo,
 * the class will allow them to perform actions on different breeds of animals such as moving them, feeding them etc...
 * @version 26.03.2022
 * @author Rudy Haddad
 * @see mobility.Mobile
 *
 */
public abstract class Animal extends Observable implements IEdible,IDrawable,IAnimalBehavior, ColoredAnimal,Cloneable,Runnable {

    protected final int EAT_DISTANCE = 5;
    private IDiet diet;
    protected String name;
    private double weight;
    protected int size;
    protected String col;
    protected int horSpeed;
    protected int verSpeed;
    protected boolean coordChanged;
    protected Thread thread;
    protected int x_dir;
    protected int y_dir;
    protected int eatCount;
    protected boolean threadSuspended;
    protected BufferedImage img1, img2;
    protected int cor_x1, cor_x2, cor_x3, cor_x4, cor_x5, cor_x6;
    protected int cor_y1, cor_y2, cor_y3, cor_y4, cor_y5, cor_y6;
    protected int cor_w, cor_h;
    private boolean isRun = false;
    protected Point location;
    private int factor;



    /**
     * Default Constructor
     * @param nm : type of animal
     * @param sz : size of the animal
     * @param hor : horizontal speed of the animal
     * @param ver : vertical speed of the animal
     * @param c : color of the animal
     */
    public Animal(String nm, int sz, int w, int hor, int ver, String c) {
        this.setLocation(new Point(0,0));
        name = nm;
        size = sz;
        weight = w;
        horSpeed = hor;
        verSpeed = ver;
        col = c;
        x_dir = 1;
        y_dir = 1;
        cor_x1=cor_x3=cor_x5=cor_x6=0;
        cor_y1=cor_y3=cor_y5=cor_y6=0;
        cor_x2=cor_y2=cor_x4=cor_y4=-1;
        cor_w = cor_h = size;
        coordChanged = false;
        thread = new Thread(this);
    }
    /**
     * Clone method
     */
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }


    /**
     * @return the type of the animal
     */
    public EFoodType getFoodtype()
    {
        return EFoodType.MEAT;
    }


    /**
     * @return IDiet
     */
    public IDiet getDiet()
    {
        return diet;
    }


    /**
     * @return the name of the animal
     */
    public String getName()
    {
        return this.name;
    }


    /**
     * @return the weight of the animal
     */
    public double getWeight()
    {
        return this.weight;
    }


    /**
     * @param w : set the weight of the animal
     */
    public void setWeight(double w)
    {
        weight = w;
    }


    /**
     * @param diet : set diet
     */
    protected void setDiet(IDiet diet)
    {
        this.diet = diet;
    }


    /**
     * @return the size of the animal
     */
    public int getSize()
    {
        return size;
    }


    /**
     * @return the hor speed
     */
    public int getHorSpeed()
    {
        return horSpeed;
    }


    /**
     * @param hor : set the hor speed
     */
    public void setHorSpeed(int hor)
    {
        horSpeed  = hor;
    }


    /**
     * @return : ver speed
     */
    public int getVerSpeed()
    {
        return verSpeed;
    }


    /**
     * @param ver : set the ver speed
     */
    public void setVerSpeed(int ver)
    {
        verSpeed  = ver;
    }

    /**
     * increase 1 after animal eated
     */
    public void eatInc()
    {
        eatCount++;
    }


    /**
     * @return the number of animal eaten
     */
    public int getEatCount()
    {
        return eatCount;
    }


    /**
     * suspend thread
     */
    synchronized public void setSuspend()
    {
        threadSuspended = true;
    }


    /**
     * resume the thread
     */
    synchronized public void setResume()
    {
        threadSuspended = false;
        notify();
    }


    /**
     * @return true if the coordinate changed
     */
    synchronized public boolean getChanges()
    {
        return coordChanged;
    }


    /**
     * @param state : change the state of the animal
     */
    synchronized public void setChanges(boolean state)
    {
        coordChanged = state;
    }


    /**
     * @return the color of the animal
     */
    public String getColor()
    {
        return col;
    }


    /**
     * @param color : set the color
     */
    public void setColor(String color)
    {
        this.col=color;
    }


    /**
     * start thread
     */
    public void start()
    {
        thread.start();
    }


    /**
     * interrupt thread
     */
    public void interrupt()
    {
        isRun = false;
        thread.interrupt();
    }


    /**
     * load the images of the animal by his color
     */
    public void loadImages(String nm)
    {
        switch(getColor())
        {
            case "Red":
            {
                try
                {
                    img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_r_1.png"));
                    img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_r_2.png"));
                }
                catch (IOException e)
                {
                    System.out.println("Cannot load picture - loadImages / Red");
                }
                break;
            }

            case "Blue":
            {
                try
                {
                    img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_b_1.png"));
                    img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_b_2.png"));
                }
                catch (IOException e)
                {
                    System.out.println("Cannot load picture - loadImages / Blue");
                }
                break;
            }

            case "Natural":
            {
                try
                {
                    img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_n_1.png"));
                    img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_n_2.png"));
                }
                catch (IOException e)
                {
                    System.out.println("Cannot load picture - loadImages / Natural");
                }
                break;
            }
        }
    }


    /**
     * checks if there are any food that can be eaten, and set new direction
     * if there is no food, apply movement as normal
     */
    public void run()
    {
        isRun=true;
        while (isRun)
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

            if(this.getDiet().canEat(ZooPanel.getInstance().checkFood()))
            {
                double oldSpead = Math.sqrt(horSpeed*horSpeed+verSpeed*verSpeed);
                double newHorSpeed = oldSpead*(location.getX() - ZooPanel.getInstance().getWidth()/2)/
                        (Math.sqrt(Math.pow(location.getX() - ZooPanel.getInstance().getWidth()/2,2)+
                                Math.pow(location.getY() - ZooPanel.getInstance().getHeight()/2,2)));
                double newVerSpeed = oldSpead*(location.getY() - ZooPanel.getInstance().getHeight()/2)/
                        (Math.sqrt(Math.pow(location.getX() - ZooPanel.getInstance().getWidth()/2,2)+
                                Math.pow(location.getY() - ZooPanel.getInstance().getHeight()/2,2)));
                int v = 1;
                if(newVerSpeed<0) { v=-1; newVerSpeed = -newVerSpeed; }
                if(newVerSpeed > 10)
                    newVerSpeed = 10;
                else if(newVerSpeed < 1) {
                    if(location.getY() != ZooPanel.getInstance().getHeight()/2)
                        newVerSpeed = 1;
                    else
                        newVerSpeed = 0;
                }
                int h = 1;
                if(newHorSpeed<0) { h=-1; newHorSpeed = -newHorSpeed; }
                if(newHorSpeed > 10)
                    newHorSpeed = 10;
                else if(newHorSpeed < 1) {
                    if(location.getX() != ZooPanel.getInstance().getWidth()/2)
                        newHorSpeed = 1;
                    else
                        newHorSpeed = 0;
                }
                location.setX((int)(location.getX() - newHorSpeed*h));
                location.setY((int)(location.getY() - newVerSpeed*v));
                if(location.getX()<ZooPanel.getInstance().getWidth()/2)
                    x_dir = 1;
                else
                    x_dir = -1;
                if((Math.abs(location.getX()-ZooPanel.getInstance().getWidth()/2)<EAT_DISTANCE) &&
                        (Math.abs(location.getY()-ZooPanel.getInstance().getHeight()/2)<EAT_DISTANCE))
                {
                    ZooPanel.getInstance().eatFood(this);
                }
            }
            else
            {
                location.setX(location.getX() + horSpeed*x_dir);
                location.setY(location.getY() + verSpeed*y_dir);
            }

            if(location.getX() > ZooPanel.getInstance().getWidth()+cor_x1)
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

            if(location.getY() > (ZooPanel.getInstance().getHeight() + cor_y1))
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
            setChanged();
            notifyObservers();
            ZooPanel.getInstance().repaint();
        }
    }



    /**
     * draw the animal
     */
    public void drawObject(Graphics g)
    {

        if(x_dir==1)
        {
            g.drawImage(img1, location.getX()+cor_x5, location.getY()+cor_y5, cor_w, cor_h, ZooPanel.getInstance());
        }
        else
        {
            g.drawImage(img2, location.getX()+cor_x6, location.getY()+cor_y6, cor_w, cor_h, ZooPanel.getInstance());
        }
    }


    /**
     * representation of the animal
     * @return String
     */
    public String toString()
    {
        return "["+getName() + ": weight=" + weight + ", color="+col+"]";
    }



    /**
     * check if thread is running
     * @return true if running
     */
    public boolean IsRunning()
    {
        return this.isRun;
    }


    /**
     * create new decorate that gets this animal and paint him
     */
    @Override
    public void PaintAnimal(String col)
    {

        ColoredAnimalDecorator dec = new ColoredAnimalDecorator(this);
        dec.PaintAnimal(col);
    }


    /**
     * @return the location of the animal
     */
    public Point getLocation()
    {
        return location;
    }


    /**
     * @param newLocation : new location
     * @return true if the placement worked
     */
    public boolean setLocation(Point newLocation)
    {
        this.location = newLocation;
        return true;
    }


    /**
     * set change related to observer\listner pattern
     */
    public void setTheChanged()
    {
        setChanged();
    }


    /**
     * @return factor by int
     */
    public int getFactor()
    {
        return factor;
    }


    /**
     * set the factory type of this animal by number(0,1,2)
     * @param factor : type of factory
     */
    public void setFactor(int factor)
    {
        this.factor = factor;
    }
}
