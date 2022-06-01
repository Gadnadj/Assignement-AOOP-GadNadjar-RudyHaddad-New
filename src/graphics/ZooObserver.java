package graphics;

import java.util.Observable;
import java.util.Observer;
/**
 * class represent bserver/listner pattern
 * @author Gad Nadjar, rudy Haddad
 */
public class ZooObserver extends Thread implements Observer
{

    private final int RESOLUTION = 25;

    /**
     * notify observe
     */
    @Override
    public void update(Observable arg0, Object arg1)
    {
        synchronized(this)
        {
            notify();
        }

    }
    /**
     * run method check if animal can eat another, and repaint if there is a need
     */
    @Override
    public void run()
    {
        while(true)
        {
            if(ZooPanel.getInstance().isChange())
                ZooPanel.getInstance().repaint();


            boolean prey_eaten = false;
            synchronized(this)
            {
                ZooPanel.getInstance().eatAnotherAnimal(prey_eaten);

            }
            try
            {
                Thread.sleep(1000/RESOLUTION);
            }
            catch (InterruptedException e)
            {
                return;
            }
        }
    }

}
