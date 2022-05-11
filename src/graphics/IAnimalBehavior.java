package graphics;

/**
 * interface
 */
public interface IAnimalBehavior
{

        int getSize();
        void eatInc();
        int getEatCount();
        String getAnimalName();
        boolean getChanges ();
        void setChanges (boolean state);
        void setSuspended();
        void setResumed();


}
