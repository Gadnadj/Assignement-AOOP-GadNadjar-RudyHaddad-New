package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZooPanel extends JPanel implements Runnable, ActionListener
{



    JPanel bluePanel;
    JButton addAnimal, moveAnimal, clear, food, info, exit;





    public ZooPanel()
    {
        this.setBackground(Color.BLUE);
        addAnimal = new JButton("Add Animal");
        addAnimal.addActionListener(this);
        moveAnimal = new JButton("New Animal");
        moveAnimal.addActionListener(this);
        clear = new JButton("Clear");
        clear.addActionListener(this);
        food = new JButton("Food");
        food.addActionListener(this);
        info = new JButton("Info");
        info.addActionListener(this);
        exit = new JButton("exit");
        exit.addActionListener(this);
        this.add(addAnimal);
        this.add(moveAnimal);
        this.add(clear);
        this.add(food);
        this.add(info);
        this.add(exit);



    }


    @Override
    public void run()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == addAnimal)
        {
            AddAnimalDialog a = new AddAnimalDialog();

        }

        if(e.getSource() == moveAnimal)
        {

        }

        if(e.getSource() == clear)
        {

        }

        if(e.getSource() == food)
        {

        }

        if(e.getSource() == info)
        {
            NewWindow window = new NewWindow();
        }

        if(e.getSource() == exit)
        {
            System.out.println("Bye, have a great day !");
            System.exit(1);
        }
    }

}
