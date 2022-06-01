package graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import mobility.Point;

import javax.swing.*;

import animals.Animal;
/**
 * Duplicate Animal
 * @author Gad Nadjar, Rudy Haddad
 */
public class DuplicateDialog extends JDialog implements ActionListener {


    private JLabel selectAnimal;
    private JLabel selectHorSpeed;
    private JLabel selectVerSpeed;
    private JLabel confirmation;
    private JComboBox cselectAnimal;
    private JComboBox cselectHorSpeed;
    private JComboBox cselectVerSpeed;
    JButton bConfirmation;
    private ArrayList<Animal> animals;
    private Animal an, clone;
    int counter1= 0, counter2 = 0, counter3 = 0;


    /**
     * constructor
     */
    public DuplicateDialog()
    {

        an = clone = null;
        setSize(800, 100);
        this.setTitle("Duplicate Animal");
        this.setLayout(new GridLayout(2,3));
        this.setVisible(true);
        setResizable(false);
        this.animals = ZooPanel.getInstance().getAnimals();
        selectAnimal = new JLabel("Select Animal To Clone");
        selectHorSpeed = new JLabel("Select Horizontal Speed");
        selectVerSpeed = new JLabel("Select Vertical Speed");

        cselectAnimal = new JComboBox();
        cselectHorSpeed = new JComboBox();
        cselectVerSpeed = new JComboBox();
        confirmation = new JLabel("Confirm");

        bConfirmation = new JButton("Confirm");

        this.add(selectAnimal);
        this.add(selectHorSpeed);
        this.add(selectVerSpeed);
        this.add(confirmation);
        this.add(cselectAnimal);
        this.add(cselectHorSpeed);
        this.add(cselectVerSpeed);
        this.add(bConfirmation);

        for (int i = 0; i <= 10; i++)
            cselectHorSpeed.addItem(i);
        cselectHorSpeed.setSelectedIndex(-1);
        for (int i = 0; i <= 10; i++)
            cselectVerSpeed.addItem(i);
        cselectVerSpeed.setSelectedIndex(-1);

        for (int i = 0; i < animals.size(); i++)
        {
            String s=animals.get(i).getName()+": running=" +animals.get(i).IsRunning()+", weight="+animals.get(i).getWeight()+", color="+animals.get(i).getColor();
            cselectAnimal.addItem(s);
        }
        cselectAnimal.setSelectedIndex(-1);



        cselectAnimal.addActionListener(this);
        cselectHorSpeed.addActionListener(this);
        cselectVerSpeed.addActionListener(this);
        bConfirmation.addActionListener(this);
    }


    /**
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == cselectAnimal)
            counter1 = cselectAnimal.getSelectedIndex();
        if(e.getSource() == cselectHorSpeed)
            counter2 = cselectHorSpeed.getSelectedIndex();
        if(e.getSource() == cselectVerSpeed)
            counter3 = cselectVerSpeed.getSelectedIndex();
        if(e.getSource() == bConfirmation)
        {
            if(cselectAnimal.getSelectedIndex() == -1 || cselectHorSpeed.getSelectedIndex() == -1 || cselectVerSpeed.getSelectedIndex() == -1)
                JOptionPane.showMessageDialog(null, "Selected All Characters", "Selected All Characters", JOptionPane.ERROR_MESSAGE);
            else
            {
                an = animals.get(counter1);
                if (an != null) {
                    try {
                        clone = (Animal) an.clone();
                    } catch (CloneNotSupportedException e1) {
                        e1.printStackTrace();
                    }
                    ZooPanel.getInstance().duplicateFlag = true;
                    clone.setLocation(new Point(0, 0));
                    clone.setHorSpeed(counter2);
                    clone.setVerSpeed(counter3);
                    ZooPanel.getInstance().addAnimal(clone.getName(), an.getSize(), clone.getHorSpeed(), clone.getVerSpeed(), clone.getColor(), an.getFactor());
                }
            }
            dispose();
        }
    }
}





