package animals;

import diet.Herbivore;
import food.EFoodType;
import mobility.Point;
/**
 * the utilities of this class is the creation of a new animal Giraffe. all function bear can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Rudy Haddad
 * @see animals.Animal
 *
 **/
public class Giraffe extends Animal {

    public Giraffe(int s,int x, int y, int h, int v, String c) {
        super("Giraffe",s,(int)(s*2.2),h,v,c);
        setLocation(new Point(0,0));
        setDiet(new Herbivore());
        loadImages("grf");
        cor_x1 = size/4;
        cor_x2 = (-size/4);
        cor_x3 = (int) (- size*0.25);
        cor_x4 = (int) (size*0.25);
        cor_y1 = (int) (-30 - size*9/10);
        cor_y3 = size/10;
        cor_x5 = -size/2;
        cor_y5 = cor_y6 = -size/10;
        cor_w = (int)(size*0.7);
    }


    /**
     * @return EFoodType : return the type of food of the animal
     */
    @Override
    public EFoodType getFoodtype() {return EFoodType.MEAT;}

    @Override
    public String getAnimalName() {
        return null;
    }

    @Override
    public void setResum() {

    }
}
