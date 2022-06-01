package animals;

import diet.Omnivore;
import food.EFoodType;
import mobility.Point;
/**
 * the utilities of this class is the creation a new animal bear. all function bear can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Gad Nadjar
 **/
public class Bear extends Animal {

    public Bear(int s,int x, int y, int h, int v, String c) {
        super("Bear",s,(int)(s*1.5),h,v,c);
        setLocation(new Point(x,y));
        setDiet(new Omnivore());
        loadImages("bea");
        cor_x3 = -size/2;
        cor_x4 = 0;
        cor_y1 = -30-size/5;
        cor_y3 = (int) (size*0.3);
        cor_x5 = -size*6/7;
        cor_y5 = cor_y6 = -size/3;
        cor_h = size*2/3;
    }


    /**
     * @return the type of the bear
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
