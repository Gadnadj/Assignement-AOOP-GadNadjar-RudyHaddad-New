/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/

package mobility;

/** it is an interface that contains 2 methods, that return and set a location.
 *
 *  @version 27.03.2022
 *  @see animals.Animal
 *  @author Gad Nadjar
 *
 */

public interface ILocatable
{

    /**
     *
     * @return Point: the location of the animal
     */
    Point getLocation();

    /**
     * @param point : the new point of the animal
     *
     * @return boolean : true if the placement worked
     */
    boolean setLocation(Point point);
}