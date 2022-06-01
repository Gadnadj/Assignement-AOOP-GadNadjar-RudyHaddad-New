package animals;

import diet.Carnivore;
import food.EFoodType;
import mobility.Point;
/**
 * the utilities of this class is the creation of a new animal Lion. all function lion can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Gad Nadjar
 * @see animals.Animal
 **/
public class Lion extends Animal {

    public Lion(int s,int x, int y, int h, int v, String c) {
        super("Lion",s,(int)(s*0.8),h,v,c);
        setLocation(new Point(x,y));
        setDiet(new Carnivore());
        loadImages("lio");
        cor_x4 = 0;
        cor_y1 = (int) (-30-size/3);
        cor_y3 = (int) (size*0.25);
        cor_x5 = cor_x6 = -size/2;
        cor_y5 = cor_y6 = -size/3;
        cor_h = (int)(size*0.73);
    }


    /**
     * @return EFoodType : return the type of food of the animal
     */
    @Override
    public EFoodType getFoodtype() {return EFoodType.NOTFOOD;}


    @Override
    public String getAnimalName() {
        return null;
    }

    @Override
    public void setResum() {

    }
}
