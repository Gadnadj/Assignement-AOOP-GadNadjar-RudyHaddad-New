/**@Author : Gad Nadjar : 337744155
 @Author : Rudy Haddad : 336351481*/


package zoo;
import food.IEdible;
import animals.*;
import mobility.Point;

import java.util.Random;
import java.util.Scanner;
import java.util.random.*;

/** this class is important class. with this, i can create an array of animal, check all information about
 * the new zoo.
 *  @version 27.03.2022
 *  @author Gad Nadjar
 *
 */
public class ZooActions {


    /**
     *  @param animal : any type of animal
     *  @param food : type of food
     *
     *  @return boolean : true if the food is edible
     */
    public static boolean eat(Object animal, IEdible food) {
        if (animal instanceof Lion || animal instanceof Giraffe || animal instanceof Elephant || animal instanceof Bear || animal instanceof Turtle) {
            if (((Animal) animal).eat(food))
                return true;
        }
        return false;
    }


    /**
     * @param animal : any type of animal
     *  @param point : new point
     *
     *  @return boolean : true if the animal moved
     */
    public static boolean move(Object animal, Point point)
    {

        double result = 0;
        if(animal instanceof Lion)
        {
            result = (((Lion) animal).move(point));
            return result != 0;
        }

        if(animal instanceof Bear)
        {
            result = (((Bear) animal).move(point));
            return result != 0;
        }

        if(animal instanceof Elephant)
        {
            result = (((Elephant) animal).move(point));
            return result != 0;
        }

        if(animal instanceof Giraffe)
        {
            result = (((Giraffe) animal).move(point));
            return result != 0;
        }

        if(animal instanceof Turtle)
        {
            result = (((Turtle) animal).move(point));
            return result != 0;
        }

        return false;
    }



    /**
     *  @param args : function main
     */
    public static void main(String[] args)
    {

        String name, color;
        int age;
        Point point1;
        double neckLength, trunkLength;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number bigger than 3 : ");
        int size = sc.nextInt();
        while(size < 3) //a rearanger
        {
            System.out.println("Wrong input, Enter a number bigger than 3 : ");
            size = sc.nextInt();

        }
        Animal[] animals = new Animal[size];
        for (int i = 0 ; i < size ; i++)
        {

            System.out.println("Choose a number between 1 and 5 : ");
            System.out.println("1 - Lion\n2 - Bear\n3 - Elephant\n4 - Giraffe\n5 - Turtle");
            int num = sc.nextInt();
            System.out.println("Enter a coordinate on X : ");
            int x = sc.nextInt();
            System.out.println("Enter a coordinate on Y : ");
            int y = sc.nextInt();
            point1 = new Point(x,y);

            while(num < 1 || num > 5)
            {
                System.out.println("Wrong number, Please enter again : ");
                System.out.println("Choose a number between 1 and 5");
                System.out.println("1 - Lion\n2 - Bear\n3 - Elephant\n4 - Giraffe\n5 - Turtle");
                num = sc.nextInt();
            }

            switch (num) {
                case 1 -> {
                    System.out.println("Enter the name of the Lion : ");
                    sc.nextLine();
                    name = sc.nextLine();
                    animals[i] = new Lion(name);
                    System.out.println(ZooActions.move(animals[i], point1));
                }
                case 2 -> {
                    System.out.println("Enter the name and the color of the bear : ");
                    sc.nextLine();
                    name = sc.nextLine();
                    color = sc.nextLine();
                    animals[i] = new Bear(name, color);
                    System.out.println(ZooActions.move(animals[i], point1));
                }
                case 3 -> {
                    System.out.println("Enter the name and the size of the elephant trunk : ");
                    sc.nextLine();
                    name = sc.nextLine();
                    trunkLength = sc.nextDouble();
                    animals[i] = new Elephant(name, trunkLength);
                    System.out.println(ZooActions.move(animals[i], point1));
                }
                case 4 -> {
                    System.out.println("Enter the name and the size of the giraffe neck : ");
                    sc.nextLine();
                    name = sc.nextLine();
                    neckLength = sc.nextDouble();
                    animals[i] = new Giraffe(name, neckLength);
                    System.out.println(ZooActions.move(animals[i], point1));
                } case 5 -> {
                    System.out.println("Enter the name and the age of the turtle : ");
                    sc.nextLine();
                    name = sc.nextLine();
                    age = sc.nextInt();
                    animals[i] = new Turtle(name, age);
                    System.out.println(ZooActions.move(animals[i], point1));
                }
            }
        }

        Random random = new Random();
        int num, num2;
        num = random.nextInt();
        for(int i = 0 ; i < size/2; i++)
        {
            num = random.nextInt(size - 1);
            num2 = random.nextInt(size - 1);
            if(num == num2)
            {
                i--;
            }
            else
            {
                System.out.println("\n\n");
                System.out.println(animals[num].getName() + " can eat : " + animals[num2].getName() + "\n");
                System.out.println(ZooActions.eat(animals[num], animals[num2]));
                System.out.println("\n");
            }


        }
        sc.close();
    }

}
