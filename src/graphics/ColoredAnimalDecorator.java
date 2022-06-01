package graphics;

import animals.Animal;
/**
 * decorate the animal (change his color))
 * @author Gad Nadjar, Rudy Haddad
 */
public class ColoredAnimalDecorator implements ColoredAnimal
{
    private Animal animal;


    /**
     * constructor
     * @param animal : animal
     */
    public ColoredAnimalDecorator(Animal animal)
    {
        super();
        this.animal = animal;
    }



    /**
     * change the color of the animal
     */
    @Override
    public void PaintAnimal(String col)
    {
        Animal an = animal;
        an.setColor(col);
        String nm = null;
        if (an.getName().equals("Lion"))
            nm = "lio";
        if (an.getName().equals("Bear"))
            nm = "bea";
        if (an.getName().equals("Elephant"))
            nm = "elf";
        if (an.getName().equals("Giraffe"))
            nm = "grf";
        if (an.getName().equals("Turtle"))
            nm = "trt";
        an.loadImages(nm);
    }

}
