package animals;

import diet.Herbivore;
import food.EFoodType;
import mobility.Point;
/**
 * the utilities of this class is the creation new animal elephant. all function elephant can be use is here or
 * from supers classes.
 * @version 26.03.2022
 * @author Rudy Haddad
 * @see animals.Animal
 **/
public class Elephant extends Animal {

    public Elephant(int s,int x, int y, int h, int v, String c) {
        super("Elephant",s,s*10,h,v,c);
        setLocation(new Point(x,y));
        setDiet(new Herbivore());
        loadImages("elf");
        cor_x3 = (int) (-size*0.3);
        cor_y1 = (int) (-30-size*0.45);
        cor_y3 = (int) (size*0.25);
        cor_x5 = -size*3/4;
        cor_x6 = -size /5;
        cor_y5 = cor_y6 = -size/4;
        cor_h = (int)(size*0.7);
    }


    /**
     * @return EFoodType : return the type of food of the elephant
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
