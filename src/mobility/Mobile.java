/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package mobility;
import java.lang.Math;

/** this class is about movement of object. all object can move and change place. with this class, the object can
 * change place, calculate distance and check the limit of the location
 *  @version 27.03.2022
 *  @see animals.Animal
 *  @author Rudy haddad
 *
 */

public abstract class Mobile implements ILocatable {
    protected Point location = new Point(0,0);
    private Double totalDistance;


    /** @param location : location of the animal
     */
    public Mobile(Point location) {
        if(Point.checkBoundaries(location))
            this.location = location;
        this.totalDistance = 0.0;
    }

    public Mobile()
    {
        this.totalDistance = 0.0;
    }

    public boolean setX(int x)
    {
        this.location.setX(x);
        return true;
    }

    public boolean setY(int y)
    {
        this.location.setY(y);
        return true;
    }


    /**
     *
     * @return Point: the location of the animal
     */
    public Point getLocation() {
        return this.location;
    }


    /** @param point : the new point of the animal
     *
     * @return boolean : true if the placement worked
     */
    public boolean setLocation(Point point) {
        if(Point.checkBoundaries(point))
        {
            this.location.setX(point.getX());
            this.location.setY(point.getY());
            return true;
        }
        else
            return false;
    }


    /**
     *  @return double : the total distance the animal has traveled
     */
    public double gettotalDistance() {
        return this.totalDistance;
    }


    /**
     *  @param totalDistance : new distance traveled
     *
     * @return boolean : true if the placement worked
     */
    public boolean settotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
        return true;
    }


    /**
     * @param distance : the distance that the animal traveled
     *
     */
    public void addTotalDistance(double distance) {
        if (distance <= 0) {
            System.out.println("The distance must be positive !");
        } else {
            //this.totalDistance += distance;
            this.settotalDistance(gettotalDistance() + distance);
        }
    }


    /**
     * @param location : the new location of the animal
     *
     *  @return : the distance between the old and new point
     */
    public double calcDistance(Point location) {
        return Math.sqrt(Math.pow(getLocation().getX() - location.getX(), 2) + (Math.pow(getLocation().getY() - location.getY(), 2)));
    }


    /**
     * @param l : new point
     *
     * @return double : the total distance between the new and old point
     */
    public double move(Point l)
    {
        double sum = 0;
        if (this.location.getX() == l.getX() && this.location.getY() == l.getY())
        {
            return 0;
        }
        else
        {
            if (!(Point.checkBoundaries(l)))
                return 0;
            else
            {
                sum = calcDistance(l);
                addTotalDistance(sum);
                this.location.setX(l.getX());
                this.location.setY(l.getY());
                return sum;
            }
        }
    }
}