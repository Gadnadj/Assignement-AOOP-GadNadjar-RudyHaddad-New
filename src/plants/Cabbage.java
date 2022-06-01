package plants;


/**
 * class that creates cabbage objects
 * @author baroh
 */
public class Cabbage extends Plant
{
    private static Cabbage instance = null;

    public Cabbage() {
        super();
        loadImages("cabbage");
    }
    /**
     * get instance related to singelton
     * @return instance
     */
    public static Cabbage getInstance()
    {
        if (instance  == null)
            instance = new Cabbage();

        return instance;
    }
}
