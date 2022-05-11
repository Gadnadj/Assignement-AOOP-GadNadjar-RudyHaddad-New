/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package mobility;

/** this class work with point of object. can change point with new location or check limit of the location.
 *  @version 27.03.2022
 *  @see animals.Animal
 *  @author Gad Nadjar
 */

public class Point
{
    private int x;
    private int y;
    static private final int maxX = 800;
    static private final int maxY = 600;


    /**
     * @param x : abscissa
     * @param y : ordinate
     */
    public Point(int x, int y)
    {
        if((checkBoundaries(this)))
        {
            this.x = x;
            this.y =y;
        }
    }


    /**
     * @return String : representation of point
     */
    public String toString(){return "(" + x + ", " + y + ")";}


    /**
     * @return int : coordinate on the abscissa
     */
    public int getX(){return this.x;}


    /**
     * @param x : new coordinate on the abscissa
     */
    public void setX(int x){this.x = x;}


    /**
     * @return int : coordinate on the cordinate
     */
    public int getY(){return this.y;}


    /**
     * @param y : new coordinate on the ordinate
     */
    public void setY(int y){this.y = y;}


    /**
     * @return int : max coordinate on the abscissa
     */
    public int getMaxX(){return maxX;}


    /**
     * @return int : max coordinate on the cordinate
     */
    public int getMaxY() {return maxY;}


    /**
     * @param pointToCheck : point to check

     * @return true if the point in the limitation (smaller than getMaxX and getMaxY)
     */
    public static boolean checkBoundaries(Point pointToCheck)
    {
        return pointToCheck.x <= Point.maxX && pointToCheck.x >= 0 && pointToCheck.y <= Point.maxY && pointToCheck.y >= 0;
    }
}